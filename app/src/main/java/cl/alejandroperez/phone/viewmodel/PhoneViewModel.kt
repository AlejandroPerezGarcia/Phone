package cl.alejandroperez.phone.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cl.alejandroperez.phone.model.api.Products
import cl.alejandroperez.phone.model.Repository

class PhoneViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: Repository = Repository(application)

    var listProduct = repository.listProduct



    init {
        repository = Repository(application)
        repository.loadApiPhone()
        Log.d("load", "${repository.loadApiPhone()}")
    }

    val datoSelecinado = MutableLiveData<Products>()

    fun selecionado(product: Products){
        datoSelecinado.value = product
        Log.d("phone" , "${product}")
        repository.loadDetail(product.id)

    }

}