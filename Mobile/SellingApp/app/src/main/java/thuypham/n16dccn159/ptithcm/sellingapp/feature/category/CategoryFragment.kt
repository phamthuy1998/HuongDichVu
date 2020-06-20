package thuypham.n16dccn159.ptithcm.sellingapp.feature.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_category.*
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.CATEGORY_ID
import thuypham.n16dccn159.ptithcm.sellingapp.feature.category.adapter.CategoryAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.feature.product.ProductsOfCategoryActivity
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CategoryViewModel
import thuypham.n16dccn159.ptithcm.sellingapp.widget.GridItemDecoration

class CategoryFragment : Fragment() {

    private val categoryAdapter by lazy {
        CategoryAdapter { categoryID -> showProductsOfCategory(categoryID) }
    }

    private lateinit var categoryViewModel: CategoryViewModel

    private fun showProductsOfCategory(categoryID: Int) {
        val intent = Intent(context, ProductsOfCategoryActivity::class.java)
        intent.putExtra(CATEGORY_ID, categoryID)
        requireActivity().startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel = ViewModelProvider(
            this,
            Injection.provideCategoryViewModelFactory()
        )[CategoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
    }

    private fun bindViewModel() {
        categoryViewModel.listCategory.observe(viewLifecycleOwner, Observer {
            categoryAdapter.setListCategory(it)
        })
        categoryViewModel.networkStateCategory.observe(viewLifecycleOwner, Observer {
            progressCategory?.visibility =
                if (it.status == Status.RUNNING) View.VISIBLE else View.GONE
        })
    }

    private fun initViews() {
        rvCategory.adapter = categoryAdapter
        rvCategory.setHasFixedSize(true)
        rvCategory.setItemViewCacheSize(20)
        rvCategory.layoutManager = GridLayoutManager(requireContext(), 3)
        rvCategory.addItemDecoration(GridItemDecoration(10, 3))
    }

}
