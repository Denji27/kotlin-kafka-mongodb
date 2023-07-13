package com.example.service.Impl

import com.example.model.Account
import com.example.model.Message
import com.example.repository.AccountRepository
import com.example.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl : AccountService {
    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, Any>

    override fun createAccount(account: Account): Account {
        accountRepository.save(account)
        var message = Message(
            account.email,
            account.name,
            "Welcome to the system",
            "Dear ${account.name}, Thanks for subscribing to our system!"
        )
        kafkaTemplate.send("notification", message)
        return account
    }
}