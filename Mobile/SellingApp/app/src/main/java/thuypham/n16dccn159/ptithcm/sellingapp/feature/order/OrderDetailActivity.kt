package thuypham.n16dccn159.ptithcm.sellingapp.feature.order

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.activity_order_detail.view.*
import kotlinx.android.synthetic.main.ll_cart.*
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityOrderDetailBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.ORDER
import thuypham.n16dccn159.ptithcm.sellingapp.ext.gone
import thuypham.n16dccn159.ptithcm.sellingapp.ext.visible
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.CartActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.adapter.ProductCartConfirmAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.feature.order.adapter.ProductOrderAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.OrderViewModel
import java.util.ArrayList

class OrderDetailActivity : AppCompatActivity() {
    private val orderViewModel: OrderViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideOrderViewModelFactory()
        )[OrderViewModel::class.java]
    }

    private val productAdapter: ProductOrderAdapter by lazy {
        ProductOrderAdapter()
    }

    private lateinit var binding: ActivityOrderDetailBinding
    private var order: Order? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_detail)
        order = intent.getParcelableExtra(ORDER)
        orderViewModel.getAllStatusOrder()
        order?.id?.let {
            orderViewModel.getAllOrderItem(it)
            binding.order = order
            binding.tranFee = 20000F
            binding.totalPrice = 0F
        }
        setEvents()
        initViews()
        bindViewModel()
    }

    private fun initViews() {
        binding.rvProductOrderDetail.adapter = productAdapter
        binding.rvProductOrderDetail.setHasFixedSize(true)
        binding.rvProductOrderDetail.setItemViewCacheSize(20)
    }

    private fun bindViewModel() {
        orderViewModel.cancelOrder.observe(this) {
            when (it[0].result) {
                1 -> {
                    order?.id = 4
                    binding.order = order
                }
                else -> Toast.makeText(this, it.get(0).message, Toast.LENGTH_LONG).show()
            }
        }
        orderViewModel.orderItem.observe(this) {
            productAdapter.setProductList(it)
            getTotalPrice(it)
        }

        orderViewModel.dataStatusOrder.observe(this) {
            binding.listStatus = it
        }

        orderViewModel.networkCancelOrder.observe(this) {
            when (it.status) {
                Status.RUNNING -> progressOrderDetail.visible()
                Status.SUCCESS -> {
                    progressOrderDetail.gone()
                }
                Status.FAILED -> {
                    progressOrderDetail.gone()
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
        orderViewModel.networkOrderItem.observe(this) {
            when (it.status) {
                Status.RUNNING -> progressOrderDetail.visible()
                Status.SUCCESS -> {
                    progressOrderDetail.gone()
                }
                Status.FAILED -> {
                    progressOrderDetail.gone()
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getTotalPrice(list: ArrayList<OrderItem>?) {
        if (list != null) {
            var totalPrice = 0F
            for (orderItem in list) {
                totalPrice = totalPrice.plus((orderItem.unitPrice ?: 0F).times(orderItem.quantity?:1))
            }
            binding.totalPrice = totalPrice
        } else {
            binding.totalPrice = 0F
        }
    }

    private fun setEvents() {
        ll_cart_number.setOnClickListener { startActivity<CartActivity>() }
        btnBack.setOnClickListener { finish() }
        btnCancelOrder.setOnClickListener {
            order?.id?.let { it1 -> orderViewModel.cancelOrder(it1) }
            order?.id = 4
            binding.tvStatusOrder.text="Da huy"
            binding.btnCancelOrder.gone()
        }
    }
}
