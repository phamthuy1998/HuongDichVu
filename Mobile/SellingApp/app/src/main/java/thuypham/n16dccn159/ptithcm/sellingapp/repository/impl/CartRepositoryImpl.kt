package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import androidx.lifecycle.MutableLiveData
import thuypham.n16dccn159.ptithcm.sellingapp.data.NetworkState
import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.CartRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class CartRepositoryImpl(private val apiService: ApiService) : CartRepository {
    override fun getCartCount(userID: Int): Result<Int> {
        val networkState = MutableLiveData<NetworkState>()
        val responseCategories = MutableLiveData<Int>()
        apiService.getCartCount(
            userID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseCategories.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseCategories,
            networkState = networkState
        )
    }

    override fun getProductCart(userID: Int): Result<ArrayList<ProductCart>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseProducts = MutableLiveData<ArrayList<ProductCart>>()
        apiService.getProductCart(
            userID,
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

    override fun plusCart(userID: Int, productID: Int, quantity: Int): Result<Boolean> {
        val networkState = MutableLiveData<NetworkState>()
        val responseCategories = MutableLiveData<Boolean>()
        apiService.plusCart(
            userID, productID, quantity,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseCategories.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseCategories,
            networkState = networkState
        )
    }

    override fun minusCart(userID: Int, productID: Int): Result<Boolean> {
        val networkState = MutableLiveData<NetworkState>()
        val responseCategories = MutableLiveData<Boolean>()
        apiService.minusCart(
            userID,
            productID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseCategories.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseCategories,
            networkState = networkState
        )
    }

    override fun delCart(userID: Int, productID: Int): Result<Boolean> {
        val networkState = MutableLiveData<NetworkState>()
        val responseCategories = MutableLiveData<Boolean>()
        apiService.delCart(
            userID,
            productID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseCategories.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseCategories,
            networkState = networkState
        )
    }

}