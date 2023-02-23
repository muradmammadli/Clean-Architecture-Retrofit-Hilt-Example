package com.example.mvvm_network_example.data.di

import com.example.mvvm_network_example.data.api.UserApi
import com.example.mvvm_network_example.data.common.Constants.BASE_URL
import com.example.mvvm_network_example.data.repository.UserRepositoryImpl
import com.example.mvvm_network_example.data.repository.dataSource.DataSource
import com.example.mvvm_network_example.data.repository.dataSourceImpl.DataSourceImpl
import com.example.mvvm_network_example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesUserApi():UserApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataSource(userApi: UserApi):DataSource{
        return DataSourceImpl(userApi)
    }

    @Provides
    @Singleton
    fun provideRepository(dataSource: DataSource):UserRepository{
        return UserRepositoryImpl(dataSource)
    }



}