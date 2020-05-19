package thuypham.n16dccn159.ptithcm.sellingapp.ext

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import thuypham.n16dccn159.ptithcm.sellingapp.R


fun Activity.hideSoftKeyboard() {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as? InputMethodManager

    inputMethodManager?.hideSoftInputFromWindow(
        currentFocus?.windowToken, 0
    )
}

fun Activity.showKeyBoard() {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager!!.toggleSoftInputFromWindow(
        currentFocus?.windowToken,
        InputMethodManager.SHOW_FORCED,
        0
    )
}


fun Activity?.replaceFragment(
    @IdRes id: Int = R.id.frmLogin,
    fragment: Fragment,
    tag: String? = null,
    addToBackStack: Boolean = false
) {
    val compatActivity = this as? AppCompatActivity ?: return
    compatActivity.supportFragmentManager.beginTransaction()
        .apply {
            replace(id, fragment, tag)
            if (addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
}

fun Activity?.removeFragment(tag: String) {
    val compatActivity = this as? AppCompatActivity ?: return
    val fragment = compatActivity.supportFragmentManager.findFragmentByTag(tag)
    if (fragment != null) supportFragmentManager.beginTransaction().remove(fragment).commit()
}

fun Activity?.addFragment(
    @IdRes id: Int = R.id.frmLogin,
    fragment: Fragment,
    tag: String? = null,
    addToBackStack: Boolean = true
) {
    val compatActivity = this as? AppCompatActivity ?: return
    compatActivity.supportFragmentManager.beginTransaction()
        .apply {
            add(id, fragment, tag)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            if (addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
}