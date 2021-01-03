package com.rbk.kotlinmvvmdemo.model

import java.io.Serializable

//data class Museum(val id: Int, val name: String, val photo: String) : Serializable
data class Museum(
    val id: Int,
    val name: String?=null,
    val brewery_type: String?=null,
    val street: String?=null,
    val city: String?=null,
    val state: String?=null,
    val longitude: String,
    val latitude: String,
    val website_url: String?=null,
    val phone: String?=null,
    val photo: String
) : Serializable