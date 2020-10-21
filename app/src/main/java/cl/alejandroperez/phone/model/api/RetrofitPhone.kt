package cl.alejandroperez.phone.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

class RetrofitPhone {
    companion object {
        fun retrofitInstance(): ApiPhone {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiPhone::class.java)
        }
    }
}