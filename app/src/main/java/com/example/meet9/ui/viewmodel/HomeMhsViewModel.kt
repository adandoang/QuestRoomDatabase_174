package com.example.meet9.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meet9.data.entity.Mahasiswa
import com.example.meet9.repository.RepositoryMhs
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState (
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)

class HomeMhsViewModel (
    private val repositoryMhs: RepositoryMhs
) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> = repositoryMhs.getAllMhs()
}