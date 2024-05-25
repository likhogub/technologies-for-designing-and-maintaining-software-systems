package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.CheckIn
import java.time.LocalDate

@Service
class CheckInDataService {

    private val data = mutableMapOf<String, CheckIn>()

    fun save(checkIn: CheckIn): CheckIn {
        data[checkIn.id!!] = checkIn
        return checkIn
    }

    fun findRequiredByIdAndTourId(id: String, tourId: String): CheckIn {
        return data
            .values
            .find { checkIn -> checkIn.id == id && checkIn.tourId == tourId }
            ?: throw RuntimeException("checkin.not.found")
    }

    fun findAll(
        tourId: String,
        startDateFrom: LocalDate?,
        startDateTo: LocalDate?,
        endDateFrom: LocalDate?,
        endDateTo: LocalDate?
    ): List<CheckIn> = data
        .values
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