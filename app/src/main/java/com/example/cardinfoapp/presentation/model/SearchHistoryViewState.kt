package com.example.cardinfoapp.presentation.model

import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.EmptyResult
import com.example.cardinfoapp.domain.util.Result

data class SearchHistoryViewState(
    val result: Result<List<Card>> = EmptyResult(),
    val isInProgress: Boolean = false
)