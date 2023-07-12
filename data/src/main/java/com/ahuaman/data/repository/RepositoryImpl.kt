package com.ahuaman.data.repository

import com.ahuaman.data.remote.RemoteDataSource
import com.ahuaman.domain.LoginForm
import com.ahuaman.domain.LoginResponse
import com.ahuaman.domain.RegisterForm
import com.ahuaman.domain.RegisterResponse
import com.ahuaman.domain.UserResponse
import com.ahuaman.domain.UsersListResponse
import com.ahuaman.network.performNetworkFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface Repository {
    fun login(loginForm: LoginForm) : Flow<LoginResponse>
    fun getUsers(page: Int, per_page: Int) : Flow<UsersListResponse>
    fun getUser(id: Int) : Flow<UserResponse>
    fun register(registerForm: RegisterForm) : Flow<RegisterResponse>
}

class RepositoryImpl @Inject constructor(
    private val remoteDataSource:RemoteDataSource
) : Repository {
    override fun login(loginForm: LoginForm): Flow<LoginResponse>  = performNetworkFlow {
        remoteDataSource.login(loginForm)
    }

    override fun getUsers(page: Int, per_page: Int): Flow<UsersListResponse> = performNetworkFlow {
        remoteDataSource.getUsers(page, per_page)
    }

    override fun getUser(id: Int): Flow<UserResponse>  = performNetworkFlow {
        remoteDataSource.getUser(id)
    }

    override fun register(registerForm: RegisterForm): Flow<RegisterResponse>  = performNetworkFlow {
        remoteDataSource.register(registerForm)
    }
}