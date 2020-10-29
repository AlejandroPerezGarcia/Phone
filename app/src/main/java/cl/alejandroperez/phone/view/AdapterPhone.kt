package cl.alejandroperez.phone.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.alejandroperez.phone.R
import cl.alejandroperez.phone.model.api.Products
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterPhone(private var phoneData : MutableList<Products>) :
RecyclerView.Adapter<AdapterPhone.PhoneViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):PhoneViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_list,parent,false)
        return PhoneViewHolder(view)
    }

    val productSelect = MutableLiveData<Products>()

    override fun onBindViewHolder(holder:PhoneViewHolder, position: Int) {
        holder.id.text = phoneData[position].id.toString()
        holder.name.text = phoneData[position].name
        holder.price.text = phoneData[position].price.toString()
        Picasso.get().load(phoneData[position].image).into(holder.image.imageViewList)

        holder.itemView.setOnClickListener{
            

            productSelect.value = phoneData[position]
        }
    }

    override fun getItemCount(): Int {
        return phoneData.size
    }

    class PhoneViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var id: TextView = itemView.txtId
        var name :TextView = itemView.txtName
        var price :TextView = itemView.txtPrice
        var image: ImageView = itemView.imageViewList
    }

    fun updateProduct(it:List<Products>){
        phoneData.clear()
        phoneData.addAll(it)
        notifyDataSetChanged()
    }
}

