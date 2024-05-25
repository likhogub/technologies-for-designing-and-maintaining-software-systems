package ru.likhogub.tourismo.persistance.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.likhogub.tourismo.domain.model.CheckIn
import java.util.*

interface CheckInRepository : JpaRepository<CheckIn, String> {

    fun findByIdAndTourId(id: String, tourId: String): Optional<CheckIn>
}