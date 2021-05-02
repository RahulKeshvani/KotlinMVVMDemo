package com.rbk.kotlinmvvmdemo.model

import android.content.Context
import androidx.room.Room


class DatabaseClient private constructor(mCtx: Context) {
    var appDatabase: AppDatabase? = null
    init {
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyToDos").build()

    }

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance as DatabaseClient
        }
    }
}