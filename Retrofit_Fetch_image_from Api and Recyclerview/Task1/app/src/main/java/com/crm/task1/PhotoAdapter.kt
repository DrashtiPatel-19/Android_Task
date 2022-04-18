package com.crm.task1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhotoAdapter(var context: Context, var photoList : ArrayList<PhotosDataItem>): RecyclerView.Adapter<PhotoAdapter.MyClass>()
{
    class  MyClass(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var photo_view = itemView.findViewById<ImageView>(R.id.imview)
        var photo_title  = itemView.findViewById<TextView>(R.id.tv_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        var v = LayoutInflater.from(context).inflate(R.layout.item_raw_layout, parent , false)
        return MyClass(v)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {
        var photoitems = photoList[position]
        Log.d("mydata","---> photo items project "+photoitems.url)
        Picasso.get().load(photoitems.url).into(holder.photo_view);
        holder.photo_title.text = photoitems.title

    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}