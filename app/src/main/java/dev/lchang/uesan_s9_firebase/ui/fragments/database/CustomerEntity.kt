package dev.lchang.uesan_s9_firebase.ui.fragments.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="customer")
data class CustomerEntity(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "phone_number") val phoneNumber: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_id") var customerId: Int = 0
}
