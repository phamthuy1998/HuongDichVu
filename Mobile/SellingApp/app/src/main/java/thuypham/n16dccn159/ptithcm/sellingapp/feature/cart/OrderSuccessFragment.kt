package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_order_success.*
import org.jetbrains.anko.support.v4.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.MainActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.order.OrderActivity

class OrderSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEvents()
    }

    private fun addEvents() {
        btnBackOrderSuccess.setOnClickListener { startActivity<MainActivity>() }
        btn_continue_shopping_dialog.setOnClickListener { startActivity<MainActivity>() }
        btn_view_order.setOnClickListener {
            startActivity<OrderActivity>()
            requireActivity().finish()
        }
    }
}
