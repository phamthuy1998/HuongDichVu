package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.Slide
import thuypham.n16dccn159.ptithcm.sellingapp.repository.ProductRepository

class HomeViewModel(private val repository: ProductRepository) : ViewModel() {

    private val requestSlide = MutableLiveData<Result<ArrayList<Slide>>>()
    private val requestProductSale = MutableLiveData<Result<ArrayList<Product>>>()

    init {
        getListSlide()
        getListProductSale()
    }

    fun refresh(){
        getListSlide()
        getListProductSale()
    }

    val listSlides = Transformations.switchMap(requestSlide) {
        it.data
    }

    val networkStateSlide = Transformations.switchMap(requestSlide) {
        it.networkState
    }

    fun getListSlide() {
        requestSlide.value = repository.getListSlide()
    }

    val listProductSale = Transformations.switchMap(requestProductSale) {
        it.data
    }

    val networkStateProSale = Transformations.switchMap(requestProductSale) {
        it.networkState
    }

    fun getListProductSale() {
        requestProductSale.value = repository.getListProductSale()
    }
}


class HomeViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = HomeViewModel(repository) as T
}