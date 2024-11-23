package ru.likhogub.tourismo

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	servers = [
		Server(url = "/")
	]
)
class TourismoApplication

fun main(args: Array<String>) {
	runApplication<TourismoApplication>(*args)
}
