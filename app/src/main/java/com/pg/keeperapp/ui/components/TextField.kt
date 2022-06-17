package com.pg.keeperapp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pg.keeperapp.R

@Composable
fun KTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    resetField: () -> Unit,
    placeholder: @Composable () -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    singleLine: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default
    ){

    val isLight = MaterialTheme.colors.isLight

    androidx.compose.material.TextField(
        value = value,
        onValueChange = onValueChanged,
        modifier =
        modifier
            .fillMaxWidth()
            .clip(shape = shapes.medium)
            .border(
                width = 1.dp,
                color = if (isLight) Color.DarkGray else Color.White,
                shape = shapes.medium
            ),
        shape = shapes.medium,
        colors =
        TextFieldDefaults.textFieldColors(
            textColor = Color.DarkGray,
            placeholderColor = Color.Gray,
            backgroundColor = Color.White,
            errorLabelColor = Color.Red,
            cursorColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent
        ),
        textStyle = MaterialTheme.typography.body1,
        keyboardOptions =
        KeyboardOptions.Default.copy(keyboardType = keyboardType, imeAction = imeAction),
        visualTransformation = getVisualTransformation(keyboardType),
        placeholder = placeholder,
        singleLine = singleLine,
        keyboardActions = keyboardActions,
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(
                    onClick = resetField,
                    modifier = Modifier.absoluteOffset(x = 8.dp),
                    content = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "Clear",
                            tint = Color.Black
                        )
                    }
                )
            }
        }
    )
}

fun getVisualTransformation(keyboardType: KeyboardType): VisualTransformation {
    return if (keyboardType == KeyboardType.Password) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
}

@Preview("Light Input Field", showBackground =  true)
@Composable
fun LightTextField(){
    Column{
        Text(text = "Password (Required)", fontSize = 18.sp)
        KTextField(value = "hi there", onValueChanged = {}, resetField = {}, placeholder = {})
    }
}

