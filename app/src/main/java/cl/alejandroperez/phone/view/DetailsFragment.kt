package cl.alejandroperez.phone.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.alejandroperez.phone.R
import cl.alejandroperez.phone.model.db.EntityDetail
import cl.alejandroperez.phone.viewmodel.PhoneViewModel
import kotlinx.android.synthetic.main.fragment_details.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailsFragment : Fragment() {

    private val phoneViewModel : PhoneViewModel by activityViewModels()

    lateinit var phone : EntityDetail

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
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneViewModel.result.observe(viewLifecycleOwner, Observer {
            Log.d("detail","${it}")
            if (it != null) {
                txtDetailName.text = it.name
                txtDetailId.text = it.id.toString()
                txtDetailPrice.text = it.price.toString()
                txtDetailCredit.text = it.credit.toString()
            }


        })
    }
}