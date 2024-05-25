package ru.likhogub.tourismo.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "book")
class Book(
    @Id
    var id: String?,
    var tourId: String?,
    var checkInId: String?,
    @JdbcTypeCode(SqlTypes.JSON)
    val tourists: List<Tourist>,
    @Enumerated(EnumType.STRING)
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