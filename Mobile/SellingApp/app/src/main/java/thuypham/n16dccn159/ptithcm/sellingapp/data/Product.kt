package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName
import thuypham.n16dccn159.ptithcm.sellingapp.base.DynamicSearchAdapter

data class Product(
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("Price")
    val price: Float? = null,
    @SerializedName("Discount")
    val discount: Float? = null,
    @SerializedName("CateId")
    val cateId: Int? = null,
    @SerializedName("Description")
    val description: String? = null,
    @SerializedName("Information")
    val information: String? = null,
    @SerializedName("Image")
    val image: String? = null,
    @SerializedName("Display")
    val display: Boolean? = null,
    @SerializedName("Stock")
    val stock: Int? = null
) : DynamicSearchAdapter.Searchable {
    override fun getSearchCriteria(): String = name ?: ""
    override fun toString() = name ?: ""
}