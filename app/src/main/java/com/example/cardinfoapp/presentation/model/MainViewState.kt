package com.example.cardinfoapp.presentation.model

import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.util.Result

data class MainViewState(
    val searchValue: String = "",
    val result: Result<Card>? = null,
    val errorMessage: String = "",
    val isInProgress: Boolean = false
)