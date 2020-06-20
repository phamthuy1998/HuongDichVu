package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("Email")
    val email: String? = null,
    @SerializedName("Phone")
    val phone: String? = null,
    @SerializedName("Address")
    val address: String? = null,
    @SerializedName("Username")
    val username: String? = null,
    @SerializedName("Password")
    val password: String? = null,
    @SerializedName("Avatar")
    val avatar: String? = null,
    @SerializedName("RoleId")
    val roleId: Int? = null,
    @SerializedName("Lock")
    val lock: Boolean? = null
)
