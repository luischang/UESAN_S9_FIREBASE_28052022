package dev.lchang.uesan_s9_firebase.ui.fragments.interfaces

import dev.lchang.uesan_s9_firebase.ui.fragments.models.MascotaModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("mascotaperdida.php")
    fun litarMascota(): Call<List<MascotaModel>>
}