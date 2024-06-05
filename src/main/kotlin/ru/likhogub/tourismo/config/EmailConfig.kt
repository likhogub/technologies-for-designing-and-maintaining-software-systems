package ru.likhogub.tourismo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EmailConfig(@Value("\${MODERATOR_EMAIL}")
                  val moderatorEmail: String,
                  @Value("\${EMAIL_USER}")
                  val emailUser: String,
                  @Value("\${EMAIL_PASS}")
                  val emailPass: String)