package ru.likhogub.tourismo.domain.model

import java.time.LocalDate

class Tourist(
    val name: String,
    val birthDate: LocalDate,
    val gender: Gender,
    val email: String,
    val phone: String
)

enum class Gender {

    MALE,
    FEMALE
}