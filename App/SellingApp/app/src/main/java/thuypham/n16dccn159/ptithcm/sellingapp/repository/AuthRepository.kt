package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.User

interface AuthRepository {
    fun login(email: String, password: String) : Result<Boolean>
    fun signUp(user: User) : Result<Boolean>
    fun forgotPassword(email: String) : Result<Boolean>
}