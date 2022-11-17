package uz.salimovdeveloper.valyutakurslari.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "http://cbu.uz/uzc/arkhiv-kursov-valyut/"

    fun getRetrofitService():Retrofitservice{

        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return build.create(Retrofitservice::class.java)

    }
}