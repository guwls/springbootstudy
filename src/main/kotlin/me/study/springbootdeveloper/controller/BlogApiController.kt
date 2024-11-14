package me.study.springbootdeveloper.controller

import me.study.springbootdeveloper.domain.Article
import me.study.springbootdeveloper.dto.AddArticleRequest
import me.study.springbootdeveloper.repository.BlogRepository
import me.study.springbootdeveloper.service.BlogService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BlogApiController(
    private val blogRepository: BlogRepository,
    private val blogService: BlogService
) {
    @PostMapping("/api/articles")
    fun addArticle(@RequestBody request: AddArticleRequest): ResponseEntity<Article> {
        val savedArticle = blogService.save(request)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedArticle)
    }

}