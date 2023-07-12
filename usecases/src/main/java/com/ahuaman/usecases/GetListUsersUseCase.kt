package com.ahuaman.usecases

import com.ahuaman.data.repository.Repository
import com.ahuaman.domain.LoginForm
import javax.inject.Inject

class GetListUsersUseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(page: Int, per_page: Int) = repository.getUsers(page, per_page)
}