package thuypham.n16dccn159.ptithcm.sellingapp.feature.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ll_cart.*
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.ext.hideSoftKeyboard
import thuypham.n16dccn159.ptithcm.sellingapp.ext.showKeyBoard
import thuypham.n16dccn159.ptithcm.sellingapp.feature.Search.SearchFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.CartActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.category.CategoryFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.home.HomeFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.adapter.MyFragmentPagerAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.feature.user.UserFragment

class MainActivity : AppCompatActivity() , ViewPager.OnPageChangeListener {
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                botNavigation.selectedItemId = R.id.bot_nav_home
                hideSoftKeyboard()
            }
            1 -> {
                botNavigation.selectedItemId = R.id.bot_nav_category
                hideSoftKeyboard()
            }
            2 -> {
                botNavigation.selectedItemId = R.id.bot_nav_search
                showKeyBoard()
            }
            3 -> {
                botNavigation.selectedItemId = R.id.bot_nav_user
                hideSoftKeyboard()
            }
        }
    }

    private val homeFragment by lazy {
        HomeFragment()
    }
    private val searchFragment by lazy {
        SearchFragment()
    }
    private val categoryFragment by lazy {
        CategoryFragment()
    }
    private val userFragment by lazy {
        UserFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideSoftKeyboard()
        addViewPager()
        addBotNavEvents()
        addEvents()
    }

    private fun addEvents() {
        viewPagerMain.addOnPageChangeListener(this)
        edtSearchMain.setOnClickListener {
            viewPagerMain.currentItem = 2
            edtSearchMain.requestFocus()
        }
        edtSearchMain.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchFragment.eventSearch(s.toString())
            }
        })
        ll_cart_number.setOnClickListener { startActivity<CartActivity>() }
    }

    private fun addBotNavEvents() {
        botNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bot_nav_home -> {
                    edtSearchMain.requestFocus()
                    viewPagerMain.currentItem = 0
                    hideSoftKeyboard()
                    true
                }
                R.id.bot_nav_category -> {
                    viewPagerMain.currentItem = 1
                    hideSoftKeyboard()
                    true
                }
                R.id.bot_nav_search -> {
                    viewPagerMain.currentItem = 2
                    showKeyBoard()
                    true
                }
                R.id.bot_nav_user -> {
                    viewPagerMain.currentItem = 4
                    hideSoftKeyboard()
                    true
                }
                else -> false
            }
        }
    }

    private fun addViewPager() {
        val viewPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(homeFragment, "Home fragment")
        viewPagerAdapter.addFragment(categoryFragment, "Category fragment")
        viewPagerAdapter.addFragment(searchFragment, "Search fragment")
        viewPagerAdapter.addFragment(userFragment, "User fragment")
        viewPagerMain.adapter = viewPagerAdapter
    }
}
