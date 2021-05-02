package com.rbk.kotlinmvvmdemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbk.kotlinmvvmdemo.R
import com.rbk.kotlinmvvmdemo.model.OptionType
import kotlinx.android.synthetic.main.activity_type_selection.*

/**
 * @author RBK
 */

class TypeSelectionActivity : AppCompatActivity() {

    private lateinit var adapter: TypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_selection)


        setupUI()
    }


    private fun setupUI() {
        adapter = TypeAdapter(getDataPump())
        adapter.apply {
            musuemClick = {
                itemClick(it)
            }
        }
        typerecyclerview.layoutManager = LinearLayoutManager(this)
        typerecyclerview.adapter = adapter
    }

    private fun getDataPump():List<OptionType>{
        val options=ArrayList<OptionType>()
        options.add(OptionType(1,"MVVM"))
        options.add(OptionType(2,"ROOM"))
        return options
    }


    private fun itemClick(watches: OptionType) {
        when(watches.id){
            1->{
                startActivity(Intent(this,MuseumActivity::class.java))
            }
            2->{
                startActivity(Intent(this,TodoActivity::class.java))
            }
        }
    }
}
