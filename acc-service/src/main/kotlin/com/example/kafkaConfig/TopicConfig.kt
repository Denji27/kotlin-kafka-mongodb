package com.example.kafkaConfig

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TopicConfig {
    @Bean
    fun notification(): NewTopic {
        return NewTopic("notification", 2, 3)
    }

}