package com.example.meet9.repository

import com.example.meet9.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
    fun getAllMhs(): Flow<List<Mahasiswa>>
    fun getMhs (nim: String): Flow<Mahasiswa>
}