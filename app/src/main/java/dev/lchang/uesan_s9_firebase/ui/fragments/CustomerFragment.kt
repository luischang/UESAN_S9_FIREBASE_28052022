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
import androidx.room.Room
import dev.lchang.uesan_s9_firebase.R
import dev.lchang.uesan_s9_firebase.ui.fragments.database.CustomerDatabase
import dev.lchang.uesan_s9_firebase.ui.fragments.database.CustomerEntity
import dev.lchang.uesan_s9_firebase.ui.fragments.database.CustomerRepository

class CustomerFragment : Fragment() {
    private lateinit var customerViewModel: CustomerViewModel
    companion object {
        fun newInstance() = CustomerFragment()
    }

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =  inflater.inflate(R.layout.fragment_customer, container, false)
        val btnSaveDB: Button = view.findViewById(R.id.btnSaveDB)
        val txtFirstName: EditText = view.findViewById(R.id.txtFirstName)
        val txtLastName: EditText = view.findViewById(R.id.txtLastName)
        val txtPhone: EditText = view.findViewById(R.id.txtPhone)

        viewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        btnSaveDB.setOnClickListener {
           viewModel.saveCustomer(CustomerEntity(txtFirstName.text.toString(),txtLastName.text.toString(),txtPhone.text.toString()))
            addObserver()
            //dao = CustomerDatabase.getInstance(requireContext()).getAppDao()
        /*    val db = Room.databaseBuilder(
                requireContext(),
                CustomerDatabase::class.java,
                "sales"
            ).allowMainThreadQueries().build()

            db.customerDao().insert(CustomerEntity(txtFirstName.text.toString(),txtLastName.text.toString(),txtPhone.text.toString()))*/
        }
        return view
    }

    private fun addObserver() {
        val observer = Observer<List<CustomerEntity>> { contacts ->
            if (contacts != null) {
                var text = ""
                for (contact in contacts) {
                    text += contact.lastName + " " + contact.firstName + " - " + contact.phoneNumber + "\n"
                    Log.d("List customer","Customer is $text")
                }
            }
        }
        viewModel.customers.observe(this, observer)
    }
}