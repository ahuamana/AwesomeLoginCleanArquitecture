package com.ahuaman.data.remote

import com.ahuaman.network.BaseDataSource
import com.ahuaman.data.service.ReqresService
import com.ahuaman.domain.LoginForm
import com.ahuaman.domain.LoginResponse
import com.ahuaman.domain.RegisterForm
import com.ahuaman.domain.RegisterResponse
import com.ahuaman.domain.UserResponse
import com.ahuaman.domain.UsersListResponse
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun login(loginForm: LoginForm) : LoginResponse
    suspend fun getUsers(page: Int, per_page: Int) : UsersListResponse
    suspend fun getUser(id: Int) : UserResponse
    suspend fun register(registerForm: RegisterForm) : RegisterResponse
}

class RemoteDataSourceImpl @Inject constructor(
    private val reqresService: ReqresService
) : BaseDataSource(), RemoteDataSource {
    override suspend fun login(loginForm: LoginForm): LoginResponse = getResult (
        call = { reqresService.login(loginForm) },
        forceError = false
    )

    override suspend fun getUsers(page: Int, per_page: Int): UsersListResponse = getResult (
        call = { reqresService.getUsers(page, per_page) },
        forceError = false
    )

    override suspend fun getUser(id: Int): UserResponse  = getResult(
        call = { reqresService.getUser(id) },
        forceError = false
    )

    override suspend fun register(registerForm: RegisterForm): RegisterResponse  = getResult(
        call = { reqresService.register(registerForm) },
        forceError = false
    )

}