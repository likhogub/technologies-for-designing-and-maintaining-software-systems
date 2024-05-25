package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Tour

@Service
class TourDataService {

    private val data = mutableMapOf<String, Tour>()

    fun save(tour: Tour): Tour {
        data[tour.id!!] = tour
        return tour
    }

    fun findAll(): List<Tour> = data.values.toList()
}