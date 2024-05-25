package ru.likhogub.tourismo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TourismoApplication

fun main(args: Array<String>) {
	runApplication<TourismoApplication>(*args)
}
