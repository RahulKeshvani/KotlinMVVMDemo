package com.rbk.kotlinmvvmdemo.data

import com.rbk.kotlinmvvmdemo.model.Museum

data class MuseumResponse(
    val status: Int?,
    val msg: String?,
    val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}