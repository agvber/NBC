package com.agvber.signup_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agvber.signup_mvvm.model.EmailUiState
import com.agvber.signup_mvvm.model.PasswordUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _name: MutableStateFlow<String> = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    fun updateName(name: String) {
        viewModelScope.launch { _name.emit(name) }
    }

    private val _localEmail: MutableStateFlow<String> = MutableStateFlow("")
    val localEmail: StateFlow<String> = _localEmail.asStateFlow()

    fun updateLocalEmail(localEmail: String) {
        viewModelScope.launch { _localEmail.emit(localEmail) }
    }

    private val _domainEmail: MutableStateFlow<String> = MutableStateFlow("")
    val domainEmail: StateFlow<String> = _domainEmail.asStateFlow()

    fun updateDomainEmail(domainEmail: String) {
        viewModelScope.launch { _domainEmail.emit(domainEmail) }
    }

    val emailStateValue: StateFlow<EmailUiState> = combine(localEmail, domainEmail) { local, domain ->
        val email = "$local@$domain"
        if (EMAIL_REGEX.containsMatchIn(email)) {
            return@combine EmailUiState.Match(email)
        }
        EmailUiState.Mismatch
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = EmailUiState.Mismatch
        )

    private val _password: MutableStateFlow<PasswordUiState> = MutableStateFlow(PasswordUiState.Mismatch)
    val password: StateFlow<PasswordUiState> = _password.asStateFlow()

    fun updatePassword(password: String) {
        viewModelScope.launch {
            if (PASSWORD_REGEX.containsMatchIn(password)) {
                _password.emit(PasswordUiState.Match(password))
                return@launch
            }
            _password.emit(PasswordUiState.Mismatch)
        }
    }

    private val _confirmPassword: MutableStateFlow<String> = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()

    fun updateConfirmPassword(confirmPassword: String) {
        viewModelScope.launch { _confirmPassword.emit(confirmPassword) }
    }

    val buttonEnable: StateFlow<Boolean> =
        combine(name, emailStateValue, password, confirmPassword) { name, email, password, confirmPassword ->
            name.isNotBlank() && email is EmailUiState.Match && password is PasswordUiState.Match && password.password == confirmPassword
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = false
            )

    companion object {
        private val EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex()
        private val PASSWORD_REGEX ="^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d])[A-Za-z\\d\\S]{10,}\$".toRegex()
    }
}