package dev.lchang.uesan_s9_firebase.ui.fragments.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CustomerDao {
    @Insert
    fun insert(customerEntity: CustomerEntity)

    @Update
    fun update(vararg customerEntity: CustomerEntity)

    @Delete
    fun delete(vararg customerEntity: CustomerEntity)

    @Query("SELECT  * FROM customer ORDER BY last_name")
    fun getCustomerOrderBYLastName(): LiveData<List<CustomerEntity>>


}