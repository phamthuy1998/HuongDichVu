package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result

interface CartRepository {
    fun getCartCount(userID: Int):  Result<Int>
    fun getProductCart(userID: Int): Result<ArrayList<ProductCart>>
    fun plusCart(userID: Int, productID: Int,quantity: Int): Result<Boolean>
    fun minusCart(userID: Int, productID: Int): Result<Boolean>
    fun delCart(userID: Int, productID: Int): Result<Boolean>
}