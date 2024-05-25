package ru.likhogub.tourismo.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.likhogub.tourismo.domain.model.CheckIn
import ru.likhogub.tourismo.domain.service.CheckInService
import java.time.LocalDate

@RestController
@RequestMapping("/api/v1")
class CheckInController(val checkInService: CheckInService) {

    @PostMapping("/tours/{tourId}/checkins")
    fun createCheckIn(
        @PathVariable("tourId") tourId: String,
        @RequestBody checkIn: CheckIn
    ): CheckIn = checkInService.createCheckIn(tourId, checkIn)

    @GetMapping("/tours/{tourId}/checkins/search")
    fun searchCheckIns(
        @PathVariable("tourId") tourId: String,
        @RequestParam("startDateFrom") startDateFrom: LocalDate?,
        @RequestParam("startDateTo") startDateTo: LocalDate?,
        @RequestParam("endDateFrom") endDateFrom: LocalDate?,
        @RequestParam("endDateTo") endDateTo: LocalDate?
    ): List<CheckIn> = checkInService.searchCheckins(
        tourId,
        startDateFrom,
        startDateTo,
        endDateFrom,
        endDateTo
    )
}