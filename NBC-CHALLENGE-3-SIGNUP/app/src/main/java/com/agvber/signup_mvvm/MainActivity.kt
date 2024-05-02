package com.agvber.signup_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.agvber.signup_mvvm.databinding.ActivityMainBinding
import com.agvber.signup_mvvm.model.EmailUiState
import com.agvber.signup_mvvm.model.PasswordUiState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
            Toast.makeText(this, "완료!", Toast.LENGTH_SHORT).show()
        }


        lifecycleScope.launch {
            viewModel.buttonEnable.collectLatest {
                binding.signupButton.isEnabled = it
            }
        }

        watchEditText()
    }

    private fun watchEditText() {
        binding.apply {
            listOf(
                nameEditText,
                localEditText,
                domainEditText,
                passwordEditText,
                confirmPasswordEditText
            )
                .forEach { editText ->
                    editText.addTextChangedListener { updateEditText(editText) }

                    editText.setOnFocusChangeListener { v, hasFocus ->
                        if (!hasFocus) focusEditText(editText)
                    }
                }
        }
    }

    private fun updateEditText(editText: EditText) {
        binding.apply {
            when (editText.id) {
                nameEditText.id -> { viewModel.updateName(editText.text.toString()) }
                localEditText.id -> { viewModel.updateLocalEmail(editText.text.toString()) }
                domainEditText.id -> { viewModel.updateDomainEmail(editText.text.toString()) }
                passwordEditText.id -> { viewModel.updatePassword(editText.text.toString()) }
                confirmPasswordEditText.id -> { viewModel.updateConfirmPassword(editText.text.toString()) }
            }
        }
    }

    private fun focusEditText(editText: EditText) {
        binding.apply {
            when (editText.id) {
                nameEditText.id -> {
                    nameStateTextView.text = if (viewModel.name.value.isEmpty()) "이름을 입력해주세요." else ""
                }
                in listOf(localEditText.id, domainEditText.id) -> {
                    emailStateTextView.text =
                        when (viewModel.emailStateValue.value) {
                            is EmailUiState.Mismatch -> "이메일을 입력해주세요."
                            is EmailUiState.Match -> ""
                        }
                }
                passwordEditText.id -> {
                    passwordStateTextView.text =
                        when(viewModel.password.value) {
                            is PasswordUiState.Mismatch -> "10자리 이상, 특수문자, 대문자 포함"
                            is PasswordUiState.Match -> ""
                        }
                }
            }
        }
    }
}