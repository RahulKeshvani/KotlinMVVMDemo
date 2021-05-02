package com.rbk.kotlinmvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rbk.kotlinmvvmdemo.model.MuseumRepository

/**
 * @author RBK
 */
class ViewModelFactory(private val repository: MuseumRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(repository) as T
    }
}