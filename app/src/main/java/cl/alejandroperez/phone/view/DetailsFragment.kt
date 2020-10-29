package cl.alejandroperez.phone.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.alejandroperez.phone.R
import cl.alejandroperez.phone.model.db.EntityDetail
import cl.alejandroperez.phone.viewmodel.PhoneViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
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
        phoneViewModel.result.observe(viewLifecycleOwner, {
            //  Log.d("detail","${it}")
            if (it != null) {
                txtDetailName.text = it.name
                // txtDetailId.text = it.id.toString()
                txtDetailDescrip.text = it.description
                txtDetailPrice.text = it.price.toString()
                //txtDetailCredit.text = it.credit.toString()
                txtDetailLasPrice.text = it.lastPrice.toString()
                Picasso.get().load(it.image).into(imageDetailImage)
            }

            fun email() {

                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("appPruebakotlin@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta por ${it.name} , ID : ${it.id} ")
                intent.putExtra(Intent.EXTRA_TEXT, " “Hola\n" +
                        "Vi el producto ${it.name} y me gustaría que me contactaran a este correo o al\n" +
                        "siguiente número _________")
                intent.type = "message/rfc822"
                startActivity(Intent.createChooser(intent, "Choose an email client"))
            }

            fab.setOnClickListener { view ->
                Snackbar.make(view, "Email", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
                    email()
            }

        })

    }




}




