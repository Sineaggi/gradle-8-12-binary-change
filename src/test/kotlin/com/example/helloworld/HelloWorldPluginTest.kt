package com.example.helloworld

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path
import kotlin.io.path.writeText

class HelloWorldPluginTest {
    @Test
    fun `plugin runs on 8 12`(@TempDir tempDir: Path) {
        tempDir.resolve("build.gradle").writeText("""
            plugins {
                id 'com.example.helloworld'
            }
        """.trimIndent())
        GradleRunner.create()
            .withProjectDir(tempDir.toFile())
            .withPluginClasspath()
            .withGradleVersion("8.12")
            .withArguments("helloworld")
            .build()
    }

    @Test
    fun `plugin fails on 8 11`(@TempDir tempDir: Path) {
        tempDir.resolve("build.gradle").writeText("""
            plugins {
                id 'com.example.helloworld'
            }
        """.trimIndent())
        GradleRunner.create()
            .withProjectDir(tempDir.toFile())
            .withPluginClasspath()
            .withGradleVersion("8.11")
            .withArguments("helloworld")
            .buildAndFail()
    }
}
