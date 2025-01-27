package com.example.cardinfoapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinfoapp.domain.usecase.SearchCardByNumberUseCase
import com.example.cardinfoapp.presentation.util.EventHandler
import com.example.cardinfoapp.presentation.util.MainEvent
import com.example.cardinfoapp.presentation.model.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchCardByNumberUseCase: SearchCardByNumberUseCase
) : ViewModel(), EventHandler<MainEvent> {

    private val _viewState = MutableStateFlow(MainViewState())
    val viewState: StateFlow<MainViewState> = _viewState

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            is MainEvent.SearchClicked -> searchCardByNumber()
            is MainEvent.CardNumberChanged -> cardNumberChanged(event.value)
        }
    }

    private fun searchCardByNumber() {
        viewModelScope.launch {
            _viewState.value = _viewState.value.copy(isInProgress = true)
            val result = searchCardByNumberUseCase.getCardInfo(_viewState.value.searchValue.toLong())
            _viewState.value = _viewState.value.copy(result = result)
            _viewState.value = _viewState.value.copy(isInProgress = false)
        }
    }

    private fun cardNumberChanged(value: String) {
        _viewState.value = _viewState.value.copy(searchValue = value)
    }
}