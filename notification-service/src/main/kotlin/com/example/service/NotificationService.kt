package com.example.service

import com.example.email.EmailService
import com.example.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotificationService {
    @Autowired
    private lateinit var emailService: EmailService

    fun sendNotificationEmail(message: Message){
        emailService.sendMail(message)
    }
}