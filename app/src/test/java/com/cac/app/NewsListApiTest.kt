package com.cac.app

import com.cac.app.api.NewsListApi
import com.cac.app.model.News
import com.cac.app.model.NewsResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.Paths

class NewsListApiTest {
    @Test
    fun `should return news list when query news api`() = runBlocking {
        //Given
        val mockWebServer = MockWebServer()
        enqueueResponse(mockWebServer, "src/test/resources/news_api_200_response.json")
        val newsApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url("/"))
            .build().create(NewsListApi::class.java)

        //When
        val newsResponse: NewsResponse = newsApi.queryNewsList()
        //Then
        val newsList: List<News> = newsResponse.data
        assertThat(newsList.size, `is`(1))
        val news = newsList[0]
        assertThat(news.title, `is`("王中王！德约一稳定江山，大满贯稳步追赶或成最终赢家"))
        assertThat(news.date, `is`("2019-07-15 10:50"))
        assertThat(
            news.thumbnail1,
            `is`("20190715105025_878317e185cc8776106d73d76be366c6_3_mwpm_03200403.jpg")
        )
        assertThat(
            news.thumbnail2,
            `is`("20190715105025_878317e185cc8776106d73d76be366c6_2_mwpm_03200403.jpg")
        )
        assertThat(
            news.thumbnail3,
            `is`("20190715105025_878317e185cc8776106d73d76be366c6_1_mwpm_03200403.jpg")
        )
    }

    private fun enqueueResponse(
        mockWebServer: MockWebServer,
        jsonPath: String
    ) {
        val response = MockResponse()
        response.setBody(
            Paths.get(jsonPath).toFile().readText()
        )
        mockWebServer.enqueue(response)
    }
}
