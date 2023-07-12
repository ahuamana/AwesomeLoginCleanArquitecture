package com.ahuaman.data.service

import com.ahuaman.domain.LoginForm
import com.ahuaman.domain.LoginResponse
import com.ahuaman.domain.RegisterForm
import com.ahuaman.domain.RegisterResponse
import com.ahuaman.domain.UserResponse
import com.ahuaman.domain.UsersListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReqresService {

    @POST("login")
    suspend fun login(loginForm: LoginForm): Response<LoginResponse>

    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Response<UsersListResponse>

    @GET("users/{id}")
    suspend fun getUser(
        @Query("id") id: Int
    ): Response<UserResponse>

    //https://reqres.in/api/register
    @POST("register")
    suspend fun register(registerForm: RegisterForm): Response<RegisterResponse>



}