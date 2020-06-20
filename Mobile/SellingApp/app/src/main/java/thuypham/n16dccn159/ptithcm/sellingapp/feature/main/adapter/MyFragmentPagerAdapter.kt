package thuypham.n16dccn159.ptithcm.sellingapp.feature.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyFragmentPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val fragmentlist: MutableList<Fragment> = ArrayList()
    private val titleList: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentlist[position]
    }

    override fun getCount(): Int {
        return fragmentlist.size
    }

   fun addFragment(fragment: Fragment, title:String){
       println("add fragment ${title}")
       fragmentlist.add(fragment)
       titleList.add(title)
   }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

}