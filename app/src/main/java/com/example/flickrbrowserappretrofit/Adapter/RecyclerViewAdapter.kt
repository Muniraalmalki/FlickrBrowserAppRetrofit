package com.example.flickrbrowserappretrofit.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickrbrowserappretrofit.Activity.FullSreenImage
import com.example.flickrbrowserappretrofit.Activity.MainActivity
import com.example.flickrbrowserappretrofit.Model.Photo
import com.example.flickrbrowserappretrofit.databinding.ItemRowBinding


class RecyclerViewAdapter(private val imageList:List<Photo>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val  binding:ItemRowBinding ):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return   ViewHolder(
           ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = imageList[position]
        holder.binding.apply {
            tvTitle.text = item.title
            Glide.with(holder.itemView.context)
                .load("https://live.staticflickr.com/${item.server}/${item.id}_${item.secret}_s.png")
                .into(imageView)
                holder.binding.cardView.setOnClickListener{
                holder.itemView.context
                    .startActivity(Intent(holder.itemView.context,FullSreenImage::class.java)
                        .putExtra("data","https://live.staticflickr.com/${item.server}/${item.id}_${item.secret}_s.png"))
            }
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}


