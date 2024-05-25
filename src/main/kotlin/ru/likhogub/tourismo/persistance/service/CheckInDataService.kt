package ru.likhogub.tourismo.persistance.service

import org.springframework.stereotype.Service
import ru.likhogub.tourismo.domain.model.CheckIn

@Service
class CheckInDataService {

    private val data = mutableMapOf<String, CheckIn>()

    fun save(checkIn: CheckIn): CheckIn {
        data[checkIn.id!!] = checkIn
        return checkIn
    }

    fun findRequiredByIdAndTourId(id: String, tourId: String): CheckIn {
        return data.values
                   .find { checkIn -> checkIn.id == id && checkIn.tourId == tourId }
                   ?: throw RuntimeException("checkin.not.found")
    }

    fun findAll(): List<CheckIn> = data.values.toList()
}