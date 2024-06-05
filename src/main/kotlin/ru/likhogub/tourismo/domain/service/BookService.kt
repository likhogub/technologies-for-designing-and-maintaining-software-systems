package ru.likhogub.tourismo.domain.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.config.EmailConfig
import ru.likhogub.tourismo.domain.model.Book
import ru.likhogub.tourismo.domain.model.BookStatus
import ru.likhogub.tourismo.persistance.service.BookDataService
import ru.likhogub.tourismo.persistance.service.CheckInDataService
import java.util.UUID.randomUUID

@Service
class BookService(val bookDataService: BookDataService,
                  val checkInDataService: CheckInDataService,
                  val emailNotifyService: EmailNotifyService,
                  val emailConfig: EmailConfig) {

    fun createBook(tourId: String, checkInId: String, book: Book): Book {
        val checkIn = checkInDataService.findRequiredByIdAndTourId(checkInId, tourId)
        if (book.touristsCount == 0) {
            throw RuntimeException("at.least.one.tourist.required")
        }
        if (checkIn.availableCount!! < book.touristsCount) {
            throw RuntimeException("no.places.available")
        }
        book.id = randomUUID().toString()
        book.tourId = tourId
        book.checkInId = checkInId
        book.status = BookStatus.PENDING
        val savedBook = bookDataService.save(book)
        emailNotifyService.send(
            emailConfig.moderatorEmail,
            "Заявка на бронирование",
            "Создана новая заявка на бронирование ${book.id}"
        )
        return savedBook
    }

    fun searchBooks(): List<Book> = bookDataService.findAll()

    fun approveBook(tourId: String, checkInId: String, bookId: String): Book {
        val book = bookDataService.findRequiredByTourIdAndCheckInIdAndBookId(tourId, checkInId, bookId)
        if (book.status != BookStatus.PENDING) {
            throw RuntimeException("book.not.pending")
        }
        val checkIn = checkInDataService.findRequiredByIdAndTourId(checkInId, tourId)
        if (checkIn.availableCount!! < book.touristsCount) {
            throw RuntimeException("no.places.available")
        }
        checkIn.availableCount = checkIn.availableCount!! - book.touristsCount
        book.status = BookStatus.APPROVED
        return bookDataService.save(book)
    }

    fun rejectBook(tourId: String, checkInId: String, bookId: String): Book {
        val book = bookDataService.findRequiredByTourIdAndCheckInIdAndBookId(tourId, checkInId, bookId)
        if (book.status != BookStatus.PENDING) {
            throw RuntimeException("book.not.pending")
        }
        book.status = BookStatus.REJECTED
        return bookDataService.save(book)
    }

    fun searchBooksForTour(tourId: String): List<Book> = bookDataService.findAllByTourId(tourId)
}