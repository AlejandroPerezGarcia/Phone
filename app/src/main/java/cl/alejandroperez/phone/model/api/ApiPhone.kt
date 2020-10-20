package cl.alejandroperez.phone.model.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiPhone {
    @GET("products")
    fun getAllProduct() : Call<List<Products>>

    @GET("details")
    fun getAllDetail() : Call<List<Details>>

}