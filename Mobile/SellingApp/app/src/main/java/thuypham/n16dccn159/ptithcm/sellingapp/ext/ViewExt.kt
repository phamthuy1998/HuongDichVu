package thuypham.n16dccn159.ptithcm.sellingapp.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import thuypham.n16dccn159.ptithcm.sellingapp.R

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}

fun View.setAutoHideKeyboard(activity: Activity) {
    // Set up touch listener for non-text box views to hide keyboard.
    if (this !is EditText) {
        setOnTouchListener { _, _ ->
            activity.hideSoftKeyboard()
            false
        }
    }

    //If a layout container, iterate over children and seed recursion.
    if (this is ViewGroup) {
        for (i in 0 until childCount) {
            val innerView = getChildAt(i)
            innerView.setAutoHideKeyboard(activity)
        }
    }
}
/*
fun <T> ViewGroup.addViewExt(
    context: Context, @LayoutRes layoutItem: Int,
    itemList: ArrayList<T>,
    orientation: Int = LinearLayout.HORIZONTAL,
    listener: (itemView: View?, item: T, position: Int) -> Unit
) {
    this.removeAllViews()
    val param = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    val childGroup = LinearLayout(context)
    childGroup.orientation = orientation
    childGroup.layoutParams = param
    itemList.forEachIndexed { index, item ->
        AsyncLayoutInflater(context).inflate(layoutItem, this) { view, _, _ ->
            view.apply {
                listener.invoke(view, item, index)
            }
            childGroup.addView(view)
        }
    }
    this.addView(childGroup)
}*/
/*

fun View.slide() {
    val anim = if (isVisible)
        AnimationUtils.loadAnimation(context, R.anim.slide_down)
    else
        AnimationUtils.loadAnimation(context, R.anim.slide_up)

    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {}

        override fun onAnimationEnd(p0: Animation?) {
            isVisible = !isVisible
        }

        override fun onAnimationStart(p0: Animation?) {
        }

    })

    startAnimation(anim)
}
*/

/*
fun View.slideUp() {
    if (isVisible) return

    val anim = AnimationUtils.loadAnimation(context, R.anim.slide_up)
    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {}

        override fun onAnimationEnd(p0: Animation?) {
            isVisible = true
        }

        override fun onAnimationStart(p0: Animation?) {
        }

    })

    startAnimation(anim)
}*/
