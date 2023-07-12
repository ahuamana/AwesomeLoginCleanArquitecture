package com.ahuaman.customloginglasseffect.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel  @Inject constructor() : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

}
