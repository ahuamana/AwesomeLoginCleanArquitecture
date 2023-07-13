package com.ahuaman.usecases

import com.ahuaman.data.repository.Repository
import com.ahuaman.domain.LoginForm
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(id: Int) = repository.getUser(id).map { it.data }
}