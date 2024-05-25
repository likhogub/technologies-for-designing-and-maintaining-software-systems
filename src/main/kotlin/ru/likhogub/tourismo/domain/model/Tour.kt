package ru.likhogub.tourismo.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tour")
class Tour(
    @Id
    var id: String?,
    val title: String,
    val description: String,
    val duration: Int,
    val location: String
)
