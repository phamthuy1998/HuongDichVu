package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thuypham.n16dccn159.ptithcm.sellingapp.data.CartType
import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductCartBinding

class ProductCartAdapter(
    private var onProductClick: (id: Int, type: CartType) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listProductSale: ArrayList<ProductCart> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProductCartViewHolder(
            ItemProductCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listProductSale.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductCartViewHolder).bind(listProductSale[position])
    }

    fun setProductList(list: List<ProductCart>) {
        listProductSale.apply {
            clear()
            addAll(list)
        }

        notifyDataSetChanged()
    }

    inner class ProductCartViewHolder(
        private val binding: ItemProductCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductCart) {
            binding.apply {
                product = item
                executePendingBindings()
                itemProductCart.setOnClickListener {
                    item.id?.let { it1 ->
                        onProductClick(it1, CartType.CLICK)
                    }
                }
                btnMinus.setOnClickListener {
                    item.id?.let { it1 ->
//                        item.quantity?.minus(1)
//                        binding.tvNumberPrCart.text =  item.quantity.toString()
                        onProductClick(it1, CartType.MINUS)
                    }
                }
                btnPlus.setOnClickListener {
                    item.id?.let { it1 ->
//                        item.quantity?.minus(1)
//                        binding.tvNumberPrCart.text = (item.quantity?.plus(1)).toString()
                        onProductClick(it1, CartType.PLUS)
                    }
                }
                btnDelCart.setOnClickListener {
                    item.id?.let { it1 ->
                        onProductClick(it1, CartType.DEL)
                    }
                }
            }
        }
    }
}