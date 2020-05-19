package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentAddressCartBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.isValidEmail
import thuypham.n16dccn159.ptithcm.sellingapp.ext.isValidPhoneNumber
import thuypham.n16dccn159.ptithcm.sellingapp.ext.replaceFragment
import thuypham.n16dccn159.ptithcm.sellingapp.ext.textTrim
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel

/**
 * A simple [Fragment] subclass.
 */
class AddressCartFragment : Fragment() {
    private lateinit var binding: FragmentAddressCartBinding
    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }
    private var isTextOk: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddressCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = cartViewModel
        binding.fragment = this
        addEvents()
    }

    private fun addEvents() {
        binding.btnBackCartAddress.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnContinueConfirm.setOnClickListener { validateTextInput() }
    }

    private fun validateTextInput() {
        isTextOk = true
        if (binding.edtNameAddress.textTrim() == "") {
            binding.edtNameAddress.error = getString(R.string.error_input_name_not_entered)
            isTextOk = false
        }

        if (binding.edtPhoneAddress.textTrim() == "") {
            binding.edtPhoneAddress.error = getString(R.string.error_input_phone_not_entered)
            isTextOk = false
        } else if (!isValidPhoneNumber(binding.edtPhoneAddress.textTrim())) {
            binding.edtPhoneAddress.error = getString(R.string.error_input_phone_not_correct)
            isTextOk = false
        }

        if (binding.edtAddress.textTrim() == "") {
            binding.edtAddress.error = getString(R.string.error_input_address_not_entered)
            isTextOk = false
        }

        if (binding.edtEmailCart.textTrim() == "") {
            binding.edtEmailCart.error = getString(R.string.error_input_email_not_entered)
            isTextOk = false
        } else if (!isValidEmail(binding.edtEmailCart.textTrim())) {
            binding.edtEmailCart.error = getString(R.string.err_email_not_valid)
            isTextOk = false
        }
        if (isTextOk) showConfirmFragment()
    }

    private fun showConfirmFragment() {

        requireActivity().replaceFragment(
            id = R.id.frmCart,
            fragment = ConfirmOrderFragment(),
            addToBackStack = true
        )
    }

}
