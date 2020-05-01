package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("")
    val name: String? = null,
    @SerializedName("")
    val email: String? = null,
    @SerializedName("")
    val phone: String? = null,
    @SerializedName("")
    val address: String? = null,
    @SerializedName("")
    val username: String? = null,
    @SerializedName("")
    val password: String? = null,
    @SerializedName("")
    val avatar: String? = null,
    @SerializedName("")
    val roleId: Int? = null,
    @SerializedName("")
    val lock: Boolean? = null
)