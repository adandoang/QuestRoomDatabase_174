package com.example.meet9.ui.viewmodel

import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.meet9.repository.LocalRepositoryMhs
import com.example.meet9.repository.RepositoryMhs
import com.example.meet9.ui.navigation.DestinasiDetail
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

data class DetailUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MahasiswaEvent()

    val  isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MahasiswaEvent()
}


class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
) : ViewModel() {
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    val detailUiState: StateFlow<DetailUiState> = repositoryMhs.getMhs(_nim)
        .filterNotNull()
        .map {
            DetailUiState(
                detailUiEvent =
            )
        }
}