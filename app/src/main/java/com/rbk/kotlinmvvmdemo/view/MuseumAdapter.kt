package com.rbk.kotlinmvvmdemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rbk.kotlinmvvmdemo.model.Museum
import com.rbk.kotlinmvvmdemo.R
import kotlinx.android.synthetic.main.row_museum.view.*

class MuseumAdapter(private var museums: List<Museum>) :
    RecyclerView.Adapter<MuseumAdapter.MViewHolder>() {

    var musuemClick : ((Museum) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_museum, parent, false)
        return MViewHolder(view,musuemClick)
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.bind(museums[position])
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    fun update(data: List<Museum>) {
        museums = data
        notifyDataSetChanged()
    }

    class MViewHolder(view: View, var musuemClick : ((Museum) -> Unit)? = null) : RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.textViewName
        private val textViewLink: TextView = view.textViewLink
        private val textViewAddress: TextView = view.textViewAddress
        private val textViewEmail: TextView = view.textViewEmail

        fun bind(museum: Museum) {
            if(museum.name!=null){
                textViewName.text = museum.name.capitalize()
            }else{
                textViewName.text = ""
            }
            if(museum.brewery_type!=null){
                textViewLink.text = museum.brewery_type
            }else{
                textViewLink.text = ""
            }
            if(museum.city!=null && museum.state!=null){
                textViewAddress.text = museum.city.plus(","+museum.state)
            }else{
                textViewAddress.text = ""
            }
            if(museum.phone!=null ){
                textViewEmail.text = museum.phone
            }else{
                textViewEmail.text = ""
            }

            textViewEmail.setOnClickListener {
                musuemClick?.invoke(museum)
            }


//            Glide.with(imageView.context).load(museum.photo).into(imageView)
        }
    }
}
