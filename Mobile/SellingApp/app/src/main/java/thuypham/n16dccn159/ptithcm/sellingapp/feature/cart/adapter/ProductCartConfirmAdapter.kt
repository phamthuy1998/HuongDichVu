package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductConfirmBinding

class ProductCartConfirmAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listProductSale: ArrayList<ProductCart> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProductViewHolder(
            ItemProductConfirmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listProductSale.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).bind(listProductSale[position])
    }

    fun setProductList(list: List<ProductCart>) {
        listProductSale.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(
        private val binding: ItemProductConfirmBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductCart) {
            binding.apply {
                product = item
                executePendingBindings()
            }
        }
    }
}