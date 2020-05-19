package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.ext.replaceFragment

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
       replaceFragment(id = R.id.frmCart, fragment = CartFragment())
    }
}
