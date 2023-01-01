package com.example.mvvmcleanarchidemo1.data.repository.datasourceimpl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmcleanarchidemo1.data.api.FakeNetworkService
import com.example.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.example.mvvmcleanarchidemo1.data.repository.FakeDataGenerator
import com.google.common.truth.Truth.assertThat
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
    private lateinit var api: FakeNetworkService

    @Before
    fun setup() {
        api = FakeNetworkService(FakeDataGenerator.amiibo)
        datasource = RemoteDataSourceImpl(api)
    }

    @Test
    fun getGamesDataTest() = runBlocking {
        val res = datasource.getGamesData()
        assertThat(res).isNull()
    }
}