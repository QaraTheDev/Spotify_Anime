package com.example.spotifyanime.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifyanime.ui.auth.AuthViewModel
import com.example.spotifyanime.ui.auth.LoginScreen
import com.example.spotifyanime.ui.auth.SignUpScreen
import com.example.spotifyanime.ui.home.HomeScreen

@Composable
fun AppNavHost(
    viewModel : AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignUpScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
    }
}