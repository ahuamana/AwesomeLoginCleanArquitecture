package com.ahuaman.customloginglasseffect.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.domain.Data
import com.ahuaman.usecases.GetListUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginEmailViewModel @Inject constructor(
    private val getUsersUseCase: GetListUsersUseCase
) : ViewModel() {

    private var users = listOf<Data>()

    private var hasPreviousLogin = false

    private val _uiState = MutableStateFlow(UiStateLogin())
    val uiState = _uiState.asStateFlow()

    init {
        getUsers()
    }


    private fun getUsers() = viewModelScope.launch(Dispatchers.IO) {
        getUsersUseCase
            .invoke(1, 20)
            .onEach { usersListResponse ->
                users = usersListResponse.data
            }.catch {
                Timber.e("Error: ${it.message}")
            }.launchIn(viewModelScope)
    }

     fun login(email:String) = viewModelScope.launch {
         hasPreviousLogin = true
         val user = users.find { it.email == email }
         if (user != null) {
            _uiState.value = UiStateLogin(
                isLoginSuccessful = true,
                infoUser = user
            )
         } else {
            _uiState.value = UiStateLogin(
                isLoginSuccessful = false, error = "Email not found",
                infoUser = Data(
                    id = 0,
                    email = email,
                    first_name = "",
                    last_name = "",
                    avatar = ""
                )
            )
         }
    }

    fun resetState() {
        _uiState.value = UiStateLogin()
    }

    data class UiStateLogin(
        val isLoading: Boolean = false,
        val isLoginSuccessful: Boolean? = null,
        val error: String = "",
        val infoUser: Data? = null
    )

}