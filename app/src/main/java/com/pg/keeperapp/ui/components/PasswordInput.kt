package com.pg.keeperapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pg.keeperapp.R


@Composable
fun PasswordInput(
    password: String,
    onValueChanged: (String) -> Unit,
    reset: () -> Unit,
    validLoginInfo: Boolean,
    onImeAction: () -> Unit = {},
    modifier: Modifier
){
    val focusManager = LocalFocusManager.current
    Column(verticalArrangement = Arrangement.Center){
        Text(
            text = "Password (Required)",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        KTextField(value = password,
            onValueChanged = {onValueChanged.invoke(it)},
            resetField = { reset.invoke() },
            keyboardType = KeyboardType.Password,
            modifier = modifier,
            placeholder = {
                Text(
                    text = "Enter Your Password",
                    style = MaterialTheme.typography.body1
                )
            },
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(
                onDone = {
                    if(validLoginInfo){
                        focusManager.clearFocus()
                        onImeAction()
                    }
                }
            )
        )
    }



}