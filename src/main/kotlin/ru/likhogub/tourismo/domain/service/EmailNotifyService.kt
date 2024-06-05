package ru.likhogub.tourismo.domain.service

import jakarta.mail.*
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage
import org.springframework.stereotype.Service
import ru.likhogub.tourismo.config.EmailConfig
import java.util.*


@Service
class EmailNotifyService(val emailConfig: EmailConfig) {

    fun send(email: String, subject: String, text: String) {
        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.port"] = "587"
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.debug"] = "true"
        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(emailConfig.emailUser, emailConfig.emailPass)
            }
        })
        val message = MimeMessage(session)
        message.setFrom(InternetAddress(emailConfig.emailUser))
        message.setRecipient(Message.RecipientType.TO, InternetAddress(email))
        message.subject = subject
        message.setText(text, "UTF-8")
        message.sentDate = Date()
        Transport.send(message)
    }
}