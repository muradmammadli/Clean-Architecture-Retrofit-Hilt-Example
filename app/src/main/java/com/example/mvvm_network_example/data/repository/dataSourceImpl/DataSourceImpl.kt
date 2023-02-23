package com.example.mvvm_network_example.data.repository.dataSourceImpl

import com.example.mvvm_network_example.data.api.UserApi
import com.example.mvvm_network_example.data.model.User
import com.example.mvvm_network_example.data.repository.dataSource.DataSource
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    val userApi: UserApi
) : DataSource {
    override suspend fun getUsers(): List<User> {
        return userApi.getUsers().body()!!
    }
}