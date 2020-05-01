package thuypham.n16dccn159.ptithcm.sellingapp.data


import androidx.lifecycle.LiveData

data class Result<T>(
    val data : LiveData<T>,
    val networkState: LiveData<NetworkState>
)