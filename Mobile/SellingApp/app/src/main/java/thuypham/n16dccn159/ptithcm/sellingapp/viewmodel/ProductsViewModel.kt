package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository

class ProductsViewModel(private val repository: ProductRepository) : ViewModel() {

    private val requestAllProductSale = MutableLiveData<Result<ArrayList<Product>>>()
    private val requestAllProducts = MutableLiveData<Result<ArrayList<Product>>>()
    private val requestAllProductOfCategory = MutableLiveData<Result<ArrayList<Product>>>()
    private val requestProduct = MutableLiveData<Result<Product>>()
    private val requestAddCart = MutableLiveData<Result<Boolean>>()

    val listProductSale = Transformations.switchMap(requestAllProductSale) {
        it.data
    }

    val networkStateProSale = Transformations.switchMap(requestAllProductSale) {
        it.networkState
    }

    fun getAllListProductSale() {
        requestAllProductSale.value = repository.getAllListProductSale()
    }

    val listProducts = Transformations.switchMap(requestAllProducts) {
        it.data
    }

    val networkStateAllPros = Transformations.switchMap(requestAllProducts) {
        it.networkState
    }

    fun getAllProducts() {
        requestAllProducts.value = repository.getAllListProduct()
    }

    val listProductCategory = Transformations.switchMap(requestAllProductOfCategory) {
        it.data
    }

    val networkStateProCategory = Transformations.switchMap(requestAllProductOfCategory) {
        it.networkState
    }

    fun getProductCategory(cateId: Int) {
        requestAllProductOfCategory.value = repository.getProductCategory(cateId)
    }

    val product = Transformations.switchMap(requestProduct) {
        it.data
    }

    val networkProduct = Transformations.switchMap(requestProduct) {
        it.networkState
    }

    fun getProductById(productId: Int) {
        requestProduct.value = repository.getProductByID(productId)
    }

    val networkStateAddCart = Transformations.switchMap(requestAddCart) {
        it.networkState
    }

    fun addCart(productId: Int, userD: Int, quantity: Int) {
        requestAddCart.value = repository.addCart(productId, userD,quantity)
    }


}


class ProductsViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = ProductsViewModel(repository) as T
}