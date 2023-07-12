package com.ahuaman.customloginglasseffect.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class LoginPasswordViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableStateFlow("")
    val email:StateFlow<String> = _email

    private val _name = MutableStateFlow("")
    val name:StateFlow<String> = _name


}