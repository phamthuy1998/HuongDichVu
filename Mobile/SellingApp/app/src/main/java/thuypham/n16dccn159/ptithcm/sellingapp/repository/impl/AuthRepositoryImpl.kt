package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import androidx.lifecycle.MutableLiveData
import thuypham.n16dccn159.ptithcm.sellingapp.data.NetworkState
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.ResultApi
import thuypham.n16dccn159.ptithcm.sellingapp.data.User
import thuypham.n16dccn159.ptithcm.sellingapp.repository.AuthRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class AuthRepositoryImpl(private val apiService: ApiService) : AuthRepository {
    override fun login(email: String, password: String): Result<ResultApi> {
        val networkState = MutableLiveData<NetworkState>()
        val responseLogin = MutableLiveData<ResultApi>()
        apiService.login(
            email, password,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseLogin.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseLogin,
            networkState = networkState
        )
    }

    override fun signUp(
        username: String,
        password: String,
        name: String,
        email: String,
        phone: String,
        address: String
    ): Result<ResultApi> {
        val networkState = MutableLiveData<NetworkState>()
        val responseSignUp = MutableLiveData<ResultApi>()
        apiService.signUp(
            username, password, name, email, phone, address,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseSignUp.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseSignUp,
            networkState = networkState
        )
    }

    override fun changeInfo(
        userId: Int,
        name: String,
        email: String,
        phone: String,
        address: String,
        avatar: String
    ): Result<ResultApi> {
        val networkState = MutableLiveData<NetworkState>()
        val responseSignUp = MutableLiveData<ResultApi>()
        apiService.changeUserInfo(
            userId, name, email, phone, address, avatar,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseSignUp.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseSignUp,
            networkState = networkState
        )
    }

    override fun forgotPassword(email: String): Result<Int> {
        val networkState = MutableLiveData<NetworkState>()
        val responseForgotPassword = MutableLiveData<Int>()
        apiService.forgotPassword(
            email,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseForgotPassword.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseForgotPassword,
            networkState = networkState
        )
    }

    override fun changePassword(
        userId: Int,
        oldPass: String,
        newPass: String
    ): Result<ResultApi> {
        val networkState = MutableLiveData<NetworkState>()
        val responseSignUp = MutableLiveData<ResultApi>()
        apiService.changePassword(
            userId, oldPass, newPass,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseSignUp.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseSignUp,
            networkState = networkState
        )
    }

    override fun getUserInfoByUserID(userID: Int): Result<User> {
        val networkState = MutableLiveData<NetworkState>()
        val responseUser = MutableLiveData<User>()
        apiService.getUserInfoByUserID(
            userID,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseUser.value = response?.get(0)
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseUser,
            networkState = networkState
        )
    }

}