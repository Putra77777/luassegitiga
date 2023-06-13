package com.d3if4065.luassegitiga.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d3if4065.luassegitiga.R
import com.d3if4065.luassegitiga.databinding.ListItemBinding
import com.d3if4065.luassegitiga.model.Glosarium

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data = mutableListOf<Glosarium>()

    fun updateData(newData: List<Glosarium>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(glossarium: Glosarium) = with(binding) {
            namaTextView.text = glossarium.Nama
            latinTextView.text = glossarium.Deskripsi
            Glide.with(imageView.context)
                .load(glossarium.Gambar)
                .error(R.mipmap.ic_launcher)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, glossarium.Nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size

    }

}