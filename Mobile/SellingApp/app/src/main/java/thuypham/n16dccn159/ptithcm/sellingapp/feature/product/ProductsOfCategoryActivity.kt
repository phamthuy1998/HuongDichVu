package thuypham.n16dccn159.ptithcm.sellingapp.feature.product

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_product_in_category.*
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityProductInCategoryBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.LoginActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.CartActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.MainActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.product.adapter.ProductAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.ProductsViewModel

class ProductsOfCategoryActivity : AppCompatActivity() {

    private var categoryID: Int? = null

    private lateinit var binding: ActivityProductInCategoryBinding
    private val productAdapter by lazy {
        ProductAdapter { productID -> showProductDetail(productID) }
    }

    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }

    private fun showProductDetail(id: Int) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(PRODUCT_ID, id)
        startActivity(intent)
    }

    private val productViewModel: ProductsViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideProductsViewModelFactory()
        )[ProductsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_in_category)
        hideSoftKeyboard()

        categoryID = intent.getIntExtra(CATEGORY_ID, -1)
        if (categoryID != -1 && categoryID != null) {
            productViewModel.getProductCategory(categoryID!!)
            initViews()
            bindViewModel()
            addEvents()

            // Set cart count, check user is login yet? check by get userID from Shared pref
            val userId = getIntPref(USER_ID)
//            binding.cartCount = 0
//            if (userId != -1)
//                cartViewModel.getCartCount(userId)

        } else {
            Toast
                .makeText(applicationContext, "Can't load info of this product!", Toast.LENGTH_LONG)
                .show()
            finish()
        }
    }

    private fun initViews() {
        rvProducts.adapter = productAdapter
        rvProducts.setHasFixedSize(true)
        rvProducts.setItemViewCacheSize(20)
    }

    private fun addEvents() {
        btnBackProducts.setOnClickListener { finish() }
        swRefreshProducts.setOnRefreshListener { productViewModel.getProductCategory(categoryID!!) }
        cartProducts.setOnClickListener {
            if (getIntPref(USER_ID) != -1) startActivity<CartActivity>()
            else startActivity<LoginActivity>()
        }
        btnContinueShopping.setOnClickListener { startActivity<MainActivity>(); finish() }
        edtSearchProducts.addTextChangedListener(object : TextWatcher {
              override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                productAdapter.search(s.toString(), {
                    productAdapter.removeAllData()
                }, {
                    productAdapter.addDataSearch(it)
                })
            }
        })
    }

    private fun bindViewModel() {
        productViewModel.listProductCategory.observe(this, Observer {
            if (it != null) {
                productsEmpty.gone()
                productAdapter.setProductList(it)
            } else productsEmpty.visible()
        })

        productViewModel.networkStateProCategory.observe(this, Observer {
            progressProducts.visibility =
                if (it.status == Status.RUNNING) View.VISIBLE else View.GONE
        })

//        cartViewModel.cartCount.observe(this, Observer {
//            binding.cartCount = it ?: 0
//        })
    }
}
