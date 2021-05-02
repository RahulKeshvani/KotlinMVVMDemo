package com.rbk.kotlinmvvmdemo.model

import androidx.room.*


@Dao
interface TodoDao {


    @Query("SELECT * FROM todo")
    fun getAllTodos():List<Todo>

    @Query("DELETE FROM todo")
    fun removeAllTodos()


    @Insert
    fun insert(task: Todo)

    @Delete
    fun delete(task: Todo)

    @Update
    fun update(task: Todo)

}