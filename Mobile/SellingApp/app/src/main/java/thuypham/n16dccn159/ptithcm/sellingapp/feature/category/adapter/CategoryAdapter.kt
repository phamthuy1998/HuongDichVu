package thuypham.n16dccn159.ptithcm.sellingapp.feature.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thuypham.n16dccn159.ptithcm.sellingapp.data.Category
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ItemCategoryBinding

class CategoryAdapter(
    private var onCategoryClick: (id:Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listCategory: ArrayList<Category> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PlantViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listCategory.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlantViewHolder).bind(listCategory[position])
    }

    fun setListCategory(list: List<Category>) {
        listCategory.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class PlantViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {
            binding.apply {
                category = item
                executePendingBindings()
                itemCategory.setOnClickListener { item.id?.let { it1 -> onCategoryClick(it1) } }
            }
        }
    }
}