package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.User
import thuypham.n16dccn159.ptithcm.sellingapp.repository.AuthRepository
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class ProductRepositoryImpl(private val apiService: ApiService) : ProductRepository {
    override fun getListProductSale(): Result<ArrayList<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}