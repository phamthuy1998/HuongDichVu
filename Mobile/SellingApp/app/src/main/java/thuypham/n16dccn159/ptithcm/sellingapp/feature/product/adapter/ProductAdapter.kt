package thuypham.n16dccn159.ptithcm.sellingapp.feature.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thuypham.n16dccn159.ptithcm.sellingapp.base.DynamicSearchAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemProductBinding

class ProductAdapter(
    private var listProductSale: MutableList<Product> = arrayListOf(),
    private var onProductClick: (id: Int) -> Unit
) : DynamicSearchAdapter<Product>(listProductSale) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PlantViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listProductSale.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlantViewHolder).bind(listProductSale[position])
    }

    fun setProductList(list: ArrayList<Product>) {
        listProductSale.apply {
            clear()
            addAll(list)
            updateData(list)
            notifyDataSetChanged()
        }
    }

    fun addDataSearch(arr: MutableList<Product>) {
        listProductSale.apply {
            clear()
            addAll(arr)
            notifyDataSetChanged()
        }
    }

    fun removeAllData() {
        listProductSale.apply {
            clear()
            notifyDataSetChanged()
        }
    }

    inner class PlantViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            binding.apply {
                product = item
                executePendingBindings()
                itemProduct.setOnClickListener { item.id?.let { it1 -> onProductClick(it1) } }
            }
        }
    }
}