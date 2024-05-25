package ru.likhogub.tourismo.rest

import org.springframework.web.bind.annotation.*
import ru.likhogub.tourismo.domain.model.Tour
import ru.likhogub.tourismo.domain.service.TourService

@RestController
@RequestMapping("/api/v1")
class TourController(val tourService: TourService) {

    @PostMapping("/tours")
    fun createTour(@RequestBody tour: Tour): Tour = tourService.createTour(tour)

    @GetMapping("/tours/search")
    fun searchTours(@RequestParam("location") location: String?): List<Tour> = tourService.searchTours(location)
}