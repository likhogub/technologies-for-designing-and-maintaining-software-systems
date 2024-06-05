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

    @PutMapping("/tours/{tourId}/checkins/{checkInId}/books/{bookId}/approval")
    fun approveBook(
        @PathVariable("tourId") tourId: String,
        @PathVariable("checkInId") checkInId: String,
        @PathVariable("bookId") bookId: String
    ): Book = bookService.approveBook(tourId, checkInId, bookId)

    @PutMapping("/tours/{tourId}/checkins/{checkInId}/books/{bookId}/rejection")
    fun rejectBook(
        @PathVariable("tourId") tourId: String,
        @PathVariable("checkInId") checkInId: String,
        @PathVariable("bookId") bookId: String
    ): Book = bookService.rejectBook(tourId, checkInId, bookId)

    @GetMapping("/books/search")
    fun searchBooks(): List<Book> = bookService.searchBooks()

    @GetMapping("/tours/{tourId}/books/search")
    fun searchBooksForTour(
        @PathVariable("tourId") tourId: String
    ): List<Book> = bookService.searchBooksForTour(tourId)
}