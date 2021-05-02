package com.rbk.kotlinmvvmdemo.rx

import android.content.Context
import com.rbk.kotlinmvvmdemo.model.DatabaseClient
import com.rbk.kotlinmvvmdemo.model.Todo
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

class DatabaseOperations{
    companion object {
        fun addTodo(context:Context,todo:Todo){
            Completable.fromRunnable {
                DatabaseClient.getInstance(context).appDatabase
                    ?.taskDao()
                    ?.insert(todo)
            }.subscribeOn(Schedulers.io()).subscribe()

        }
        fun removeAllTodos(context:Context){
            Completable.fromRunnable {
                DatabaseClient.getInstance(context).appDatabase
                    ?.taskDao()
                    ?.removeAllTodos()
            }.subscribeOn(Schedulers.io()).subscribe()

        }
    }
}