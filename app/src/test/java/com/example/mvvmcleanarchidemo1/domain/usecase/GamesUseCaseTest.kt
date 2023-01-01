package com.example.mvvmcleanarchidemo1.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmcleanarchidemo1.data.api.FakeNetworkService
import com.example.data.repository.GamesRepoImpl
import com.example.data.repository.datasourceimpl.RemoteDataSourceImpl


import com.example.domain.repository.GamesRepo
import com.example.domain.usecase.GetGamesUseCase
import com.example.mvvmcleanarchidemo1.data.repository.FakeDataGenerator
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GamesUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var accountRepository: GamesRepo
    private lateinit var subject: GetGamesUseCase
    private lateinit var api: FakeNetworkService

    @Before
    fun setup() {
        api = FakeNetworkService(FakeDataGenerator.amiibo)
        accountRepository = GamesRepoImpl(RemoteDataSourceImpl(api))
        subject = GetGamesUseCase(accountRepository)
    }

    @Test
    fun GamesUseCaseTest() = runBlocking {
        val res = subject.execute()
        assertThat(res).isNotNull()
    }
}