package ru.likhogub.tourismo.domain.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Tour
import ru.likhogub.tourismo.persistance.service.TourDataService
import java.util.*

@Service
class TourService(val tourDataService: TourDataService) {

    fun createTour(tour: Tour): Tour {
        tour.id = UUID.randomUUID().toString()
        return tourDataService.save(tour)
    }

    fun searchTours(location: String?): List<Tour> = tourDataService.findAll(location)
}