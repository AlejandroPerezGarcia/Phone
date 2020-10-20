package cl.alejandroperez.phone.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class EntityProduct (

  @PrimaryKey  val id: Int,
    val name: String,
    val image: String,
    val price: Int
    )