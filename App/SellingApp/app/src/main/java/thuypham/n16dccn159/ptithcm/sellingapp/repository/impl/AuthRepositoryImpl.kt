package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.User
import thuypham.n16dccn159.ptithcm.sellingapp.repository.AuthRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class AuthRepositoryImpl(private val apiService: ApiService) : AuthRepository {
    override fun login(email: String, password: String): Result<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signUp(user: User): Result<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun forgotPassword(email: String): Result<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}