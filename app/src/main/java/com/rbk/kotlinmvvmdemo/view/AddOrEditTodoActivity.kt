package com.rbk.kotlinmvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rbk.kotlinmvvmdemo.model.Todo
import com.rbk.kotlinmvvmdemo.rx.DatabaseOperations
import kotlinx.android.synthetic.main.activity_add_or_edit_todo.*
import android.widget.Toast

class AddOrEditTodoActivity : AppCompatActivity() {

    var type="DEFAULT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.rbk.kotlinmvvmdemo.R.layout.activity_add_or_edit_todo)


        actTodoAdd.setOnClickListener {
            if(actTodoName.text.toString().isEmpty()){
                return@setOnClickListener
            }
            if(actTodoType.text.toString().isEmpty()){
                return@setOnClickListener
            }

            val task = Todo(null,actTodoName.text.toString(),actTodoType.text.toString(),actTodoType.text.toString().toInt(),false,"")
            DatabaseOperations.addTodo(applicationContext,task)

            Toast.makeText(this,"Added Successfully",Toast.LENGTH_SHORT).show()

        }
    }
}

