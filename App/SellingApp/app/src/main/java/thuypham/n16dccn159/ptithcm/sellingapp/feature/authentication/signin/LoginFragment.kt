package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun onClickLogin() {

    }

    fun onClickForgotPw() {

    }

}
