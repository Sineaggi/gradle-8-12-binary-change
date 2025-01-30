package com.example.helloworld

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloWorldPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("helloworld") {
            doLast {
                logger.quiet("hello, world!")
            }
        }
    }
}
