package com.agvber.signup_mvvm.model

sealed interface PasswordUiState {

    object Mismatch: PasswordUiState

    data class Match(val password: String): PasswordUiState
}