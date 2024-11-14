package me.study.springbootdeveloper.domain

import jakarta.persistence.*

@Entity
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 증가
    @Column(name = "id", updatable = false)
    val id: Long? = null,

    @Column(name = "title", nullable = false) // title 필드와 매핑
    var title: String,

    @Column(name = "content", nullable = false) // content 필드와 매핑
    var content: String
) {
    // JPA 기본 생성자
    protected constructor() : this(title = "", content = "")
}
