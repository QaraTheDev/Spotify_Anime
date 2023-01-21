package com.example.spotifyanime.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.spotifyanime.ui.home.LibraryScreen
import com.example.spotifyanime.ui.home.ProfileScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    viewModel: AuthViewModel?,
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
        composable(ROUTE_LIBRARY) {
            LibraryScreen(navController)
        }
        composable(ROUTE_PROFILE) {
            ProfileScreen(navController)
        }
    }

}