package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import androidx.lifecycle.MutableLiveData
import thuypham.n16dccn159.ptithcm.sellingapp.data.NetworkState
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.Slide
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class ProductRepositoryImpl(private val apiService: ApiService) : ProductRepository {

    override fun getListProductSale(): Result<ArrayList<Product>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseProducts = MutableLiveData<ArrayList<Product>>()
        apiService.getListProductSale(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseProducts.value = response ?: arrayListOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )
        return Result(
            data = responseProducts,
            networkState = networkState
        )
    }

    override fun getListSlide(): Result<ArrayList<Slide>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseSlides = MutableLiveData<ArrayList<Slide>>()
        apiService.getListSlide(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseSlides.value = response ?: arrayListOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )
        return Result(
            data = responseSlides,
            networkState = networkState
        )
    }

    override fun getAllListProductSale(): Result<ArrayList<Product>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseProducts = MutableLiveData<ArrayList<Product>>()
        apiService.getAllListProductSale(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseProducts.value = response ?: arrayListOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseProducts,
            networkState = networkState
        )
    }

    override fun getAllListProduct(): Result<ArrayList<Product>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseProducts = MutableLiveData<ArrayList<Product>>()
        apiService.getAllPros(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseProducts.value = response ?: arrayListOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseProducts,
            networkState = networkState
        )
    }

    override fun getProductCategory(cateId: Int): Result<ArrayList<Product>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseProducts = MutableLiveData<ArrayList<Product>>()
        apiService.getListProductCategory(
            cateId,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseProducts.value = response ?: arrayListOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseProducts,
            networkState = networkState
        )
    }

    override fun getProductByID(productID: Int): Result<Product> {
        val networkState = MutableLiveData<NetworkState>()
        val responseProduct = MutableLiveData<Product>()
        apiService.getProductDetailByID(
            productID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                if (response?.size != 0)
                    responseProduct.value = response?.get(0)
                else responseProduct.value = null
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseProduct,
            networkState = networkState
        )
    }

    override fun addCart(productID: Int, userId: Int, quantity: Int): Result<Boolean> {
        val networkState = MutableLiveData<NetworkState>()
        val responseAddCart = MutableLiveData<Boolean>()
        apiService.addCart(
            productID,
            userId,
            quantity,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseAddCart.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )
        return Result(
            data = responseAddCart,
            networkState = networkState
        )
    }
}