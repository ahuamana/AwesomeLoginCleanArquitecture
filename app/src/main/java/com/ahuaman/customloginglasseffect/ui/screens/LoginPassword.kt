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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.ahuaman.customloginglasseffect.R
import com.ahuaman.customloginglasseffect.ui.composables.PasswordTextField
import com.ahuaman.customloginglasseffect.ui.theme.CustomLoginGlassEffectTheme
import com.ahuaman.customloginglasseffect.ui.theme.GreenLight
import timber.log.Timber


@Composable
fun LoginPasswordScreen(
    onLogin: (String) -> Unit,
    onBack: () -> Unit,
    onForgetPassword: () -> Unit,
    name: String,
    email: String,
    image: String
) {

    val painter = rememberAsyncImagePainter(model = image)

    var password by rememberSaveable { mutableStateOf("") }

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
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back_ios),
                contentDescription = stringResource(R.string.back),
                modifier = Modifier.clickable {
                    onBack()
                }
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
                text = "Log in",
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

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                                .clip(RoundedCornerShape(35.dp)),
                            contentScale = ContentScale.Crop,
                            painter = painter,
                            contentDescription = null)

                        Column(
                            modifier = Modifier.padding(start = 20.dp),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = name,
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold)
                            Text(
                                modifier = Modifier.fillMaxHeight(),
                                text = email,
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    //Email
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
                        onClick = { onLogin(
                            password
                        ) }) {
                        Text(
                            text = "Continue",
                            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                            fontWeight = FontWeight.Bold,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        )
                    }
                }

                //Footer
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                ) {
                    //Forgot Password
                    Text(text = "Forgot your password?", color = GreenLight, fontWeight = FontWeight.Bold)

                }
            }
        }

    }
}


@Preview
@Composable
fun LoginPasswordScreenPrev() {
    CustomLoginGlassEffectTheme() {
        LoginPasswordScreen(
            onLogin = {},
            onBack = {
                     Timber.e("onBack")
            },
            onForgetPassword = {},
            name = "Ahuaman",
            email = "asd@gmail.com",
            image = "https://cdn.shopify.com/s/files/1/0070/7032/files/editing-image-sizes.png?format=webp&v=1581621967&width=1024"
        )
    }
}