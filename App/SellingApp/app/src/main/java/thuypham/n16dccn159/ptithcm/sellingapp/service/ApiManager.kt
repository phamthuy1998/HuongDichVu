package thuypham.n16dccn159.ptithcm.sellingapp.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.User

interface ApiManager {
    companion object {
        private const val BASE_URL = ""

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

    @GET("")
    fun login(email: String, password: String) : Call<Boolean>

    @GET("")
    fun signUp(user: User) : Call<Boolean>

    @GET("")
    fun getListProductSale() : Call<ArrayList<Product>>

    @GET("")
    fun getListProductOfCategory(cateId: Int) : Call<ArrayList<Product>>

    @GET("")
    fun getListOrder(userId: Int) : Call<ArrayList<Product>>

    @GET("")
    fun getListSlider() : Call<ArrayList<Product>>

    @GET("")
    fun addOrder() : Call<ArrayList<Product>>
}