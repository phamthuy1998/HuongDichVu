package thuypham.n16dccn159.ptithcm.sellingapp.feature.product

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityProductDetailBinding
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.BottomSheetAddCartBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.PRODUCT_ID
import thuypham.n16dccn159.ptithcm.sellingapp.ext.USER_ID
import thuypham.n16dccn159.ptithcm.sellingapp.ext.getIntPref
import thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.LoginActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.CartActivity
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.ProductsViewModel

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private val productViewModel: ProductsViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideProductsViewModelFactory()
        )[ProductsViewModel::class.java]
    }

    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }

    private var productId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        productId = intent.getIntExtra(PRODUCT_ID, -1)
        if (productId != -1 && productId != null) {
            // Set cart count, check user is login yet? check by get userID from Shared pref
            val userId = getIntPref(USER_ID)
            binding.cartCount = 0
//            if (userId != -1)
//                cartViewModel.getCartCount(userId)

            productViewModel.getProductById(productId!!)
            bindViewModel()
            addEvents()
        } else {
            Toast
                .makeText(applicationContext, "Can't load info of this product!", Toast.LENGTH_LONG)
                .show()
            finish()
        }
    }

    private fun addEvents() {
        binding.cartProductDetail.setOnClickListener {
            // Check user login
            if (getIntPref(USER_ID) != -1) startActivity<CartActivity>()
            else startActivity<LoginActivity>()
        }
        binding.btnBackProductDetail.setOnClickListener { finish() }
        binding.btnBuy.setOnClickListener {
            addCart()
        }
    }

    private fun addCart() {
        val userId = getIntPref(USER_ID)
        if (userId != -1) {
            productId?.let { productViewModel.addCart(it, userId, 1) }
            showBottomDialogAddCart()
        }
        // If haven't login , intent to login activity
        else startActivity<LoginActivity>()
    }

    private fun showBottomDialogAddCart() {
        val mBottomSheetDialog = RoundedBottomSheetDialog(this)
        val bindingDialog: BottomSheetAddCartBinding = DataBindingUtil
            .inflate(LayoutInflater.from(this), R.layout.bottom_sheet_add_cart, null, false)
        bindingDialog.product = productViewModel.product.value
        mBottomSheetDialog.setContentView(bindingDialog.root)

        // Add events
        bindingDialog.btnCancelDialogAddCart.setOnClickListener() { mBottomSheetDialog.dismiss() }
        bindingDialog.btnViewCart.setOnClickListener() {
            startActivity<CartActivity>()
            mBottomSheetDialog.dismiss()
        }
        mBottomSheetDialog.show()
    }

    private fun bindViewModel() {
        productViewModel.product.observe(this, Observer {
            binding.product = it
        })

        productViewModel.networkStateAddCart.observe(this, Observer {
            when (it.status) {
                Status.RUNNING -> {
                }
                Status.FAILED -> {
                    Toast.makeText(this, "Add cart success!", Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS -> {
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        })

//        cartViewModel.cartCount.observe(this, Observer {
//            binding.cartCount = it ?: 0
//        })
    }
}
