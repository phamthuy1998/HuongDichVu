package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.replaceFragment
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userViewModel = ViewModelProvider(this, Injection.provideAuthViewModelFactory())[UserViewModel::class.java]
        replaceFragment(fragment = SignInUpFragment())
    }

    fun onBackLogin(view: View) { finish()}
}
