package ru.likhogub.tourismo.rest

import org.springframework.web.bind.annotation.*
import ru.likhogub.tourismo.domain.model.Book
import ru.likhogub.tourismo.domain.service.BookService

@RestController
@RequestMapping("/api/v1")
class BookController(val bookService: BookService) {

    @PostMapping("/tours/{tourId}/checkins/{checkInId}/books")
    fun createBook(
        @PathVariable("tourId") tourId: String,
        @PathVariable("checkInId") checkInId: String,
        @RequestBody book: Book
    ): Book = bookService.createBook(tourId, checkInId, book)

    @GetMapping("/books/search")
    fun searchBooks(): List<Book> = bookService.searchBooks()
}