package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Category
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.CategoryRepository

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val requestCategories = MutableLiveData<Result<ArrayList<Category>>>()

    init {
        getListCategories()
    }
    val listCategory= Transformations.switchMap(requestCategories) {
        it.data
    }

    val networkStateCategory = Transformations.switchMap(requestCategories) {
        it.networkState
    }

    private fun getListCategories() {
        requestCategories.value = repository.getListCategory()
    }
}

class CategoryViewModelFactory(
    private val repository: CategoryRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = CategoryViewModel(repository) as T
}