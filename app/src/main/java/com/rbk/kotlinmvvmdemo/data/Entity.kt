package com.rbk.kotlinmvvmdemo.data

import com.google.gson.annotations.SerializedName
import com.rbk.kotlinmvvmdemo.model.Museum

/**
 * @author Eduardo Medina
 */
data class MuseumResponse(
    val status: Int?,
    val msg: String?,
    val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}