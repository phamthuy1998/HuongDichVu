package thuypham.n16dccn159.ptithcm.sellingapp.widget

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Slide
import java.util.*


class SlidingImageAdapter(
    private val context: Context,
    private var arrAdv: ArrayList<Slide>,
    private var onSlideClick: (productID: Int?) -> Unit
) : PagerAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun setData(listAdv: ArrayList<Slide>) {
        if (listAdv.isNotEmpty()) {
            arrAdv.clear()
            arrAdv.addAll(listAdv)
            notifyDataSetChanged()
        }
    }

    override fun getCount(): Int {
        return arrAdv.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.slidingimages_layout_home, view, false)!!

        val imageView = imageLayout.findViewById(R.id.image) as ImageView

        Glide.with(context)
            .load(arrAdv[position].image)
            .into(imageView)

        view.addView(imageLayout, 0)

        imageView.setOnClickListener { onSlideClick(arrAdv[position].productID) }


        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }

}