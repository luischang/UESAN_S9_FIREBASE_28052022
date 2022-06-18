package dev.lchang.uesan_s9_firebase.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import dev.lchang.uesan_s9_firebase.R
import dev.lchang.uesan_s9_firebase.ui.fragments.database.CustomerEntity

class CustomerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerFragment()
    }

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_customer, container, false)
        val btnSaveDB: Button = view.findViewById(R.id.btnSaveDB)
        val txtFirstName: EditText = view.findViewById(R.id.txtFirstName)
        val txtLastName: EditText = view.findViewById(R.id.txtLastName)
        val txtPhone: EditText = view.findViewById(R.id.txtPhone)

        viewModel = ViewModelProvider(this)[CustomerViewModel::class.java]

        btnSaveDB.setOnClickListener {
            viewModel.saveCustomer(CustomerEntity(txtFirstName.text.toString(),txtLastName.text.toString(),txtPhone.text.toString()))
            addObserver()
        }


        return view
    }

    private fun addObserver(){
        val observer = Observer<List<CustomerEntity>> { customers ->
            if(customers!=null){
                var text = ""
                for (customer in customers){
                    text += customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + "\n"
                    Log.d("List Customer","Customer--- $text")
                }
            }

        }
        viewModel.customers.observe(this,observer)
    }

}