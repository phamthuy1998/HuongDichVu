package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.ResultApi
import thuypham.n16dccn159.ptithcm.sellingapp.data.User

interface AuthRepository {
    fun login(email: String, password: String): Result<ResultApi>
    fun signUp(
        username: String,
        password: String,
        name: String,
        email: String,
        phone: String,
        address: String
    ): Result<ResultApi>

    fun changeInfo(
        userId: Int,
        name: String,
        email: String,
        phone: String,
        address: String,
        avatar: String
    ): Result<ResultApi>

    fun forgotPassword(email: String): Result<Int>

    fun changePassword(
        userId: Int,
        oldPass: String,
        newPass: String
    ): Result<ResultApi>

    fun getUserInfoByUserID(userID: Int): Result<User>
}