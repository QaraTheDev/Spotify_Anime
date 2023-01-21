package com.example.spotifyanime

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.spotifyanime.data.repositories.BottomNavigationItem
import com.example.spotifyanime.navigation.*
import com.example.spotifyanime.ui.auth.AuthViewModel
import com.example.spotifyanime.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavHost(viewModel)

                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            modifier = Modifier,
                            items = listOf(
                                BottomNavigationItem(
                                    name = "Home",
                                    route = ROUTE_HOME,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavigationItem(
                                    name = "Library",
                                    route = ROUTE_LIBRARY,
                                    icon = Icons.Default.List
                                ),
                                BottomNavigationItem(
                                    name = "Profile",
                                    route = ROUTE_PROFILE,
                                    icon = Icons.Default.Person
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    AppNavHost(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}