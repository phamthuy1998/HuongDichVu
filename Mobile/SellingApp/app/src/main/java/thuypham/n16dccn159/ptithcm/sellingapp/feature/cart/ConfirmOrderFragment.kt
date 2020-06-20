package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentConfirmOrderBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.USER_ID
import thuypham.n16dccn159.ptithcm.sellingapp.ext.getIntPref
import thuypham.n16dccn159.ptithcm.sellingapp.ext.replaceFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.adapter.ProductCartConfirmAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.OrderViewModel

/**
 * A simple [Fragment] subclass.
 */
class ConfirmOrderFragment : Fragment() {


    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }
    private val orderViewModel: OrderViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideOrderViewModelFactory()
        )[OrderViewModel::class.java]
    }

    private var listProducts: ArrayList<Product> = arrayListOf()
    private var listItemOrder: ArrayList<OrderItem> = arrayListOf()
    private lateinit var binding: FragmentConfirmOrderBinding
    private val productAdapter: ProductCartConfirmAdapter by lazy {
        ProductCartConfirmAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartViewModel.getProductsCart(requireActivity().getIntPref(USER_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feeShip = 20000F
        binding.viewModel = cartViewModel
        bindViewModel()
        addEvents()
        initViews()
    }

    private fun initViews() {
        binding.rvProductConfirm.adapter = productAdapter
        binding.rvProductConfirm.setHasFixedSize(true)
        binding.rvProductConfirm.setItemViewCacheSize(20)
    }

    private fun addEvents() {
        binding.btnBackConfirm.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnPaymentConf.setOnClickListener {
            addOrder()
            showOrderSuccess()
        }
    }

    private fun showOrderSuccess() {
        requireActivity().replaceFragment(
            id = R.id.frmCart,
            fragment = OrderSuccessFragment()
        )
    }

    private fun addOrder() {
        orderViewModel.addOrder(
            requireActivity().getIntPref(USER_ID),
            cartViewModel.name.value.toString(),
            cartViewModel.phone.value.toString(),
            cartViewModel.email.value.toString(),
            cartViewModel.address.value.toString(),
            cartViewModel.note.value.toString()
        )
    }

    private fun bindViewModel() {
        cartViewModel.productsCart.observe(viewLifecycleOwner, Observer {
            productAdapter.setProductList(it)
            getTotalPrice(it)
        })

        orderViewModel.dataCheckOut.observe(viewLifecycleOwner) {
            when (it[0].result) {
                1 -> {
                    showOrderSuccess()
                }
                else -> {
                    Toast.makeText(requireContext(), it.get(0).message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun getTotalPrice(arrProduct: ArrayList<ProductCart>) {
        var price = 0F
        var itemOrder: OrderItem
        var totalPriceCart = 0F
        var discount = 0f
        for (pro in arrProduct) {
            discount = pro.discount ?: 0F
            price = pro.price ?: 0F
            totalPriceCart += (price - price * discount).times(pro.quantity ?: 1)
        }
        binding.price = totalPriceCart
    }

}
