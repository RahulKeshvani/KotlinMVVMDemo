package com.rbk.kotlinmvvmdemo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String?=null,

    @ColumnInfo(name = "type")
    var type: String?=null,


    @ColumnInfo(name = "priority")
    var priority: Int?=null,

    @ColumnInfo(name = "is_completed")
    var is_completed: Boolean?=null,

    @ColumnInfo(name = "created_on")
    var created_on: String?=null

) : Serializable

data class OptionType(
    val id: Int,
    val name: String?=null
) : Serializable