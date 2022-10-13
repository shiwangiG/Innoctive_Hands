package com.example.innoctivehands.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.innoctivehands.R
import com.squareup.picasso.Picasso

class PhotoAdapter(
        // on below line we are passing variables as list
        private val photoList: ArrayList<String>,
    ) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PhotoAdapter.PhotoViewHolder {
            // this method is use to inflate the layout file
            // which we have created for our recycler view.
            // on below line we are inflating our layout file.
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_image_item,
                parent, false
            )
            // at last we are returning our view holder
            // class with our item View File.
            return PhotoAdapter.PhotoViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PhotoAdapter.PhotoViewHolder, position: Int) {
            // on below line we are loading image from image url in our image view.
            Picasso.get().load(photoList.get(position)).into(holder.photoIV)
        }

        override fun getItemCount(): Int {
            // on below line we are returning
            // the size of our list
            return photoList.size
        }

        class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // on below line we are initializing our image view.
            val photoIV: ImageView = itemView.findViewById(R.id.image)
        }
}