package com.example.cardinfoapp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfoapp.presentation.navigation.NavigationTree
import com.example.cardinfoapp.presentation.viewmodels.MainViewModel
import com.example.cardinfoapp.presentation.viewmodels.SearchHistoryViewModel

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Main.name) {

        composable(NavigationTree.Main.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(mainViewModel, navController)
        }

        composable(NavigationTree.SearchHistory.name) {
            val searchHistoryViewModel = hiltViewModel<SearchHistoryViewModel>()
            SearchHistoryScreen(searchHistoryViewModel, navController)
        }
    }
}