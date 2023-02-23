package com.example.mvvm_network_example.data.api

import com.example.mvvm_network_example.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): Response<List<User>>
}