package com.ahuaman.customloginglasseffect.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.domain.GeneralErrorResponse
import com.ahuaman.domain.InvalidExceptionGeneral
import com.ahuaman.domain.RegisterForm
import com.ahuaman.usecases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel  @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _signUpState = MutableStateFlow(SignUpUiState())
    val signUpState: StateFlow<SignUpUiState> = _signUpState
    init {
        savedStateHandle.get<String>("email")?.let { email ->
            _email.value = email
        }
    }


    fun registerUser(name: String, email: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        val registerUser = RegisterForm(name, email, password)
        registerUseCase
            .invoke(registerUser)
            .onEach {
                Timber.d("registerUser: $it")
                _signUpState.value = SignUpUiState(isRegisterSuccessful = true)
            }.catch {
                when(it){
                    is InvalidExceptionGeneral -> {
                        Timber.e("registerUser general: ${it.message}")
                    }
                    else -> {
                        Timber.e("registerUser exception: ${it}")
                        Timber.e("registerUser: ${it.message}")
                    }
                }
            }.launchIn(viewModelScope)
    }

}

data class SignUpUiState(
    val isRegisterSuccessful: Boolean = false,
)
