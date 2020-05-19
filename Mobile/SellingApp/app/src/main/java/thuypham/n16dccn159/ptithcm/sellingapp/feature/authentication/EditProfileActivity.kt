package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.ActivityEditProfileBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModel

class EditProfileActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideAuthViewModelFactory()
        )[UserViewModel::class.java]
    }

    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile)
        userViewModel.getInfoUser(getIntPref(USER_ID) ?: 0)
        bindViewModel()
    }

    private fun bindViewModel() {
        userViewModel.userInfo.observe(this) {
            binding.user = it
        }
        userViewModel.dataChangePass.observe(this) {
            Toast.makeText(this, it[0].message, Toast.LENGTH_LONG).show()
        }
        userViewModel.statusChangeInfo.observe(this) {
            Toast.makeText(this, it[0].message, Toast.LENGTH_LONG).show()
        }

        userViewModel.networkUserInfo.observe(this)
        {
            when (it.status) {
                Status.RUNNING -> binding.progressEditProfile.visible()
                Status.SUCCESS -> {
                    binding.progressEditProfile.gone()
                }
                Status.FAILED -> {
                    binding.progressEditProfile.gone()
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }

        userViewModel.networkChangePass.observe(this)
        {
            when (it.status) {
                Status.RUNNING -> binding.progressEditProfile.visible()
                Status.SUCCESS -> {
                    binding.progressEditProfile.gone()
                }
                Status.FAILED -> {
                    binding.progressEditProfile.gone()
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
        userViewModel.networkChangeInfo.observe(this)
        {
            when (it.status) {
                Status.RUNNING -> binding.progressEditProfile.visible()
                Status.SUCCESS -> {
                    binding.progressEditProfile.gone()
                }
                Status.FAILED -> {
                    binding.progressEditProfile.gone()
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun onBack(view: View) {
        finish()
    }

    fun onCheckChangePassword(view: View) {
        if ((view as CheckBox).isChecked) binding.llEditPassword.visible()
        else binding.llEditPassword.gone()
    }

    fun onClickChangeInfo(view: View) {
        var check = true
        val userName = binding.edtUsername.textTrim()
        val name = binding.edtNameEdit.textTrim()
        val phone = binding.edtPhoneEdit.textTrim()
        val mail = binding.edtEmailEdit.textTrim()
        val address = binding.edtAddress.textTrim()
        val pass = binding.edtOldPassword.textTrim()
        val newPass = binding.edtNewPass.textTrim()
        val reNewPass = binding.edtReNewPass.textTrim()
        if (userName.isEmpty()) {
            binding.edtUsername.error = getString(R.string.error_input_user)
            check = false
        }
        if (name.isEmpty()) {
            binding.edtNameEdit.error = getString(R.string.error_input_name_not_entered)
            check = false
        }
        if (phone.isEmpty()) {
            binding.edtPhoneEdit.error = getString(R.string.error_input_phone_not_entered)
            check = false
        }
        if (mail.isEmpty()) {
            binding.edtEmailEdit.error = getString(R.string.error_input_email_not_entered)
            check = false
        } else if (!isValidEmail(mail)) {
            binding.edtEmailEdit.error = getString(R.string.err_email_not_valid)
            check = false
        }
        if (address.isEmpty()) {
            binding.edtAddress.error = getString(R.string.error_input_email_not_entered)
            check = false
        }
        if (binding.cbChangePw.isChecked) {
            if (pass.isEmpty()) {
                binding.edtOldPassword.error = getString(R.string.error_old_passwords_is_empty)
                check = false
            }
            if (newPass.isEmpty()) {
                binding.edtNewPass.error = getString(R.string.error_new_pw_empty)
                check = false
            }
            if (reNewPass.isEmpty()) {
                binding.edtReNewPass.error = getString(R.string.error_re_new_pw_empty)
                check = false
            }
            if (newPass != reNewPass) {
                binding.edtReNewPass.error = getString(R.string.error_passwords_do_not_match)
                check = false
            }
            if (check) userViewModel.changePass(getIntPref(USER_ID), pass, newPass)
        }

        if (check) {
            userViewModel.changeInfo(
                userViewModel.userInfo.value?.id ?: 0,
                name,
                mail,
                phone,
                address,
                ""
            )
        }
    }
}
