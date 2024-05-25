package ru.likhogub.tourismo.persistance.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.likhogub.tourismo.domain.model.Tour

interface TourRepository : JpaRepository<Tour, String>