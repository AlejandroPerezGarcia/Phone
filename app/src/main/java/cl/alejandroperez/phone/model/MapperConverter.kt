package cl.alejandroperez.phone.model

import cl.alejandroperez.phone.model.api.Details
import cl.alejandroperez.phone.model.api.Products
import cl.alejandroperez.phone.model.db.EntityDetail
import cl.alejandroperez.phone.model.db.EntityProduct

fun productConvert(listProducts: List<Products>): List<EntityProduct>{
    return listProducts.map {
        products -> EntityProduct(products.id, products.name,products.price,products.image)
    }

}
fun detailConvert(details: Details) : EntityDetail {
    return EntityDetail(details.id,details.name,details.price,details.image,details.description,details.lastPrice,details.credit)

}