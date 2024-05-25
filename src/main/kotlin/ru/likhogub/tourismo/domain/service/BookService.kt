package ru.likhogub.tourismo.domain.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Book
import ru.likhogub.tourismo.domain.model.BookStatus
import ru.likhogub.tourismo.persistance.service.BookDataService
import ru.likhogub.tourismo.persistance.service.CheckInDataService
import java.util.UUID.randomUUID

@Service
class BookService(val bookDataService: BookDataService,
                  val checkInDataService: CheckInDataService) {

    fun createBook(tourId: String, checkInId: String, book: Book): Book {
        val checkIn = checkInDataService.findRequiredByIdAndTourId(checkInId, tourId)
        if (checkIn.availableCount!! < book.touristsCount) {
            throw RuntimeException("no.places.available")
        }
        book.id = randomUUID().toString()
        book.tourId = tourId
        book.checkInId = checkInId
        book.status = BookStatus.PENDING
        return bookDataService.save(book)
    }

    fun searchBooks(): List<Book> = bookDataService.findAll()

    fun approveBook(tourId: String, checkInId: String, bookId: String): Book {
        val book = bookDataService.findRequiredByTourIdAndCheckInIdAndBookId(tourId, checkInId, bookId)
        if (book.status != BookStatus.PENDING) {
            throw RuntimeException("book.not.pending")
        }
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
}