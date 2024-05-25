package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Book

@Service
class BookDataService {

    private val data = mutableMapOf<String, Book>()

    fun save(book: Book): Book {
        data[book.id!!] = book
        return book
    }

    fun findAll(): List<Book> = data.values.toList()

    fun findRequiredByTourIdAndCheckInIdAndBookId(tourId: String, checkInId: String, bookId: String): Book = data
        .values
        .find { book -> book.id == bookId && book.tourId == tourId && book.checkInId == checkInId }
        ?: throw RuntimeException("book.not.found")
}