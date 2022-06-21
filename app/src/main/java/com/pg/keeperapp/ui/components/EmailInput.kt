package com.pg.keeperapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EmailInput(
    email: String,
    label: String = "Email Address (Required)",
    placeholderLabel: String = "Enter your email address",
    errorLabel: String = "Please use a a valid email address",
    isEmailValid: Boolean,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    reset: () -> Unit,
    onImeAction: () -> Unit = {}
    ){
    var showError by remember { mutableStateOf(false)}
    var focused by remember { mutableStateOf(true)}
    var hadFocus by remember { mutableStateOf(false)}

    Column(){
        Text(text = label, modifier = Modifier.padding(bottom = 4.dp))
        KTextField(value = email,
            onValueChanged = {onValueChanged.invoke(it)},
            modifier = modifier.onFocusChanged {
                focused = it.isFocused
                if(focused && !hadFocus) hadFocus = true
                showError = !focused && hadFocus && email.isNotEmpty() && !isEmailValid
            },
            resetField = {reset.invoke()},
            keyboardType = KeyboardType.Email,
            placeholder = {Text(text = placeholderLabel)},
            keyboardActions = KeyboardActions(onNext = {onImeAction()})
            )

        if(showError){
            Text(text = errorLabel, color = Color.Red)
        }
    }


}