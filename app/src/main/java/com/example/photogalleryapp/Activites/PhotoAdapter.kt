// photogalleryapp/Activites/PhotoAdapter.kt
package com.example.photogalleryapp.Activites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photogalleryapp.domain.models.PhotoModel
import com.example.photogalleryapp.R

class PhotoAdapter(private var photos: List<PhotoModel>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() { // تم التغيير إلى PhotoModel

    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.itemImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_imge, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        Glide.with(holder.itemView)
            .load(photo.imageUrl)
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = photos.size

    fun updatePhotos(newPhotos: List<PhotoModel>?) {
        if (newPhotos != null) {
            this.photos = newPhotos
        }
        notifyDataSetChanged()
    }
}