package com.example.cardinfoapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cardinfoapp.R
import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.EmptyResult
import com.example.cardinfoapp.domain.util.ErrorResult
import com.example.cardinfoapp.domain.util.SuccessResult
import com.example.cardinfoapp.presentation.component.CardInfoView
import com.example.cardinfoapp.presentation.viewmodels.SearchHistoryViewModel

@Composable
fun SearchHistoryScreen(
    searchHistoryViewModel: SearchHistoryViewModel,
    navController: NavController
) {
    val viewState = searchHistoryViewModel.viewState.collectAsState()

    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            if(viewState.value.isInProgress) {
                CircularProgressIndicator(
                    strokeWidth = 3.dp,
                )
            } else {
                when(viewState.value.result) {
                    is EmptyResult -> {
                        Text(stringResource(R.string.empty_history))
                    }
                    is SuccessResult -> {
                        LazyColumn(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            if(viewState.value.result is SuccessResult){
                                items((viewState.value.result as SuccessResult<List<Card>>).data) { card ->
                                    CardInfoView(
                                        modifier = Modifier
                                            .padding(4.dp),
                                        card = card
                                    )
                                }
                            }
                        }
                    }
                    is ErrorResult -> {
                        Text(stringResource(R.string.error_message))
                    }
                }
            }
        }
        BackButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navController.popBackStack()
            }
        )
    }
}

@Composable
private fun BackButton (
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(stringResource(R.string.back))
    }
}
