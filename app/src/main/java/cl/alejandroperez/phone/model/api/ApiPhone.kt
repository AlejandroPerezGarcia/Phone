package cl.alejandroperez.phone.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.net.IDN
import java.util.*

interface ApiPhone {
    @GET("products/")
    fun getAllProduct() : Call<List<Products>>

    @GET("details/{id}")
    fun getAllDetail(@Path ("id") id: Int) : Call<List<Details>>

}