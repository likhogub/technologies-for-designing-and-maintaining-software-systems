package ru.likhogub.tourismo.domain.model

class CheckIn(
    var id: String?,
    var tourId: String?,
    val totalCount: Int,
    var availableCount: Int?
)