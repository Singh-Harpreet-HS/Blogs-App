package app.book.management.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.book.management.mainScreen.BlogMainScreen
//import app.book.management.mainScreen.WebViewScreen
//
//@Composable
//fun AppNavigation() {
//
//    val navController= rememberNavController()
//
//    NavHost(navController = navController, startDestination = "cardList") {
//        composable("cardList") {
//            BlogMainScreen(navController = navController)
//        }
//        composable("webview/{url}") { backStackEntry ->
//            val url = backStackEntry.arguments?.getString("url")
//            WebViewScreen(navController = navController, url = url.orEmpty())
//        }
//    }
//}