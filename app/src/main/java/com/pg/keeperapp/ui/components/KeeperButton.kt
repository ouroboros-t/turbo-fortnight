package com.pg.keeperapp.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pg.keeperapp.ui.theme.blue300
import com.pg.keeperapp.ui.theme.peach
import com.pg.keeperapp.ui.theme.red200

@Composable
fun KPeachButton(modifier: Modifier = Modifier,
                enabled: Boolean = true,
                onClick: () -> Unit,
                content: @Composable RowScope.() -> Unit){
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = peach, contentColor = Color.Black),
        shape = RoundedCornerShape(50),
        modifier = modifier.size(120.dp, 60.dp),
        content = content
    )
}

@Composable
fun KBlueButton(modifier: Modifier = Modifier,
                 enabled: Boolean = true,
                 onClick: () -> Unit,
                 content: @Composable RowScope.() -> Unit){
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = blue300, contentColor = Color.Black),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(50),
        modifier = modifier.size(120.dp, 60.dp),
        content = content
    )
}

@Composable
fun KPinkButton(modifier: Modifier = Modifier,
                 enabled: Boolean = true,
                 onClick: () -> Unit,
                 content: @Composable RowScope.() -> Unit){
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = red200, contentColor = Color.Black),
        shape = RoundedCornerShape(50),
        modifier = modifier.size(120.dp, 60.dp),
        content = content
    )
}



//todo: button colors won't display properly..
@Preview
@Composable
fun ButtonPreviewPeach(){
    KPeachButton(onClick = {}, enabled = false){Text(text="Ello thar")}
}

@Preview
@Composable
fun ButtonPreviewBlue(){
    KBlueButton(onClick = {}, enabled = false){Text(text="Ello thar")}
}

@Preview
@Composable
fun ButtonPreviewPink(){
    KPinkButton(onClick = {}, enabled = false){Text(text="Ello thar")}
}


