package com.ahuaman.usecases

import com.ahuaman.data.repository.Repository
import com.ahuaman.domain.LoginForm
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(loginForm: LoginForm) = repository.login(loginForm)
}