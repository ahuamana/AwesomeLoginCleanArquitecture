package com.ahuaman.customloginglasseffect.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahuaman.customloginglasseffect.ui.screens.HomeScreen
import com.ahuaman.customloginglasseffect.ui.screens.LoginEmailScreen
import com.ahuaman.customloginglasseffect.ui.screens.LoginPasswordScreen
import com.ahuaman.customloginglasseffect.ui.screens.SignUpScreen
import com.ahuaman.customloginglasseffect.ui.viewmodels.LoginPasswordViewModel
import com.ahuaman.customloginglasseffect.ui.viewmodels.SignUpViewModel


@Composable
fun RootNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.LOGIN
    ){
        composable(route = Graph.LOGIN){
            signUpNav(navController = navController)
        }

        composable(route = Graph.HOME){
            HomeScreen()
        }
    }
}


@Composable
fun signUpNav(navController:NavHostController){
    NavHost(
        navController = navController,
        startDestination = LoginNavigationScreens.LoginWithEmailScreen.route,
        route = Graph.SIGNUP){

        composable(route = LoginNavigationScreens.LoginWithEmailScreen.route){
            LoginEmailScreen(
                onLoginUser = {
                    navController.navigate(LoginNavigationScreens.LoginWithPasswordScreen.route)
                },
                onRegisterUser = {
                    navController.navigate(LoginNavigationScreens.SignUpScreen.route)
                }
            )
        }

        composable(route = LoginNavigationScreens.SignUpScreen.route){

            val signUpViewModel = hiltViewModel<SignUpViewModel>()
            val emailState by signUpViewModel.email.collectAsStateWithLifecycle()

            SignUpScreen(
                onClickAgreeAndContinue = {
                    navController.navigate(Graph.HOME) {
                    popUpTo(Graph.LOGIN) { inclusive = true }
                }
                                          },
                emailReceived = emailState,
            )
        }

        composable(route = LoginNavigationScreens.LoginWithPasswordScreen.route){

            val loginPasswordViewModel = hiltViewModel<LoginPasswordViewModel>()
            val nameState by loginPasswordViewModel.name.collectAsStateWithLifecycle()
            val emailState by loginPasswordViewModel.email.collectAsStateWithLifecycle()

            LoginPasswordScreen(
                onLogin = {
                    navController.navigate(Graph.HOME) {
                        popUpTo(Graph.LOGIN) { inclusive = true }
                    }
                },
                onBack = {
                    navController.popBackStack()
                },
                onForgetPassword = {/*TODO*/},
                name = nameState,
                email = emailState,

            )
        }

    }
}


sealed class LoginNavigationScreens(val route:String){
    object LoginWithEmailScreen:LoginNavigationScreens("login_with_email_screen")
    object SignUpScreen:LoginNavigationScreens("signup_screen")
    object LoginWithPasswordScreen:LoginNavigationScreens("login_with_password_screen")
}


object Graph{
    const val ROOT = "root"
    const val HOME = "home"
    const val LOGIN = "login"
    const val SIGNUP = "signup"
}