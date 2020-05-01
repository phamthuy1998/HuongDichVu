package com.thuypham.ptithcm.mytiki.viewsHelp

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.thuypham.ptithcm.mytiki.R
import com.thuypham.ptithcm.mytiki.main.fragment.category.model.Advertisement
import java.util.ArrayList
import androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory


class SlidingImage_Adapter(private val context: Context, private val arrAdv: ArrayList<Advertisement>) : PagerAdapter() {
    private val inflater: LayoutInflater


    init {
        inflater = LayoutInflater.from(context)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return arrAdv.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(com.thuypham.ptithcm.mytiki.R.layout.slidingimages_layout_home, view, false)!!

        val imageView = imageLayout
                .findViewById(com.thuypham.ptithcm.mytiki.R.id.image) as ImageView


        Glide.with(context)
            .load(arrAdv[position].image)
            .into(imageView)

        view.addView(imageLayout, 0)

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