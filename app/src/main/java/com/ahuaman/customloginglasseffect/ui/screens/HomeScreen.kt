package com.ahuaman.customloginglasseffect.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahuaman.customloginglasseffect.R
import com.ahuaman.customloginglasseffect.ui.theme.GreenLight
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun HomeScreen() {
    val lottieLoading by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_working))

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {

        Box() {
            LottieAnimation(
                composition = lottieLoading,
                modifier = Modifier.
                fillMaxWidth(1f),
                iterations = LottieConstants.IterateForever)

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
            ) {

                Text(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    text = "Empowering \nconnections \nfor girls.",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = FontFamily(Font(R.font.googlesans_bold)),
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Get Started", color = Color.White)
                }
            }

        }

    }
}


@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}


