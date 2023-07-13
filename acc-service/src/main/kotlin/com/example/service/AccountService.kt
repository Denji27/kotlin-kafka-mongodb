package com.example.service

import com.example.model.Account

interface AccountService {
    fun createAccount(account: Account): Account
}