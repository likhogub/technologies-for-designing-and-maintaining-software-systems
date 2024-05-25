package ru.likhogub.tourismo.domain.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.CheckIn
import ru.likhogub.tourismo.persistance.service.CheckInDataService
import ru.likhogub.tourismo.persistance.service.TourDataService
import java.time.LocalDate
import java.util.*

@Service
class CheckInService(val checkInDataService: CheckInDataService,
                     val tourDataService: TourDataService) {

    fun createCheckIn(tourId: String, checkIn: CheckIn): CheckIn {
        val tour = tourDataService.findRequiredById(tourId)
        checkIn.id = UUID.randomUUID().toString()
        checkIn.tourId = tourId
        checkIn.availableCount = checkIn.totalCount
        checkIn.endDateTime = checkIn.startDateTime.plusDays(tour.duration.toLong())
        return checkInDataService.save(checkIn)
    }

    fun searchCheckins(
        tourId: String,
        startDateFrom: LocalDate?,
        startDateTo: LocalDate?,
        endDateFrom: LocalDate?,
        endDateTo: LocalDate?
    ): List<CheckIn> = checkInDataService.findAll(
        tourId,
        startDateFrom,
        startDateTo,
        endDateFrom,
        endDateTo
    )
}