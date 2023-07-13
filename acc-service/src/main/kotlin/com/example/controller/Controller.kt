package com.example.controller

import com.example.model.Account
import com.example.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class Controller {
    @Autowired
    private lateinit var accountService: AccountService

    @PostMapping("/new")
    fun createAccount(@RequestBody account: Account): ResponseEntity<Account>{
        return ResponseEntity.ok(accountService.createAccount(account))
    }
}