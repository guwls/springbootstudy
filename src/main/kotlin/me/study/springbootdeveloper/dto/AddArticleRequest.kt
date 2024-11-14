package me.study.springbootdeveloper.dto

import me.study.springbootdeveloper.domain.Article

data class AddArticleRequest(
    var title: String = "",
    var content: String = ""
){
    fun toEntity(): Article {
        return Article(
            title = this.title,
            content = this.content
        )
    }
}
