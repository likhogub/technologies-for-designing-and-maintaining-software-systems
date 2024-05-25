package ru.likhogub.tourismo.persistance.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.likhogub.tourismo.domain.model.Book
import java.util.*

interface BookRepository : JpaRepository<Book, String> {

    fun findByIdAndTourIdAndCheckInId(id: String,
                                      tourId: String,
                                      checkIn: String): Optional<Book>
}