package dev.lchang.uesan_s9_firebase.ui.fragments.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CustomerRepository(application: Application) {
    private val customerDao: ICustomer? = CustomerDatabase.getInstance(application)?.customerDao()

    fun insert(customerEntity: CustomerEntity) {
        if (customerDao != null) {
            InsertAsyncTask(customerDao).execute(customerEntity)
        }
    }

    fun getCustomers(): LiveData<List<CustomerEntity>> {
        return customerDao?.getOrderedAgenda() ?: MutableLiveData<List<CustomerEntity>>()
    }

    private class InsertAsyncTask(private val customerDao: ICustomer) :
        AsyncTask<CustomerEntity, Void, Void>() {
        override fun doInBackground(vararg customers: CustomerEntity?): Void? {
            for (customer in customers) {
                if (customer != null) customerDao.insert(customer)
            }
            return null
        }
    }
}