package uz.salimovdeveloper.valyutakurslari.retrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.salimovdeveloper.valyutakurslari.models.MyValyuta

interface Retrofitservice {

    @GET("json")
    fun getAllTodo():Call<List<MyValyuta>>
}