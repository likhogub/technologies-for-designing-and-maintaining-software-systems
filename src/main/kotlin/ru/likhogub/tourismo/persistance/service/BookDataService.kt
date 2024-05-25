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
}