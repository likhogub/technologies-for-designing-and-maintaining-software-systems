package ru.likhogub.tourismo.domain.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.CheckIn
import ru.likhogub.tourismo.persistance.service.CheckInDataService
import java.util.*

@Service
class CheckInService(val checkInDataService: CheckInDataService) {

    fun createCheckIn(tourId: String, checkIn: CheckIn): CheckIn {
        checkIn.id = UUID.randomUUID().toString()
        checkIn.tourId = tourId
        checkIn.availableCount = checkIn.totalCount
        return checkInDataService.save(checkIn)
    }

    fun searchCheckins(tourId: String): List<CheckIn> = checkInDataService.findAll()
}