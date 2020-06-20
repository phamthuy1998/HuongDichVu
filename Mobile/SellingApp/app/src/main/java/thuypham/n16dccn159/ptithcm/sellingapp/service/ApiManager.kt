package thuypham.n16dccn159.ptithcm.sellingapp.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import thuypham.n16dccn159.ptithcm.sellingapp.data.*

interface ApiManager {
    companion object {

        private const val BASE_URL = "http://192.168.1.131:800/api/"

        fun create(): ApiManager {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiManager::class.java)
        }
    }

    @GET("login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<ResultApi>

    @POST("signUp")
    fun signUp(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("phone") phone: String,
        @Query("address") address: String
    ): Call<ResultApi>

    @PUT("updateUser")
    fun changeInfoAcc(
        @Query("userId") userId: Int,
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("phone") phone: String,
        @Query("address") address: String,
        @Query("avatar") avatar: String
    ): Call<ResultApi>

    @GET("changePassword")
    fun changePass(
        @Query("userId") userId: Int,
        @Query("oldPass") oldPass: String,
        @Query("newPass") newPass: String
    ): Call<ResultApi>

    @POST("")
    fun forgotPassword(email: String): Call<Int>

    @POST("userInfoById")
    fun getUserInfoByUserID(@Query("userId") userID: Int): Call<ArrayList<User>>

    //    @FormUrlEncoded
    @PUT("checkOut")
    fun addOrder(
        @Query("userId") userID: Int,
        @Query("name") name: String,
        @Query("phone") phone: String,
        @Query("email") email: String,
        @Query("address") address: String,
        @Query("note") note: String
    ): Call<ResultApi>

    @GET("allSalePros")
    fun getListProductSale(): Call<ArrayList<Product>>

    @GET("allPros")
    fun getAllProducts(): Call<ArrayList<Product>>

    @GET("allProsOfCate")
    fun getListProductOfCategory(@Query("cateId") cateId: Int): Call<ArrayList<Product>>

    @GET("proDetail")
    fun getProductDetailByID(@Query("proId") productID: Int): Call<ArrayList<Product>>

    @GET("allOrdersOfUser")
    fun getAllOrder(@Query("userId") userId: Int): Call<ArrayList<Order>>

    @GET("orderByStatus")
    fun getAllOrderByStatus(
        @Query("userId") userId: Int,
        @Query("statusId") statusId: Int
    ): Call<ArrayList<Order>>

    @GET("allCards")
    fun getListSlider(): Call<ArrayList<Slide>>

    @GET("allOrderStatus")
    fun getAllOrderStatus(): Call<ArrayList<OrderStatus>>

    @PUT("cancelOrder")
    fun cancelOrder(
        @Query("orderId") orderId: Int
    ): Call<ResultApi>

    @GET("allCates")
    fun getListCategory(): Call<ArrayList<Category>>

    @GET("orderItemOfOrder")
    fun getAllOrderItem( @Query("orderId") orderId: Int): Call<ArrayList<OrderItem>>

    @GET("cartCount")
    fun getCartCount(@Query("userId") userID: Int): Call<Int>

    @POST("plusCartItem")
    fun plusCart(
        @Query("productId") userID: Int,
        @Query("userId") productID: Int,
        @Query("quantity") quantity: Int
    ): Call<Boolean>

    @DELETE("deleteCartItem")
    fun delItemCart(@Query("userId") userID: Int, @Query("productId") productID: Int): Call<Boolean>

    @POST("minusCartItem")
    fun minusCart(@Query("userId") userID: Int, @Query("productId") productID: Int): Call<Boolean>

    @GET("allProsOfCart")
    fun getProductsCart(@Query("userId") userID: Int): Call<ArrayList<ProductCart>>

}