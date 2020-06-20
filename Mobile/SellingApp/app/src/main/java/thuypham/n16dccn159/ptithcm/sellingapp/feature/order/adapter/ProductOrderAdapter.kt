package thuypham.n16dccn159.ptithcm.sellingapp.feature.order.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thuypham.n16dccn159.ptithcm.sellingapp.base.DynamicSearchAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductBinding
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductConfirmBinding
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductOrderBinding

class ProductOrderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listProductSale: MutableList<OrderItem> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProductConfirmViewHolder(
            ItemProductOrderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listProductSale.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductConfirmViewHolder).bind(listProductSale[position])
    }

    fun setProductList(list: ArrayList<OrderItem>) {
        listProductSale.apply {
            clear()
            addAll(list)
            notifyDataSetChanged()
        }
    }

    inner class ProductConfirmViewHolder(
        private val binding: ItemProductOrderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OrderItem) {
            binding.apply {
                product = item
                executePendingBindings()
            }
        }
    }
}