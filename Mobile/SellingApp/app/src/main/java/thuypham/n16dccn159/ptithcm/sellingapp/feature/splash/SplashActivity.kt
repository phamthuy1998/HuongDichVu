package thuypham.n16dccn159.ptithcm.sellingapp.feature.splash

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.ext.USER_ID
import thuypham.n16dccn159.ptithcm.sellingapp.ext.getIntPref
import thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.LoginActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.MainActivity

class SplashActivity : AppCompatActivity() , Animation.AnimationListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ivLogo?.apply {
            doOnLayout {
                val animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.anim_splash)
                startAnimation(animation)
                animation?.setAnimationListener(this@SplashActivity)
            }
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        openNextScreen()
    }

    private fun openNextScreen() {
        if(getIntPref(USER_ID)==-1)startActivity<LoginActivity>()
        else startActivity<MainActivity>()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    override fun onAnimationStart(animation: Animation?) {}

    override fun onAnimationRepeat(animation: Animation?) {}
}
