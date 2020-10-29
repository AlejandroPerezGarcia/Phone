package cl.alejandroperez.phone.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import cl.alejandroperez.phone.model.api.Details
import cl.alejandroperez.phone.model.api.Products
import cl.alejandroperez.phone.model.api.RetrofitPhone
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

    private var dataBasePhone = DataBasePhone.getDatabase(context)
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

    fun saveDatabase (listProductEntity : List<EntityProduct>){
        CoroutineScope(Dispatchers.IO).launch { dataBasePhone.getDaoPhone().insertProduct(listProductEntity) }
        Log.d("sabe","$listProductEntity")
    }

    fun saveDataBaseDetail(listDetailEntity : EntityDetail){
        CoroutineScope(Dispatchers.IO).launch { dataBasePhone.getDaoPhone().insertDetail(listDetailEntity) }
    }

    fun loadDetail(id: Int) {
        val call = RetrofitPhone.retrofitInstance().getAllDetail(id)

        call.enqueue(object :Callback<Details>{
            override fun onResponse(call: Call<Details>, response: Response<Details>) {
                Log.d("TAGREPO1", "${response.body()}")
                saveDataBaseDetail(detailConvert(response.body()!!))
                Log.d("TAGREPO2", "${response.body()}")
            }

            override fun onFailure(call: Call<Details>, t: Throwable) {
                Log.d("TAGREPO#","$t NO LLEGA NADA")
            }
        })
    }

    fun getDetail(id : Int): LiveData<Details>  {
        return dataBasePhone.getDaoPhone().getDetail(id)
    }

}