package com.ahuaman.customloginglasseffect.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahuaman.customloginglasseffect.R
import com.ahuaman.customloginglasseffect.ui.theme.CustomLoginGlassEffectTheme
import com.ahuaman.customloginglasseffect.ui.theme.GreenLight

@Composable
fun PasswordTextField(
    text: String,
    modifier: Modifier = Modifier,
    labelText: String = "",
    placeholderText: String = "",
    hasError: Boolean = false,
    onTextChanged: (text: String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    val icon = if (passwordVisibility) R.drawable.ic_visibility_off else  R.drawable.ic_visibility

    //if textfiel has focus add a border

    var hasFocus by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier
            .onFocusChanged {
                 hasFocus = it.isFocused
            }
            .border(
            width = 1.dp,
            color = if(hasFocus) GreenLight else Color.Transparent,
            shape = RoundedCornerShape(8.dp)
        ),
        shape = RoundedCornerShape(8.dp),
        value = text,
        onValueChange = { text ->
            onTextChanged(text)
        },
        placeholder = {
            Text(text = placeholderText)
        },
        label = {
            Text(text = labelText)
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
                focusManager.clearFocus()
            }) {
                Text(text = if(passwordVisibility) "Hide" else "View")
                //Icon(painter = painterResource(id = icon), contentDescription = null)
            }
        },
        visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        //To Remove the underline
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
    )

}

@Preview
@Composable
fun PasswordTextFieldPreview() {

    CustomLoginGlassEffectTheme() {
        var password by rememberSaveable { mutableStateOf("") }

        PasswordTextField(
            text = password,
            onTextChanged = {
                password = it
            },
            labelText = "Password",
            hasError = false,
            placeholderText = "Enter your password",

            )
    }



}