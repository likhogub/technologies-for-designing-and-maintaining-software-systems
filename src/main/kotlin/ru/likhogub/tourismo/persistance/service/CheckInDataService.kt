package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.CheckIn
import ru.likhogub.tourismo.persistance.repository.CheckInRepository
import java.time.LocalDate

@Service
class CheckInDataService(val checkInRepository: CheckInRepository) {

    fun save(checkIn: CheckIn): CheckIn = checkInRepository.save(checkIn)

    fun findRequiredByIdAndTourId(id: String, tourId: String): CheckIn = checkInRepository
        .findByIdAndTourId(id, tourId)
        .orElseThrow { RuntimeException("checkin.not.found") }

    fun findAll(
        tourId: String,
        startDateFrom: LocalDate?,
        startDateTo: LocalDate?,
        endDateFrom: LocalDate?,
        endDateTo: LocalDate?
    ): List<CheckIn> = checkInRepository
        .findAll()
        .filter { checkIn ->
            if (startDateFrom != null) {
                !checkIn.startDateTime.isBefore(startDateFrom.atStartOfDay())
            }
            if (startDateTo != null) {
                !checkIn.startDateTime.isAfter(startDateTo.atStartOfDay())
            }
            if (endDateFrom != null) {
                !checkIn.endDateTime!!.isBefore(endDateFrom.atStartOfDay())
            }
            if (endDateTo != null) {
                !checkIn.endDateTime!!.isAfter(endDateTo.atStartOfDay())
            }
            true
        }
}