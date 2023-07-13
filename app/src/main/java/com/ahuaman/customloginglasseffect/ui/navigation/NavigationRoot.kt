package com.ahuaman.customloginglasseffect.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.ahuaman.customloginglasseffect.ui.screens.HomeScreen
import com.ahuaman.customloginglasseffect.ui.screens.LoginEmailScreen
import com.ahuaman.customloginglasseffect.ui.screens.LoginPasswordScreen
import com.ahuaman.customloginglasseffect.ui.screens.SignUpScreen
import com.ahuaman.customloginglasseffect.ui.viewmodels.LoginEmailViewModel
import com.ahuaman.customloginglasseffect.ui.viewmodels.LoginPasswordViewModel
import com.ahuaman.customloginglasseffect.ui.viewmodels.SignUpViewModel
import kotlinx.coroutines.flow.collect
import timber.log.Timber


@Composable
fun RootNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.LOGIN
    ){
        signUpNav(navController = navController)

        composable(route = Graph.HOME){
            HomeScreen()
        }
    }
}


fun NavGraphBuilder.signUpNav(navController:NavHostController){
    navigation(
        startDestination = LoginNavigationScreens.LoginWithEmailScreen.route,
        route = Graph.LOGIN){

        composable(route = LoginNavigationScreens.LoginWithEmailScreen.route){

            val loginEmailViewModel = hiltViewModel<LoginEmailViewModel>()
            val uiState by loginEmailViewModel.uiState.collectAsState()

            LaunchedEffect(key1 = uiState){
                when(uiState.isLoginSuccessful){
                    true -> {
                        navController.navigate(
                            //sending email
                            LoginNavigationScreens.LoginWithPasswordScreen.route + "/" + uiState.infoUser?.id
                        )
                        loginEmailViewModel.resetState()
                    }
                    false -> {
                        navController.navigate(LoginNavigationScreens.SignUpScreen.route + "/" + uiState.infoUser?.email)
                        loginEmailViewModel.resetState()
                    }
                    else -> {
                        Timber.d("LoginWithEmailScreen: isLoginSuccessful is null")
                    }
                }
            }

            LoginEmailScreen(
                onClickContinue = {
                    //uiState = LoginEmailViewModel.UiStateLogin(isLoginSuccessful = true)
                    loginEmailViewModel.login(it)
                },
                onRegisterUser = {
                    //TODO: SignUp
                }
            )
        }

        composable(
            route = LoginNavigationScreens.SignUpScreen.route + "/{email}",
        ){

            val signUpViewModel = hiltViewModel<SignUpViewModel>()
            val emailState by signUpViewModel.email.collectAsStateWithLifecycle()
            val signUpState by signUpViewModel.signUpState.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = signUpState){
                if(signUpState.isRegisterSuccessful){
                    navController.navigate(Graph.HOME) {
                        popUpTo(Graph.LOGIN) { inclusive = true }
                    }
                }
            }

            SignUpScreen(
                onClickAgreeAndContinue = {
                   signUpViewModel.registerUser(
                          email = it.email,
                          name = it.name,
                          password = it.password) },
                emailReceived = emailState,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = LoginNavigationScreens.LoginWithPasswordScreen.route + "/{id}",
        ){

            val loginPasswordViewModel = hiltViewModel<LoginPasswordViewModel>()
            val nameState by loginPasswordViewModel.name.collectAsStateWithLifecycle()
            val emailState by loginPasswordViewModel.email.collectAsStateWithLifecycle()
            val imageState by loginPasswordViewModel.image.collectAsStateWithLifecycle()

            val isLoginSuccessful by loginPasswordViewModel.isLoginSuccessful.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = isLoginSuccessful){
                if(isLoginSuccessful){
                    navController.navigate(Graph.HOME) {
                        popUpTo(Graph.LOGIN) { inclusive = true }
                    }
                }
            }

            LoginPasswordScreen(
                onLogin = {
                    loginPasswordViewModel.login(
                        email = emailState,
                        password = it
                    )
                },
                onBack = {
                    navController.popBackStack()
                },
                onForgetPassword = {/*TODO*/},
                name = nameState,
                email = emailState,
                image = imageState
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
}