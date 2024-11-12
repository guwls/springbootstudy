package me.study.springbootdeveloper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
open class SpringBootDeveloperApplication

fun main(args: Array<String>) {
    runApplication<SpringBootDeveloperApplication>(*args)
}