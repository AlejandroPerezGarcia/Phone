package cl.alejandroperez.phone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.alejandroperez.phone.R
import cl.alejandroperez.phone.model.api.Products
import cl.alejandroperez.phone.model.viewmodel.PhoneViewModel
import kotlinx.android.synthetic.main.fragment_list.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ListFragment : Fragment() {

    private var productList = ArrayList<Products>()
    private lateinit var adapter: AdapterPhone

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterPhone(productList)
        listRecyclerView.adapter = adapter
        val phoneViewModel : PhoneViewModel by activityViewModels()

        phoneViewModel.listProduct.observe(viewLifecycleOwner, Observer {
            adapter.updateProduct(it)
        })
       

    }
}