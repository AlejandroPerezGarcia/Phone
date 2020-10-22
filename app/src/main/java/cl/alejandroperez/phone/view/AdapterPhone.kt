package cl.alejandroperez.phone.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.alejandroperez.phone.R
import cl.alejandroperez.phone.model.api.Products
import cl.alejandroperez.phone.model.db.EntityProduct
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterPhone(private var phoneDataset : MutableList<Products>) :
RecyclerView.Adapter<AdapterPhone.PhoneViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):PhoneViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_list,parent,false)
        return PhoneViewHolder(view)
    }

    val productSelec = MutableLiveData<Products>()

    override fun onBindViewHolder(holder:PhoneViewHolder, position: Int) {
        holder.id.text = phoneDataset.get(position).id.toString()
        holder.name.text = phoneDataset.get(position).name
        holder.price.text = phoneDataset.get(position).price.toString()
        Picasso.get().load(phoneDataset.get(position).image).into(holder.image.imageViewList)

        holder.itemView.setOnClickListener{
            Log.d("viewHolder", "${phoneDataset.get(position).id.toString()}")

            productSelec.value = phoneDataset.get(position)


        }
    }

    override fun getItemCount(): Int {
        return phoneDataset.size
    }


    class PhoneViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var id = itemView.txtId
        var name = itemView.txtName
        var price = itemView.txtPrice
        var image = itemView.imageViewList
    }

    fun updateProduct(it:List<Products>){
        phoneDataset.clear()
        phoneDataset.addAll(it)
        notifyDataSetChanged()

    }
}

private fun <T> MutableLiveData<T>.postValue(toString: String) {

}
