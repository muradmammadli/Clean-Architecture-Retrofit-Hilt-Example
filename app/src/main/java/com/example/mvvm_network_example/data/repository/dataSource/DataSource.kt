package com.example.mvvm_network_example.data.repository.dataSource

import com.example.mvvm_network_example.data.model.User

interface DataSource {
    suspend fun getUsers():List<User>
}