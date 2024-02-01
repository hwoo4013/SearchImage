package api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import util.Constants
import util.Constants.Companion.BASE_URL

object Retrofit_client {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : Retrofit_interface by lazy {
        retrofit.create(Retrofit_interface::class.java)
    }
}