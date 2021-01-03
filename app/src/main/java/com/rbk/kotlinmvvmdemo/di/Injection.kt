package com.rbk.kotlinmvvmdemo.di

import androidx.lifecycle.ViewModelProvider
import com.rbk.kotlinmvvmdemo.data.ApiClient
import com.rbk.kotlinmvvmdemo.data.MuseumRemoteDataSource
import com.rbk.kotlinmvvmdemo.model.MuseumDataSource
import com.rbk.kotlinmvvmdemo.model.MuseumRepository
import com.emedinaa.kotlinmvvm.viewmodel.ViewModelFactory

object Injection {

    private val museumDataSource: MuseumDataSource = MuseumRemoteDataSource(ApiClient)
    private val museumRepository = MuseumRepository(museumDataSource)
    private val museumViewModelFactory = ViewModelFactory(museumRepository)

    fun providerRepository(): MuseumDataSource {
        return museumDataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return museumViewModelFactory
    }
}