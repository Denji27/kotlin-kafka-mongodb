package com.example.email

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.Properties

@Configuration
class EmailConfig {
    @Bean
    fun javaMailSender(): JavaMailSender{
        var javaMailSender = JavaMailSenderImpl()
        javaMailSender.host="sandbox.smtp.mailtrap.io"
        javaMailSender.port=2525
        javaMailSender.username="c20806b08e63dd"
        javaMailSender.password="1982cded2c60e0"

        var properties = javaMailSender.javaMailProperties
        properties["mail.smtp.auth"] = "true"
        properties["mail.smtp.starttls.enable"] = "true"
        return javaMailSender
    }
}