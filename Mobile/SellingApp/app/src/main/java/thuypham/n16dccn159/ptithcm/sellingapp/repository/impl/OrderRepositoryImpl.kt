package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import androidx.lifecycle.MutableLiveData
import thuypham.n16dccn159.ptithcm.sellingapp.data.*
import thuypham.n16dccn159.ptithcm.sellingapp.repository.OrderRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class OrderRepositoryImpl(private val apiService: ApiService) : OrderRepository {
    override fun order(
        userID: Int,
        name: String,
        phone: String,
        email: String,
        address: String,
        note: String
    ): Result<ResultApi> {
        val networkState = MutableLiveData<NetworkState>()
        val response = MutableLiveData<ResultApi>()
        apiService.addOrder(
            userID, name, phone, email, address, note,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { data ->
                response.value = data
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = response,
            networkState = networkState
        )
    }

    override fun getAllOrder(userID: Int, statusID: Int?): Result<ArrayList<Order>> {
        val networkState = MutableLiveData<NetworkState>()
        val response = MutableLiveData<ArrayList<Order>>()
        apiService.getAllOrder(
            userID, statusID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { data ->
                response.value = data
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = response,
            networkState = networkState
        )
    }

    override fun getAllOrderItem(orderID: Int): Result<ArrayList<OrderItem>> {
        val networkState = MutableLiveData<NetworkState>()
        val response = MutableLiveData<ArrayList<OrderItem>>()
        apiService.getAllOrderItem(
            orderID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { data ->
                response.value = data
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = response,
            networkState = networkState
        )
    }

    override fun getAllOrderStatus(): Result<ArrayList<OrderStatus>> {
        val networkState = MutableLiveData<NetworkState>()
        val response = MutableLiveData<ArrayList<OrderStatus>>()
        apiService.getAllOrderStatus(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { data ->
                response.value = data
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = response,
            networkState = networkState
        )
    }

    override fun cancelOrder(orderId: Int): Result<ResultApi> {
        val networkState = MutableLiveData<NetworkState>()
        val response = MutableLiveData<ResultApi>()
        apiService.cancelOrder(
            orderId,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { data ->
                response.value = data
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = response,
            networkState = networkState
        )
    }

}