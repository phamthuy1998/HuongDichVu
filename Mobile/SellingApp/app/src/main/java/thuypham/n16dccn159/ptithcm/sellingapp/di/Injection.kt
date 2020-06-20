package thuypham.n16dccn159.ptithcm.sellingapp.di

import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.repository.*
import thuypham.n16dccn159.ptithcm.sellingapp.repository.impl.*
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiManager
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.*

object Injection {
    /*----------------- api service -----------------*/

    private fun provideApiService(): ApiService {
        return ApiService(ApiManager.create())
    }

    /*----------------- Repository -----------------*/

    private fun provideProductRepository(): ProductRepository {
        return ProductRepositoryImpl(provideApiService())
    }

    private fun provideOrderRepository(): OrderRepository {
        return OrderRepositoryImpl(provideApiService())
    }

    private fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(provideApiService())
    }

    private fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepositoryImpl(provideApiService())
    }

    private fun provideCartRepository(): CartRepository {
        return CartRepositoryImpl(provideApiService())
    }

    /*----------------- View model factory -----------------*/

    fun provideHomeViewModelFactory(): ViewModelProvider.Factory {
        return HomeViewModelFactory(provideProductRepository())
    }

    fun provideOrderViewModelFactory(): ViewModelProvider.Factory {
        return OrderViewModelFactory(provideOrderRepository())
    }

    fun provideAuthViewModelFactory(): ViewModelProvider.Factory {
        return UserViewModelFactory(provideAuthRepository())
    }

    fun provideCategoryViewModelFactory(): ViewModelProvider.Factory {
        return CategoryViewModelFactory(provideCategoryRepository())
    }

    fun provideProductsViewModelFactory(): ViewModelProvider.Factory {
        return ProductsViewModelFactory(provideProductRepository())
    }

    fun provideCartViewModelFactory(): ViewModelProvider.Factory {
        return CartViewModelFactory(provideCartRepository())
    }
}