package ru.likhogub.tourismo.domain.model

import java.time.LocalDateTime

class CheckIn(
    var id: String?,
    var tourId: String?,
    val totalCount: Int,
    var availableCount: Int?,
    val startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime?
)