package com.agvber.signup_mvvm.model

sealed interface EmailUiState {

    object Mismatch: EmailUiState

    data class Match(val email: String): EmailUiState
}