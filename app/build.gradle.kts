plugins {
    id("application")
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    // 사용 중인 Java 버전에 맞게 설정합니다.
    // set 메서드를 사용하여 값을 할당합니다.
    applicationDefaultJvmArgs = listOf("-Dfile.encoding=UTF-8")
    mainClass.set("com.example.MainKt")

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
