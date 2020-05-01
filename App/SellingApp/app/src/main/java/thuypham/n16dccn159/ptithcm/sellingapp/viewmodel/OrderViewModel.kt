package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.repository.OrderRepository
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository

class OrderViewModel(private val repository: OrderRepository) :ViewModel(){

}



class OrderViewModelFactory(
    private val repository: OrderRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = OrderViewModel(repository) as T
}