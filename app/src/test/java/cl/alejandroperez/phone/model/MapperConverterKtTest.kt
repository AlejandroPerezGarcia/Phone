package cl.alejandroperez.phone.model

import android.telecom.Call
import cl.alejandroperez.phone.model.api.Details
import cl.alejandroperez.phone.model.api.Products
import cl.alejandroperez.phone.model.db.EntityDetail
import cl.alejandroperez.phone.model.db.EntityProduct
import org.junit.Test

import org.junit.Assert.*

class MapperConverterKtTest {

    @Test
    fun productConvert() {
    //Given
        val products = listOf(Products(1,"name",1234,"image"))
        val entityProduct = listOf(EntityProduct(1,"name",1234,"image"))

        //when
        val result = productConvert(products)

        //then

        assertNotNull(result)
        assertEquals(entityProduct,result)


    }

    @Test
    fun detailConvert() {
        //Given
        val details = Details(1,"name",1234,"image","description",4321,false)
        val entityDetail = EntityDetail(1,"name",1234,"image","description",4321,false)
        //when
        val result =  detailConvert(details)

        //then
        assertNotNull(result)
        assertEquals(entityDetail,result)



    }
}