package com.example.mvvm_network_example.domain.repository

import com.example.mvvm_network_example.data.model.User

interface UserRepository {
    suspend fun getPosts(): List<User>
}