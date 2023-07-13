package com.ahuaman.customloginglasseffect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.customloginglasseffect.R
import com.ahuaman.customloginglasseffect.ui.theme.CustomLoginGlassEffectTheme
import com.ahuaman.customloginglasseffect.ui.theme.GreenLight
import com.ahuaman.customloginglasseffect.ui.theme.HoneyDew
import com.ahuaman.customloginglasseffect.ui.viewmodels.LoginEmailViewModel
import timber.log.Timber


@Composable
fun LoginEmailScreen(
    onClickContinue: (String) -> Unit,
    onRegisterUser: () -> Unit,
) {

    var email  by rememberSaveable { mutableStateOf("") }

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
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)) {
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
                text = "Hi!",
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
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
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
                        onClick = {
                            Timber.d("Email view: $email")
                            onClickContinue(email)
                        }
                    ){
                        Text(
                            text = "Continue",
                            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                            fontWeight = FontWeight.Bold,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        )
                    }

                    //or
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "or",
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            color = Color.White)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    //Facebook Button
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = HoneyDew,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(6.dp),
                        onClick = { /*TODO*/ }) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(20.dp),

                                painter = painterResource(id = R.drawable.ic_facebook),
                                contentDescription = stringResource(R.string.facebook)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                textAlign = TextAlign.Center,
                                fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                                modifier = Modifier.fillMaxWidth(1f),
                                text = "Continue with Facebook")
                        }

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //Google Button
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = HoneyDew,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(6.dp),
                        onClick = { /*TODO*/ }) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(20.dp),

                                painter = painterResource(id = R.drawable.ic_google),
                                contentDescription = stringResource(R.string.google)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(1f),
                                text = "Continue with Google")
                        }

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //Button Apple
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = HoneyDew,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(6.dp),
                        onClick = { /*TODO*/ }) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(20.dp),

                                painter = painterResource(id = R.drawable.ic_apple),
                                contentDescription = stringResource(R.string.apple)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(1f),
                                text = "Continue with Apple")
                        }



                    }


                }

                //Footer
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                    Row() {
                        Text(text = "Don't have an account?", color = Color.White)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Sign Up", color = GreenLight, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //Forgot Password
                    Text(text = "Forgot your password?", color = GreenLight, fontWeight = FontWeight.Bold)

                }
            }
        }

    }
}


@Preview
@Composable
fun LoginScreenPrev() {
    CustomLoginGlassEffectTheme() {
        LoginEmailScreen(
            onClickContinue = {
                Timber.d("Email view: $it")
            },
            onRegisterUser = {}
        )
    }
}