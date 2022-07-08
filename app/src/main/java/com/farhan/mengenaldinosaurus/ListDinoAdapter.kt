package com.farhan.mengenaldinosaurus

import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListDinoAdapter(val listDino: ArrayList<Dino>) : RecyclerView.Adapter<ListDinoAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_GAMBAR = "extra_gambar"
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_dino, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dino = listDino[position]

        Glide.with(holder.itemView.context)
            .load(dino.gambar)
            .apply(RequestOptions().override(60, 60))
            .into(holder.imgPhoto)

        holder.tvName.text = dino.name
        holder.tvDetail.text = dino.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listDino[holder.adapterPosition]) }
        holder.imgPhoto.setOnClickListener {
            MediaPlayer.create(holder.itemView.context,listDino[position].suara).start()
//            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
//            intent.putExtra(EXTRA_NAME, dino.name)
//            intent.putExtra(EXTRA_DETAIL, dino.detail)
//            intent.putExtra(EXTRA_GAMBAR, dino.gambar)
//            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listDino.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_gambar)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Dino)
    }
}