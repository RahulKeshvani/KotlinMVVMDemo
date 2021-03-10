package com.rbk.kotlinmvvmdemo.model

import androidx.room.*


@Dao
interface TodoDao {

//    @Query("SELECT * FROM Todo")
//    val getall: List<Todo>

    @Insert
    fun insert(task: Todo)

    @Delete
    fun delete(task: Todo)

    @Update
    fun update(task: Todo)

}