package me.study.springbootdeveloper.controller

import com.fasterxml.jackson.databind.ObjectMapper
import me.study.springbootdeveloper.domain.Article
import me.study.springbootdeveloper.dto.AddArticleRequest
import me.study.springbootdeveloper.repository.BlogRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
    private val context: WebApplicationContext,
    private val blogRepository: BlogRepository
) {
    @BeforeEach
    fun setUp() {
        blogRepository.deleteAll()
    }

    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    @Throws(Exception::class)
    fun addArticle() {
        val url: String = "/api/articles"
        val title: String = "title"
        val content: String = "content"
        val userRequest: AddArticleRequest = AddArticleRequest(title, content)

        val requestBody: String = objectMapper.writeValueAsString(userRequest)

        val result: ResultActions = mockMvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(requestBody))

        result.andExpect(status().isCreated)

        val articles: List<Article> = blogRepository.findAll()

        assertThat(articles.size).isEqualTo(1)
        assertThat(articles.get(0).title).isEqualTo(title)
        assertThat(articles.get(0).content).isEqualTo(content)
    }
}
