package ru.likhogub.tourismo.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "checkin")
class CheckIn(
    @Id
    var id: String?,
    var tourId: String?,
    val totalCount: Int,
    var availableCount: Int?,
    val startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime?
)