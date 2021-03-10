package com.rbk.kotlinmvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rbk.kotlinmvvmdemo.R
import com.rbk.kotlinmvvmdemo.model.DatabaseClient
import com.rbk.kotlinmvvmdemo.model.Todo
import kotlinx.android.synthetic.main.activity_add_or_edit_todo.*

class AddOrEditTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_or_edit_todo)


        actTodoAdd.setOnClickListener {
            if(actTodoName.text.toString().isEmpty()){
                return@setOnClickListener
            }
            if(actTodoType.text.toString().isEmpty()){
                return@setOnClickListener
            }
            var task = Todo(1,actTodoName.text.toString(),actTodoType.text.toString(),2,false,"")
            DatabaseClient.getInstance(applicationContext).appDatabase
                ?.taskDao()
                ?.insert(task)
        }
    }
}

