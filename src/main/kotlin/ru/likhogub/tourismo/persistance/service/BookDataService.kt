package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Book
import ru.likhogub.tourismo.persistance.repository.BookRepository

@Service
class BookDataService(val bookRepository: BookRepository) {

    fun save(book: Book): Book = bookRepository.save(book)

    fun findAll(): List<Book> = bookRepository.findAll()

    fun findRequiredByTourIdAndCheckInIdAndBookId(tourId: String, checkInId: String, bookId: String): Book = bookRepository
            .findByIdAndTourIdAndCheckInId(bookId, tourId, checkInId)
            .orElseThrow { RuntimeException("book.not.found") }

    fun findAllByTourId(tourId: String): List<Book> = bookRepository.findAllByTourId(tourId)
}