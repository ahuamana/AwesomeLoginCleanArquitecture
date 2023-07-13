package com.ahuaman.customloginglasseffect.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.domain.LoginForm
import com.ahuaman.usecases.GetUserByIdUseCase
import com.ahuaman.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
@HiltViewModel
class LoginPasswordViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email:StateFlow<String> = _email

    private val _name = MutableStateFlow("")
    val name:StateFlow<String> = _name

    private val _image = MutableStateFlow("")
    val image:StateFlow<String> = _image


    private val _isLoginSuccessful = MutableStateFlow(false)
    val isLoginSuccessful:StateFlow<Boolean> = _isLoginSuccessful

    init {
        savedStateHandle.get<String>("id")?.let { id ->
            Timber.d("idReceived: $id")
            getUserById(id.toInt())
            "eve.holt@reqres.in" // "cityslicka"
        }
    }


    private fun getUserById(id:Int)= viewModelScope.launch{
        getUserByIdUseCase
            .invoke(id)
            .onEach {  user ->
                _name.value = "${user?.first_name} ${user?.last_name}"
                _email.value = user?.email ?: ""
                _image.value = user?.avatar ?: ""
            }.catch {
                Timber.e("Error getting user by id")
            }.launchIn(viewModelScope)
    }

    fun login(email:String, password:String) = viewModelScope.launch{
        val loginForm = LoginForm(email, password)
        loginUseCase
            .invoke(loginForm)
            .onEach {  user ->
                _isLoginSuccessful.value = true
                Timber.d("User: $user")
            }.catch {
                Timber.e("Error login + ${it.message} + ${it.cause}")
            }.launchIn(viewModelScope)
    }

}

data class LoginPasswordUiState(
    val isLoginSuccessful:Boolean = false,
)