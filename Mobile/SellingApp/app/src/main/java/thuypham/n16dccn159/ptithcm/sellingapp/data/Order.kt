package thuypham.n16dccn159.ptithcm.sellingapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Order(
    @SerializedName("Id")
    var id: Int? = null,
    @SerializedName("UserId")
    var userID: Int? = null,
    @SerializedName("BuyDate")
    var buyDate: String? = null,
    @SerializedName("Name")
    var name: String? = null,
    @SerializedName("Phone")
    var phone: String? = null,
    @SerializedName("Email")
    var email: String? = null,
    @SerializedName("Address")
    var address: String? = null,
    @SerializedName("Note")
    var note: String? = null,
    @SerializedName("StatusId")
    var statusID: Int? = null
):Parcelable

data class OrderItem(
    @SerializedName("Id")
    var id: Int? = null,
    @SerializedName("Quantity")
    var quantity: Int? = null,
    @SerializedName("UnitPrice")
    var unitPrice: Float? = null,
    @SerializedName("ProId")
    var productId: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("Image")
    val image: String? = null,
    @SerializedName("OrderId")
    var orderID: Int? = null
)

@Parcelize
data class OrderStatus(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("StatusName")
    val statusName: String
): Parcelable