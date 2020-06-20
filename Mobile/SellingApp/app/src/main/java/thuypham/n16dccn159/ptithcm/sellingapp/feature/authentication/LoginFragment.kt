package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.jetbrains.anko.support.v4.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentLoginBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.MainActivity
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideAuthViewModelFactory()
        )[UserViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        bindingViewModel()
    }

    fun onBack() {
        requireActivity().onBackPressed()
    }

    private fun initView() {
        binding.userViewModel = userViewModel
        binding.fragment = this
    }

    private fun bindingViewModel() {
        userViewModel.resultLogin.observe(viewLifecycleOwner, Observer {
            when (it[0].result) {
                -1 , -2-> {
                    Toast.makeText(requireContext(), it[0].message, Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(requireContext(), it[0].message, Toast.LENGTH_LONG).show()
                    requireContext().setIntPref(USER_ID, it[0].result)
                    startActivity<MainActivity>()
                    requireActivity().finish()
                }
            }
        })

        userViewModel.networkStateLogin.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.RUNNING -> binding.progressLogin.visible()
                Status.SUCCESS -> {
                    binding.progressLogin.gone()
                }
                Status.FAILED -> {
                    binding.progressLogin.gone()
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    fun onClickLogin() {
        var check = true
        val email = binding.edtEmailSignIn.textTrim()
        val pass = binding.edtPasswordSignIn.textTrim()
        if (email.isEmpty()) {
            binding.edtEmailSignIn.error = getString(R.string.error_input_email_not_entered)
            check = false
        }
//        else if (!isValidEmail(email)) {
//            binding.edtEmailSignIn.error = getString(R.string.err_email_not_valid)
//            check = false
//        }
        if (pass.isEmpty()) {
            binding.edtPasswordSignIn.error = getString(R.string.error_old_passwords_is_empty)
            check = false
        }
        if (check) {
            userViewModel.login(email, pass)
        }
    }

}
