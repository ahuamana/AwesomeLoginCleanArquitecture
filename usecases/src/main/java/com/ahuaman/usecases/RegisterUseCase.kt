package com.ahuaman.usecases

import com.ahuaman.data.repository.Repository
import com.ahuaman.domain.LoginForm
import com.ahuaman.domain.RegisterForm
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(registerForm: RegisterForm) = repository.register(registerForm)
}