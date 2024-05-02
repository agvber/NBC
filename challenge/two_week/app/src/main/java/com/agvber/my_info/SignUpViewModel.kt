package com.agvber.my_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _name: MutableStateFlow<String> = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    fun updateName(name: String) {
        viewModelScope.launch { _name.emit(name) }
    }

    private val _id: MutableStateFlow<String> = MutableStateFlow("")
    val id: StateFlow<String> =  _id.asStateFlow()

    fun updateId(id: String) {
        viewModelScope.launch { _id.emit(id) }
    }

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password: StateFlow<String> =  _password.asStateFlow()

    fun updatePassword(password: String) {
        viewModelScope.launch { _password.emit(password) }
    }

    val buttonEnable: StateFlow<Boolean> =
        combine(name, id, password) { name, id, password ->
            name.isNotBlank() || id.isNotBlank() || password.isNotBlank()
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = false
            )

    val toastMessage: StateFlow<String> =
        combine(name, id, password) { name, id, password ->
            "이름: $name, 아이디: $id, 패스워드: $password"
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = ""
            )
}