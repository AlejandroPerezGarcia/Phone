package cl.alejandroperez.phone.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DaoPhone {

    @Query("select * from product_table")
    fun getAllProduct() : LiveData<List<EntityProduct>>

    @Query("select * from detail_table")
    fun getAllDetail() : LiveData<List<EntityDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productlist : List<EntityProduct>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(detallist : List<EntityDetail>)



}