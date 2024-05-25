package ru.likhogub.tourismo.domain.model

class Book(
    var id: String?,
    var tourId: String?,
    var checkInId: String?,
    var touristsCount: Int,
    var status: BookStatus?
)

enum class BookStatus {

    PENDING,
    APPROVED,
    REJECTED
}