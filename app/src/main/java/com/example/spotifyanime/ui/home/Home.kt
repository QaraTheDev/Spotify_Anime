package com.example.spotifyanime.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.spotifyanime.R
import com.example.spotifyanime.navigation.ROUTE_HOME
import com.example.spotifyanime.navigation.ROUTE_LOGIN
import com.example.spotifyanime.ui.auth.AuthViewModel
import com.example.spotifyanime.ui.theme.AppTheme
import com.example.spotifyanime.ui.theme.md_theme_light_onSurface
import com.example.spotifyanime.ui.theme.spacing
import com.example.spotifyanime.ui.theme.spoti_green

@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_onSurface)
    ){
//
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(spacing.medium)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Text(
//                    text = stringResource(id = R.string.name),
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.3f),
//                    color = spoti_green
//                )
//
//                Text(
//                    text = viewModel?.currentUser?.displayName ?: "",
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.7f),
//                    color = Color.White
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Text(
//                    text = stringResource(id = R.string.email),
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.3f),
//                    color = spoti_green
//                )
//
//                Text(
//                    text = viewModel?.currentUser?.email ?: "",
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.7f),
//                    color = Color.White
//                )
//            }
//
//            Button(
//                onClick = {
//                          viewModel?.logout()
//                    navController.navigate(ROUTE_LOGIN){
//                        popUpTo(ROUTE_HOME) { inclusive = true }
//                    }
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = spoti_green),
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(top = spacing.extraLarge)
//            ) {
//                Text(text = stringResource(id = R.string.logout))
//            }
//        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}
