package thuypham.n16dccn159.ptithcm.sellingapp.service

import thuypham.n16dccn159.ptithcm.sellingapp.data.Product

class ApiService(private val apiApi: ApiManager) {

    fun getListProductSale(
        onPrepared : () -> Unit,
        onSuccess : (ArrayList<Product>?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.getListProductSale()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
}