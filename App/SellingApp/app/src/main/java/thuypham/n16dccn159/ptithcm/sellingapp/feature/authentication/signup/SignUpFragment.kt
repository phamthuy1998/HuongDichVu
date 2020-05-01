package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import thuypham.n16dccn159.ptithcm.sellingapp.R

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

}
