package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.Slide

interface ProductRepository {
    fun getListProductSale(): Result<ArrayList<Product>>
    fun getListSlide(): Result<ArrayList<Slide>>
    fun getAllListProductSale(): Result<ArrayList<Product>>
    fun getAllListProduct(): Result<ArrayList<Product>>
    fun getProductCategory(cateId: Int): Result<ArrayList<Product>>
    fun getProductByID(productID: Int): Result<Product>
    fun addCart(productID: Int, userId: Int, quantity: Int): Result<Boolean>
}