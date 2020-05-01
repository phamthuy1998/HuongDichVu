package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("")
    val id: Int? = null,
    @SerializedName("")
    val name: String? = null,
    @SerializedName("")
    val price: Float? = null,
    @SerializedName("")
    val discount: Float? = null,
    @SerializedName("")
    val cateId: Int? = null,
    @SerializedName("")
    val description: String? = null,
    @SerializedName("")
    val information: String? = null,
    @SerializedName("")
    val image: String? = null,
    @SerializedName("")
    val display: String? = null
) {
    override fun toString() = name ?: ""
}