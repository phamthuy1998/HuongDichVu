package thuypham.n16dccn159.ptithcm.sellingapp.ext

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

fun Activity.hideSoftKeyboard() {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as? InputMethodManager

    inputMethodManager?.hideSoftInputFromWindow(
        currentFocus?.windowToken, 0
    )
}

//fun Activity.showBadge(
//    message: String? = EMPTY_STRING,
//    @LayoutRes toastLayoutId: Int = R.layout.layout_badge
//) {
//    runOnUiThread {
//        val viewToast =
//            layoutInflater.inflate(toastLayoutId, findViewById(R.id.tvMessage))
//
//        (viewToast as? TextView)?.text = message
//
//        val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
//
//        val toast = Toast(this).apply {
//            duration = Toast.LENGTH_LONG
//            view = viewToast
//            setGravity(
//                Gravity.FILL_HORIZONTAL or Gravity.TOP,
//                xOffset,
//                appBarLayout?.measuredHeight ?: (yOffset - 100)
//            )
//        }
//
//        toast.show()
//    }
//}