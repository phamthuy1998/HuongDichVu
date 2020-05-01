package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository

class ProductViewModel(private val repository: ProductRepository) :ViewModel(){

}



class ProductViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = ProductViewModel(repository) as T
}