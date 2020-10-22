package cl.alejandroperez.phone.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.alejandroperez.phone.model.api.Details
import cl.alejandroperez.phone.model.api.Products


@Dao
interface DaoPhone {

    @Query("select * from product_table")
    fun getAllProduct() : LiveData<List<Products>>

    @Query("select *  from detail_table where id ")
    fun getAllDetail() : LiveData<List<Details>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productlist : List<EntityProduct>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(detallist : List<EntityDetail>)



}