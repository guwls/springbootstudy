package me.study.springbootdeveloper.service

import me.study.springbootdeveloper.domain.Article
import me.study.springbootdeveloper.dto.AddArticleRequest
import me.study.springbootdeveloper.repository.BlogRepository
import org.springframework.stereotype.Service

@Service
class BlogService(
    val blogRepository: BlogRepository
) {
    fun save(request: AddArticleRequest): Article {
        return blogRepository.save(request.toEntity())
    }
}