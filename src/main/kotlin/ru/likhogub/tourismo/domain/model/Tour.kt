package ru.likhogub.tourismo.domain.model

class Tour(
    var id: String?,
    val title: String,
    val description: String,
    val duration: Int,
    val location: String
)
