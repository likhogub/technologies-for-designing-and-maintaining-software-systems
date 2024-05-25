package ru.likhogub.tourismo.domain.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Book
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
        return bookDataService.save(book)
    }

    fun searchBooks(): List<Book> = bookDataService.findAll()
}