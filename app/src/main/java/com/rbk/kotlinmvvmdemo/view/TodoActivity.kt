package com.rbk.kotlinmvvmdemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbk.kotlinmvvmdemo.R
import com.rbk.kotlinmvvmdemo.model.DatabaseClient
import com.rbk.kotlinmvvmdemo.model.Todo
import com.rbk.kotlinmvvmdemo.rx.DatabaseOperations
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {

    var adapter:TodoAdapter?=null
    var todos:List<Todo>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        todos=ArrayList()

        adapter= TodoAdapter(listOf())



        todorecyclerView.layoutManager=LinearLayoutManager(this)
        todorecyclerView.adapter=adapter
        actTodoAddNew.setOnClickListener {
            startActivity(Intent(this,AddOrEditTodoActivity::class.java))
        }
        actTodoRemoveAll.setOnClickListener {
            clearAllTodos()
            getTodos()
        }
    }

    override fun onResume() {
        super.onResume()
        getTodos()
    }


    private fun getTodos(){
        val thread = Thread {
            val tds=DatabaseClient.getInstance(applicationContext).appDatabase
                ?.taskDao()
                ?.getAllTodos()
            todos=tds

            Log.d("TODOACTIVITY","TODOS:"+todos.toString())

            setupAdapter()

        }
        thread.start()

    }
    private fun clearAllTodos(){
        DatabaseOperations.removeAllTodos(this)

    }

    private fun setupAdapter(){
        runOnUiThread {
            adapter?.update(todos?: listOf())
            adapter?.notifyDataSetChanged()
        }
    }


}
