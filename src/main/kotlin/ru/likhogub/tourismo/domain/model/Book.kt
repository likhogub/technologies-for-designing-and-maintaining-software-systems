package ru.likhogub.tourismo.domain.model

class Book(
    var id: String?,
    var tourId: String?,
    var checkInId: String?,
    val tourists: List<Tourist>,
    var status: BookStatus?,
) {
    val touristsCount
        get() = tourists.size
}

enum class BookStatus {

    PENDING,
    APPROVED,
    REJECTED
}