package com.example.mvvmcleanarchidemo1.data.api

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GamesApiServiceTest {
    private lateinit var service: GamesAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GamesAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }

    @Test
    fun getGamesDataExpected(){
        runBlocking {
            enqueueMockResponse("gamesResponse.json")
            val responseBody = service.getGamesData().body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            Truth.assertThat(request.path).isEqualTo("/api/amiibo/")
        }
    }




    @After
    fun tearDown() {
        server.shutdown()
    }
}