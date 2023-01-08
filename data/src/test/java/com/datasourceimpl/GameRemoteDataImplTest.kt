package com.datasourceimpl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameRemoteDataImplTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var datasource: RemoteDataSourceImpl

    private lateinit var api: GameFakeService

    @Before
    fun setup() {
        api = GameFakeService(FakeDataGenerator.amiibo)
        datasource = RemoteDataSourceImpl(api)
    }

    @Test
    fun getGamesDataTest() = runBlocking {
        val res = datasource.getGamesData()
        Truth.assertThat(res).isNull()
    }
}