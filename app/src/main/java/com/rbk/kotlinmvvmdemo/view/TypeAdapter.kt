package com.rbk.kotlinmvvmdemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rbk.kotlinmvvmdemo.R
import com.rbk.kotlinmvvmdemo.model.OptionType
import kotlinx.android.synthetic.main.row_museum.view.*

class TypeAdapter(private var museums: List<OptionType>) :
    RecyclerView.Adapter<TypeAdapter.MViewHolder>() {

    var musuemClick : ((OptionType) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_type, parent, false)
        return MViewHolder(view,musuemClick)
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.bind(museums[position])
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    class MViewHolder(view: View, var musuemClick : ((OptionType) -> Unit)? = null) : RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.textViewName

        fun bind(museum: OptionType) {
            if(museum.name!=null){
                textViewName.text = museum.name.capitalize()
            }else{
                textViewName.text = ""
            }

            textViewName.setOnClickListener {
                musuemClick?.invoke(museum)
            }


//            Glide.with(imageView.context).load(museum.photo).into(imageView)
        }
    }
}
