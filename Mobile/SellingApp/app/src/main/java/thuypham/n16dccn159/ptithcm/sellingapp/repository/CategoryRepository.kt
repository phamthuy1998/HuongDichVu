package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Category
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result

interface CategoryRepository {
    fun getListCategory(): Result<ArrayList<Category>>
}