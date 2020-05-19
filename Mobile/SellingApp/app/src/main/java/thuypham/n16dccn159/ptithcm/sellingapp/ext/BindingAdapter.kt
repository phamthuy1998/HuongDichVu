package thuypham.n16dccn159.ptithcm.sellingapp.ext

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderStatus
import java.math.RoundingMode
import java.text.DecimalFormat


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("textDiscount")
fun bindTextDiscount(view: TextView, discount: Float?) {
    if (discount != 0.toFloat()) {
        view.text = " - " + (discount?.times(100))?.toInt().toString() + "%"
    }
}

/*
@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindAdapter<*>) {
        (recyclerView.adapter as BindAdapter<T>).setData(data)
    }
}
*/

@BindingAdapter(value = ["statusID", "listStatus"], requireAll = false)
fun setOrderStatus(view: TextView, statusID: Int?, listStatus: ArrayList<OrderStatus>?) {
    if (listStatus != null)
        for (status in listStatus) {
            if (status.id == statusID) {
                view.text = status.statusName
                break;
            }
        }
}

@BindingAdapter(value = ["price", "discount"], requireAll = false)
fun bindTextPrice(view: TextView, price: Float?, discount: Float?) {
    if (price != null && discount != null) {
        val df = DecimalFormat("#,###,###")
        df.roundingMode = RoundingMode.CEILING
        val priceSale = price.minus((price.times(discount)))
        val priceSelling = df.format(priceSale) + " đ"
        view.text = priceSelling
    }
}

@BindingAdapter("txtPrice")
fun bindPrice(view: TextView, price: Float?) {
    val df = DecimalFormat("#,###,###")
    df.roundingMode = RoundingMode.CEILING
    val priceSelling = df.format(price ?: 0) + " đ"
    view.text = priceSelling
}

@BindingAdapter("txtPriceDiscount")
fun bindPriceDiscount(view: TextView, price: Float?) {
    val df = DecimalFormat("#,###,###")
    df.roundingMode = RoundingMode.CEILING
    val priceSelling = df.format(price ?: 0) + " đ"
    view.text = priceSelling
    view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

@BindingAdapter("productStock")
fun bindProductCount(view: TextView, stock: Int) {
    val strStock: String
    if (stock > 0) {
        strStock = "$stock sản phẩm sẵn có"
        view.setTextColor(Color.parseColor("#0C0C0C"))
    } else {
        strStock = "Hết hàng"
        view.setTextColor(Color.parseColor("#F44336"))
    }
    view.text = strStock
}

@BindingAdapter("enableBtnAddCart")
fun bindBtnAddCart(view: TextView, stock: Int) {
    view.isEnabled = stock > 0
}

@BindingAdapter("txtCartCount")
fun bindTextCartCount(view: TextView, counter: Int) {
    if (counter > 0) {
        view.visible()
        view.text = counter.toString()
    } else view.gone()
}