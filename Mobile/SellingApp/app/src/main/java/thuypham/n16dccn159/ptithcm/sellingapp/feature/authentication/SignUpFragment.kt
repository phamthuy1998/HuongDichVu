package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentSignUpBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModel

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideAuthViewModelFactory()
        )[UserViewModel::class.java]
    }
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun onBack(){
        requireActivity().onBackPressed()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
    }

    private fun initViews() {
        binding.userViewModel = userViewModel
        binding.fragment = this
    }

    private fun bindViewModel() {
        userViewModel.dataRegister.observe(viewLifecycleOwner, Observer {
            when (it[0].result) {
                1 -> {
                    Toast.makeText(requireContext(), it[0].message, Toast.LENGTH_LONG).show()
                    requireActivity().replaceFragment(fragment = LoginFragment())
                }
                else -> {
                    Toast.makeText(requireContext(), it[0].message, Toast.LENGTH_LONG).show()
                }
            }
        })

        userViewModel.networkStateSignUp.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.RUNNING -> binding.progressSignUp.visible()
                Status.SUCCESS -> {
                    binding.progressSignUp.gone()
                }
                Status.FAILED -> {
                    binding.progressSignUp.gone()
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
            }
            binding.progressSignUp.visibility =
                if (it.status == Status.RUNNING) View.VISIBLE else View.GONE
        })
    }

    fun onSignUp() {
        var check = true
        val userName = binding.edtUsername.textTrim()
        val name = binding.edtName.textTrim()
        val phone = binding.edtPhone.textTrim()
        val mail = binding.edtMail.textTrim()
        val address = binding.edtAddress.textTrim()
        val pass = binding.edtPass.textTrim()
        if (userName.isEmpty()) {
            binding.edtUsername.error = getString(R.string.error_input_user)
            check = false
        }
        if (name.isEmpty()) {
            binding.edtName.error = getString(R.string.error_input_name_not_entered)
            check = false
        }
        if (phone.isEmpty()) {
            binding.edtPhone.error = getString(R.string.error_input_phone_not_entered)
            check = false
        }
        if (mail.isEmpty()) {
            binding.edtMail.error = getString(R.string.error_input_email_not_entered)
            check = false
        } else if (!isValidEmail(mail)) {
            binding.edtMail.error = getString(R.string.err_email_not_valid)
            check = false
        }
        if (address.isEmpty()) {
            binding.edtAddress.error = getString(R.string.error_input_email_not_entered)
            check = false
        }
        if (pass.isEmpty()) {
            binding.edtPass.error = getString(R.string.error_old_passwords_is_empty)
            check = false
        }

        if (check) {
            userViewModel.signUp(userName, pass, name, mail, phone, address)
        }
    }

}
