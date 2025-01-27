package com.example.cardinfoapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinfoapp.domain.usecase.GetSearchHistoryUseCase
import com.example.cardinfoapp.presentation.model.SearchHistoryViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchHistoryViewModel @Inject constructor(
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SearchHistoryViewState())
    val viewState: StateFlow<SearchHistoryViewState> = _viewState

    init {
        getCards()
    }

    private fun getCards() {
        viewModelScope.launch() {
            _viewState.value = _viewState.value.copy(isInProgress = true)
            _viewState.value = _viewState.value.copy(result = getSearchHistoryUseCase.getSearchHistory())
            _viewState.value = _viewState.value.copy(isInProgress = false)
        }
    }
}