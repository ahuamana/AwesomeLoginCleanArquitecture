package com.ahuaman.domain

data class LoginForm(
    val email: String,
    val password: String
)

data class RegisterForm(
    val email: String,
    val password: String,
    val name: String
)

data class RegisterResponse(
    val id: Int,
    val token: String
)

data class LoginResponse(
    val token: String
)

data class UsersListResponse(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)

data class UserResponse(
    val data: Data,
    val support: Support
)

data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)

data class Support(
    val text: String,
    val url: String
)
