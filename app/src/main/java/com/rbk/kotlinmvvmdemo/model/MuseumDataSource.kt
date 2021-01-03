package com.rbk.kotlinmvvmdemo.model

import com.rbk.kotlinmvvmdemo.data.OperationCallback

interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}