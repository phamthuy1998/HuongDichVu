package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result

interface ProductRepository {
    fun getListProductSale(): Result<ArrayList<Product>>
}