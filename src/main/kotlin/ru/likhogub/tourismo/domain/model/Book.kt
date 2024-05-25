package ru.likhogub.tourismo.domain.model

class Book(
    var id: String?,
    var tourId: String?,
    var checkInId: String?,
    val tourists: List<Tourist>,
    val touristsCount: Int = tourists.size,
    var status: BookStatus?,
)

enum class BookStatus {

    PENDING,
    APPROVED,
    REJECTED
}