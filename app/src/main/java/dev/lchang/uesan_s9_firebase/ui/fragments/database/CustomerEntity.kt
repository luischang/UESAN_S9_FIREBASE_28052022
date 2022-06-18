package dev.lchang.uesan_s9_firebase.ui.fragments.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

//class CustomerEntity {
    @Entity(tableName = CustomerEntity.TABLE_NAME)
    data class CustomerEntity(
        @ColumnInfo(name = "phone_number") @NotNull val phoneNumber: String,
        @ColumnInfo(name = "first_name") @NotNull val firstName: String,
        @ColumnInfo(name = "last_name") val lastName: String? = null
    ) {
        companion object {
            const val TABLE_NAME = "customer"
        }

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "customer_id")
        var customerId: Int = 0
    }
//}