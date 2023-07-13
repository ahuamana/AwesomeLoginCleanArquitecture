package com.ahuaman.customloginglasseffect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.customloginglasseffect.R
import com.ahuaman.customloginglasseffect.ui.composables.PasswordTextField
import com.ahuaman.customloginglasseffect.ui.theme.CustomLoginGlassEffectTheme
import com.ahuaman.customloginglasseffect.ui.theme.GreenLight
import com.ahuaman.domain.RegisterForm
import timber.log.Timber


@Composable
fun SignUpScreen(
    onClickAgreeAndContinue: (RegisterForm) -> Unit,
    emailReceived: String,
    onBack: () -> Unit
) {
    var name by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val termsOfServiceText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White)) {
            append("By selecting Agree and continue below,\nI Agree to ")
        }
        withStyle(style = SpanStyle(color = GreenLight)) {
            append("the Terms of Service and Privacy Policy.")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        //Background
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = stringResource(R.string.background),
            contentScale = ContentScale.Crop

        )

        //Surface black
        Surface(modifier = Modifier
            .fillMaxSize(),
            color = Color.Black.copy(alpha = 0.5f)){}

        //Top

        IconButton(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            onClick = { onBack()}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back_ios),
                contentDescription = stringResource(R.string.back),
                tint = Color.White
            )
        }

        //Container for the login
        //Body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .verticalScroll(rememberScrollState()),
        ) {

            Spacer(modifier = Modifier.height(200.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Sign up",
                color = Color.White,
                fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black.copy(alpha = 0.5f),
                )
            ) {

                val textFieldTextStyle = TextStyle(
                    fontSize = 16.sp // Adjust the desired text size here
                )
                Column(modifier = Modifier.padding(20.dp)) {
                    //Email

                    //Looks like dont have an account? Sign up
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Looks like dont have an account. \nLet's create a new account for",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = emailReceived,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                    }

                    TextField(
                        textStyle = textFieldTextStyle,
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        shape = RoundedCornerShape(8.dp),
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = "Name") },
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    PasswordTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        text = password,
                        onTextChanged = {
                            password = it
                        },
                        labelText = "Password",
                        hasError = false,
                        placeholderText = "Enter your password",
                    )

                    Spacer(modifier = Modifier.height(10.dp))



                    Text(
                        color = Color.White,
                        fontSize = 12.sp,
                        text = termsOfServiceText,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    //Button Continue
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GreenLight,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(6.dp),
                        onClick = { onClickAgreeAndContinue(
                            RegisterForm(
                                name = name,
                                email = emailReceived,
                                password = password
                            )
                        ) }) {
                        Text(
                            text = "Agree and continue",
                            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                            fontWeight = FontWeight.Bold,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        )
                    }
                }

            }
        }

    }
}


@Preview
@Composable
fun SignUpScreenPrev() {
    CustomLoginGlassEffectTheme {

        SignUpScreen(
            emailReceived = "asd@gmail.com",
            onClickAgreeAndContinue = {},
            onBack = {
                println("onBack")
                Timber.e("onBack")
            }
        )
    }
}