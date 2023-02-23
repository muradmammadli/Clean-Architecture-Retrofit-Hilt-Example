package com.example.mvvm_network_example.data.repository

import com.example.mvvm_network_example.data.api.UserApi
import com.example.mvvm_network_example.data.model.User
import com.example.mvvm_network_example.data.repository.dataSource.DataSource
import com.example.mvvm_network_example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource:DataSource
) : UserRepository {
    override suspend fun getPosts(): List<User> {
        return dataSource.getUsers()
    }
}