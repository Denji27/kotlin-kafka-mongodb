package com.example.email

import com.example.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import javax.mail.internet.MimeMessage

@Component
class EmailService {
    @Autowired
    private lateinit var javaMailSender: JavaMailSender

    fun sendMail(message: Message){
        var mimeMessage = javaMailSender.createMimeMessage()
        var mimeMessageHelper = MimeMessageHelper(mimeMessage)
        mimeMessageHelper.setFrom("noreply@example.com")
        message.to?.let { mimeMessageHelper.setTo(it) }
        message.subject?.let { mimeMessageHelper.setSubject(it) }
        message.content?.let { mimeMessageHelper.setText(it) }
        javaMailSender.send(mimeMessage)
    }
}