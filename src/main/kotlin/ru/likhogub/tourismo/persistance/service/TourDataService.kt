package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.Tour
import ru.likhogub.tourismo.persistance.repository.TourRepository

@Service
class TourDataService(val tourRepository: TourRepository) {

    fun save(tour: Tour): Tour = tourRepository.save(tour)

    fun findRequiredById(tourId: String): Tour = tourRepository
        .findById(tourId)
        .orElseThrow { RuntimeException("tour.not.found") }

    fun findAll(location: String?): List<Tour> = tourRepository
        .findAll()
        .filter {
            if (location != null) {
                it.location == location
            } else {
                true
            }
        }
}