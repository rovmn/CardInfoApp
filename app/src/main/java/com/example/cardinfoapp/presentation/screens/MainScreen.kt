package com.example.cardinfoapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cardinfoapp.R
import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.EmptyResult
import com.example.cardinfoapp.domain.util.ErrorResult
import com.example.cardinfoapp.domain.util.SuccessResult
import com.example.cardinfoapp.presentation.component.CardInfoView
import com.example.cardinfoapp.presentation.util.MainEvent
import com.example.cardinfoapp.presentation.navigation.NavigationTree
import com.example.cardinfoapp.presentation.viewmodels.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    navController: NavController,
) {
    val viewState = mainViewModel.viewState.collectAsState()

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardBinTextField(
                value = viewState.value.searchValue,
                placeholder = stringResource(R.string.search_placeholder),
                enabled = !viewState.value.isInProgress,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                onValueChange = {
                    mainViewModel.obtainEvent(MainEvent.CardNumberChanged(it))
                }
            )
            SearchButton(
                enabled = !viewState.value.isInProgress,
                modifier = Modifier
                    .padding(end = 4.dp),
                onClick = {
                    mainViewModel.obtainEvent(MainEvent.SearchClicked)
                }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            if(viewState.value.isInProgress){
                CircularProgressIndicator(
                    strokeWidth = 3.dp
                )
            } else {
                when(viewState.value.result) {
                    is EmptyResult -> {
                        Text(stringResource(R.string.card_not_found))
                    }
                    is SuccessResult -> {
                        CardInfoView(
                            card = (viewState.value.result as SuccessResult<Card>).data,
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                        )
                    }
                    is ErrorResult -> {
                        Text(stringResource(R.string.error_message))
                    }
                    else -> {}
                }
            }
        }
        SearchHistoryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            onClick = {
                navController.navigate(NavigationTree.SearchHistory.name)
            }
        )
    }
}

@Composable
private fun CardBinTextField (
    value: String,
    placeholder: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        placeholder = {
            Text(placeholder)
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        enabled = enabled,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(10.dp),
    )
}

@Composable
private fun SearchButton (
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
    ) {
        Icon(Icons.Default.Search, contentDescription = null)
    }
}

@Composable
private fun SearchHistoryButton (
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(stringResource(R.string.search_history))
    }
}