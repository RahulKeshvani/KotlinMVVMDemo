package com.rbk.kotlinmvvmdemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rbk.kotlinmvvmdemo.R
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        actTodoAddNew.setOnClickListener {
            startActivity(Intent(this,AddOrEditTodoActivity::class.java))
        }
    }



}
