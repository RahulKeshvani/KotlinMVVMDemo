package com.rbk.kotlinmvvmdemo.model

import android.content.Context
import androidx.room.Room


class DatabaseClient private constructor(private val mCtx: Context) {
    //our app database object
    var appDatabase: AppDatabase? = null
    init {
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyToDos").build()

        //creating the app database with Room database builder
        //MyToDos is the name of the database
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