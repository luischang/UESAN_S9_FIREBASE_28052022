package dev.lchang.uesan_s9_firebase.ui.fragments.client

import dev.lchang.uesan_s9_firebase.ui.fragments.interfaces.APIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MascotaClient {
    private var url = "https://www.kreapps.biz/patitas/"

    private var hpptClient = OkHttpClient.Builder()
        .connectTimeout(1,TimeUnit.MINUTES)
        .writeTimeout(20,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: APIService by lazy {
        buildRetrofit().create(APIService::class.java)
    }
}