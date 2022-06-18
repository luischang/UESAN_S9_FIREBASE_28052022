package dev.lchang.uesan_s9_firebase.ui.fragments.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ICustomer {
    @Insert
    fun insert(customerEntity: CustomerEntity)

    @Update
    fun update(vararg customerEntity: CustomerEntity)

    @Delete
    fun delete(vararg customerEntity: CustomerEntity)

    @Query("SELECT * FROM " +  CustomerEntity.TABLE_NAME + " ORDER BY last_name, first_name")
    fun getOrderedAgenda(): LiveData<List<CustomerEntity>>
}