package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.ResultApi
import thuypham.n16dccn159.ptithcm.sellingapp.data.User
import thuypham.n16dccn159.ptithcm.sellingapp.repository.AuthRepository

class UserViewModel(private val repository: AuthRepository) : ViewModel() {
    var address = MutableLiveData<String>().apply { value = "" }
    var email = MutableLiveData<String>().apply { value = "" }
    var password = MutableLiveData<String>().apply { value = "" }
    var name = MutableLiveData<String>().apply { value = "" }
    var userName = MutableLiveData<String>().apply { value = "" }
    var phone = MutableLiveData<String>().apply { value = "" }

    /*---------------- Check text empty set button enable ----------------*/
    fun isValidate(email: String): Boolean {
        return email.isNotEmpty()
    }

    fun isValidateLogin(): Boolean {
        return !email.value.equals("") && !password.value.equals("")
    }

    fun isValidateSignUp(): Boolean =
        !userName.value.equals("") && !name.value.equals("") && !address.value.equals("")
                && !phone.value.equals("") && !email.value.equals("") && !password.value.equals("")

    /*---------------Login---------------*/
    private val requestLogin = MutableLiveData<Result<ResultApi>>()

    val networkStateLogin = Transformations.switchMap(requestLogin) {
        it.networkState
    }

    val resultLogin = Transformations.switchMap(requestLogin) {
        it.data
    }

    fun login(email: String, password: String) {
        requestLogin.value = repository.login(email, password)
    }

    /*--------------- Sign Up ---------------*/
    private val requestSignUp = MutableLiveData<Result<ResultApi>>()

    val networkStateSignUp = Transformations.switchMap(requestSignUp) {
        it.networkState
    }
    val dataRegister = Transformations.switchMap(requestSignUp) {
        it.data
    }

    fun signUp(
        username: String,
        password: String,
        name: String,
        email: String,
        phone: String,
        address: String
    ) {
        requestSignUp.value = repository.signUp(username, password, name, email, phone, address)
    }

    /*--------------- Forgot password---------------*/
    private val requestForgotPassword = MutableLiveData<Result<Int>>()

    val networkStateForgotPassword = Transformations.switchMap(requestForgotPassword) {
        it.networkState
    }

    fun forgotPassword(email: String) {
        requestForgotPassword.value = repository.forgotPassword(email)
    }

    /*--------------- get user info---------------*/
    private val requestUserInfo = MutableLiveData<Result<User>>()

    val networkUserInfo = Transformations.switchMap(requestUserInfo) {
        it.networkState
    }

    val userInfo = Transformations.switchMap(requestUserInfo) {
        it.data
    }

    fun getInfoUser(userID: Int) {
        requestUserInfo.value = repository.getUserInfoByUserID(userID)
    }


    /*---------------Change acc info --------------*/
    private val requestChangeInfo = MutableLiveData<Result<ResultApi>>()

    val networkChangeInfo = Transformations.switchMap(requestChangeInfo) {
        it.networkState
    }

    val statusChangeInfo = Transformations.switchMap(requestChangeInfo) {
        it.data
    }

    fun changeInfo(
        userId: Int,
        name: String,
        email: String,
        phone: String,
        address: String,
        avatar: String
    ) {
        requestChangeInfo.value =
            repository.changeInfo(userId, name, email, phone, address, avatar)
    }

    /*---------------Change pass --------------*/
    private val requestChangePass = MutableLiveData<Result<ResultApi>>()

    val networkChangePass = Transformations.switchMap(requestChangePass) {
        it.networkState
    }

    val dataChangePass = Transformations.switchMap(requestChangePass) {
        it.data
    }

    fun changePass(
        userId: Int,
        oldPass: String,
        newPass: String
    ) {
        requestChangePass.value =
            repository.changePassword(userId, oldPass, newPass)
    }
}


class UserViewModelFactory(
    private val repository: AuthRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = UserViewModel(repository) as T
}