package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import androidx.lifecycle.MutableLiveData
import thuypham.n16dccn159.ptithcm.sellingapp.data.Category
import thuypham.n16dccn159.ptithcm.sellingapp.data.NetworkState
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.CategoryRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class CategoryRepositoryImpl(private val apiService: ApiService) : CategoryRepository {
    override fun getListCategory(): Result<ArrayList<Category>> {
        val networkState = MutableLiveData<NetworkState>()
        val responseCategories = MutableLiveData<ArrayList<Category>>()
        apiService.getListCategory(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseCategories.value = response ?: arrayListOf()
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