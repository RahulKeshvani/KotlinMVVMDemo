package com.rbk.kotlinmvvmdemo.model

import androidx.room.RoomDatabase
import androidx.room.Database


@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TodoDao


}