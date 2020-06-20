package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("CateId")
    val id: Int?,
    @SerializedName("CateName")
    val name: String?,
    @SerializedName("CateImage")
    val image: String?,
    @SerializedName("Display")
    val display: Boolean?
)