package me.study.springbootdeveloper.repository

import me.study.springbootdeveloper.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface BlogRepository: JpaRepository<Article, Long>