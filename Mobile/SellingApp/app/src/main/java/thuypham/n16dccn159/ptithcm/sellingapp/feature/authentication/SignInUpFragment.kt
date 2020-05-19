package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentSignInUpBinding
import thuypham.n16dccn159.ptithcm.sellingapp.ext.addFragment

class SignInUpFragment : Fragment() {

    private lateinit var binding: FragmentSignInUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.fragment = this
    }

    fun onClickShowSignUpFragment() {
        requireActivity().addFragment(fragment = SignUpFragment())
    }

    fun onClickShowSignInFragment() {
        requireActivity().addFragment(fragment = LoginFragment())
    }
}
