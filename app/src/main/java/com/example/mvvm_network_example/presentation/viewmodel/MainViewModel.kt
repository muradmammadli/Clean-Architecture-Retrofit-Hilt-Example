package com.example.mvvm_network_example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_network_example.data.model.User
import com.example.mvvm_network_example.data.repository.UserRepositoryImpl
import com.example.mvvm_network_example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        getUsers()
    }
    private fun getUsers(){
        viewModelScope.launch {
            _users.value = userRepository.getPosts()
        }
    }


}