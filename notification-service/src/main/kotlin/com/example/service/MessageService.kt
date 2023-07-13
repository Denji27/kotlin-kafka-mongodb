package com.example.service

import com.example.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class MessageService {
    @Autowired
    private lateinit var notificationService: NotificationService

    @KafkaListener(id = "notificationGroup", topics = ["notification"])
    fun listen(@Payload message: Message){
        notificationService.sendNotificationEmail(message)
    }
}