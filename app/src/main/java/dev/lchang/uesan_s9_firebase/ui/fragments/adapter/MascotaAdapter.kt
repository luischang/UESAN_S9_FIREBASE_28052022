package dev.lchang.uesan_s9_firebase.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.lchang.uesan_s9_firebase.R
import dev.lchang.uesan_s9_firebase.ui.fragments.models.CourseModel
import dev.lchang.uesan_s9_firebase.ui.fragments.models.MascotaModel

class MascotaAdapter(private var lstMascotas: List<MascotaModel>)
    : RecyclerView.Adapter<MascotaAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
       val ivMascota: ImageView = itemView.findViewById(R.id.ivMascota)
       val tvNomMascota: TextView = itemView.findViewById(R.id.tvNomMascota)
       val tvFechaPerdida: TextView = itemView.findViewById(R.id.tvFechaPerdida)
       val tvLugar: TextView = itemView.findViewById(R.id.tvLugar)
       val tvContacto: TextView = itemView.findViewById(R.id.tvContacto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_mascota,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemMascota = lstMascotas[position]
        holder.tvNomMascota.text = itemMascota.nommascota
        holder.tvFechaPerdida.text = itemMascota.fechaperdida
        holder.tvLugar.text = itemMascota.lugar
        holder.tvContacto.text = itemMascota.contacto
        Glide.with(holder.itemView.context)
            .load(itemMascota.urlimagen)
            .into(holder.ivMascota)
    }

    override fun getItemCount(): Int {
        return lstMascotas.size
    }


}