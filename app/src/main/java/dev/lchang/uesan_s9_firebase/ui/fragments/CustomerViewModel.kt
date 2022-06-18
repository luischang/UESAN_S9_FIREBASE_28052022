package dev.lchang.uesan_s9_firebase.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import dev.lchang.uesan_s9_firebase.ui.fragments.database.CustomerEntity
import dev.lchang.uesan_s9_firebase.ui.fragments.database.CustomerRepository

public class CustomerViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CustomerRepository(application)
    val customers = repository.getCustomers()

    fun saveCustomer(customerEntity: CustomerEntity) {
        repository.insert(customerEntity)
    }
}