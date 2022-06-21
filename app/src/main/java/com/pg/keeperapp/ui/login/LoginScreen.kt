package com.pg.keeperapp.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pg.keeperapp.ui.components.EmailInput
import com.pg.keeperapp.ui.components.KPeachButton
import com.pg.keeperapp.ui.components.Logo
import com.pg.keeperapp.ui.components.PasswordInput

//build the login screen that contains info from the viewmodel
@Composable
fun LoginScreen(){}



//build the login content that contains the components/look of the login screen
@Composable
fun LoginContent(
    navController: NavController,
    email: String,
    onEmailValueChanged: (String) -> Unit,
    isEmailValid: Boolean,
    password: String,
    isLoginInfoValid: Boolean,
    isLoading: Boolean,
    resetEmailInput: () -> Unit,
    passwordFocusRequest: FocusRequester,
    resetPasswordInput: () -> Unit,
    onPasswordValueChanged: (String) -> Unit,
    login: () -> Unit,
    regainedFocus: Boolean,
    errorMessageId: Int
){
    Column(verticalArrangement = Arrangement.Center) {
        Logo()
        Spacer(modifier = Modifier.padding(4.dp))
        EmailInput(
            email = email,
            isEmailValid = isEmailValid,
            onValueChanged = onEmailValueChanged,
            modifier = Modifier,
            reset = resetEmailInput
        )
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordInput(
            password = password,
            onValueChanged = onPasswordValueChanged,
            reset = resetPasswordInput,
            validLoginInfo = isLoginInfoValid,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.padding(4.dp))
        LoginButton(isEnabled = isLoginInfoValid, onClick = login , isLoading = isLoading )
    }
}


//additional components specific to login screen
@Composable
fun LoginButton(isEnabled: Boolean, onClick: () -> Unit, isLoading: Boolean){
    KPeachButton(onClick = { onClick() }, enabled = isEnabled) {
        if(isLoading){
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(24.dp)){
                CircularProgressIndicator(color = Color.White)
            }
        }else{
            Text(text = "Log In")
        }
    }
}