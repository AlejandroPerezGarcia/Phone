package cl.alejandroperez.phone.model.api

import android.content.Context
import android.util.Log
import cl.alejandroperez.phone.model.db.DataBasePhone
import cl.alejandroperez.phone.model.db.EntityDetail
import cl.alejandroperez.phone.model.db.EntityProduct
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository (context: Context) {

    var dataBasePhone = DataBasePhone.getDatabase(context)
    var listProduct = dataBasePhone.getDaoPhone().getAllProduct()

    fun loadApiPhone() {

        val call = RetrofitPhone.retrofitInstance().getAllProduct()

        call.enqueue(object :Callback<List<Products>>{

            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
               Log.d("Adapter", "{${response.body()}}")
               saveDatabase(productConvert(response.body()!!))

            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                Log.d("Adapter" , "Error al cargar")
            }
        })
      }

    fun productConvert(listProducts: List<Products>): List<EntityProduct>{
        return listProducts.map {
            products -> EntityProduct(products.id, products.name,products.price,products.image)}

    }
    fun detailConvert(details: Details ) : EntityDetail {
        return EntityDetail(details.id,details.name,details.price,details.image,details.description,details.lastPrice,details.credit)

    }

    fun saveDatabase (listProductEntity : List<EntityProduct>){
        CoroutineScope(Dispatchers.IO).launch { dataBasePhone.getDaoPhone().insertProduct(listProductEntity) }
        Log.d("sabe","$listProductEntity")
    }

    fun loadDetail(id: Int) {
        val call = RetrofitPhone.retrofitInstance().getAllDetail(id)

        call.enqueue(object :Callback<Details>{
            override fun onResponse(call: Call<Details>, response: Response<Details>) {

            }

            override fun onFailure(call: Call<Details>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })



    }

}