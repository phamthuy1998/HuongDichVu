package thuypham.n16dccn159.ptithcm.sellingapp.service

import thuypham.n16dccn159.ptithcm.sellingapp.data.*

class ApiService(private val apiApi: ApiManager) {

    fun getListProductSale(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListProductSale()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getListSlide(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Slide>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListSlider()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getAllListProductSale(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListProductSale()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getAllPros(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getAllProducts()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getListProductCategory(
        cateId: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListProductOfCategory(cateId)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getProductDetailByID(
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getProductDetailByID(productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun addCart(
        productID: Int,
        userID: Int,
        quantity: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.plusCart(productID, userID, quantity)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getListCategory(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Category>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListCategory()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getCartCount(
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Int?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getCartCount(userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun minusCart(
        userID: Int,
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.minusCart(userID, productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun plusCart(
        userID: Int,
        productID: Int,
        quantity: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.plusCart(userID, productID, quantity)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun delCart(
        userID: Int,
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.delItemCart(userID, productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getProductCart(
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<ProductCart>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getProductsCart(userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun login(
        email: String,
        password: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultApi?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.login(email, password)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun addOrder(
        userID: Int,
        name: String,
        phone: String,
        email: String,
        address: String,
        note: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultApi?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.addOrder(userID, name, phone, email, address, note)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun forgotPassword(
        email: String,
        onPrepared: () -> Unit,
        onSuccess: (Int?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.forgotPassword(email)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getUserInfoByUserID(
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<User>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getUserInfoByUserID(userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getAllOrderStatus(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<OrderStatus>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getAllOrderStatus()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun cancelOrder(
        orderId: Int,
        onPrepared: () -> Unit,
        onSuccess: (ResultApi?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.cancelOrder(orderId)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getAllOrder(
        userID: Int, statusID: Int?,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Order>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = if (statusID == null) apiApi.getAllOrder(userID)
        else apiApi.getAllOrderByStatus(userID, statusID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getAllOrderItem(
        orderID : Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<OrderItem>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request =  apiApi.getAllOrderItem(orderID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun signUp(
        username: String,
        password: String,
        name: String,
        email: String,
        phone: String,
        address: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultApi?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.signUp(username, password, name, email, phone, address)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun changeUserInfo(
        userId: Int,
        name: String,
        email: String,
        phone: String,
        address: String,
        avatar: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultApi?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.changeInfoAcc(userId, name, email, phone, address, avatar)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun changePassword(
        userId: Int,
        oldPass: String,
        newPass: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultApi?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.changePass(userId, oldPass, newPass)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
}