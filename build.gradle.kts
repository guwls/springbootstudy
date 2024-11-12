plugins {
    kotlin("jvm") version "1.9.10"
    id ("org.springframework.boot") version "3.2.0" //스프링부트 플러그인
    id ("io.spring.dependency-management") version "1.1.0" //스프링의 의존성을 자동으로 관리하는 플러그인
}

allprojects {
    group = property("app.group").toString()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") //웹 관련 기능을 제공
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.jetbrains.kotlin:kotlin-test") //테스트 기능을 제공
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:3.24.2") //AssertJ 기능을 제공
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}