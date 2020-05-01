package thuypham.n16dccn159.ptithcm.sellingapp.di

import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.repository.AuthRepository
import thuypham.n16dccn159.ptithcm.sellingapp.repository.OrderRepository
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository
import thuypham.n16dccn159.ptithcm.sellingapp.repository.impl.AuthRepositoryImpl
import thuypham.n16dccn159.ptithcm.sellingapp.repository.impl.OrderRepositoryImpl
import thuypham.n16dccn159.ptithcm.sellingapp.repository.impl.ProductRepositoryImpl
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiManager
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.OrderViewModelFactory
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.ProductViewModelFactory
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModelFactory

object Injection {

    private fun provideApiService(): ApiService {
        return ApiService(ApiManager.create())
    }

    private fun provideProductRepository(): ProductRepository {
        return ProductRepositoryImpl(provideApiService())
    }

    private fun provideOrderRepository(): OrderRepository {
        return OrderRepositoryImpl(provideApiService())
    }

    private fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(provideApiService())
    }

    fun provideProductViewModelFactory(): ViewModelProvider.Factory {
        return ProductViewModelFactory(provideProductRepository())
    }

    fun provideOrderViewModelFactory(): ViewModelProvider.Factory {
        return OrderViewModelFactory(provideOrderRepository())
    }

    fun provideAuthViewModelFactory(): ViewModelProvider.Factory {
        return UserViewModelFactory(provideAuthRepository())
    }
}