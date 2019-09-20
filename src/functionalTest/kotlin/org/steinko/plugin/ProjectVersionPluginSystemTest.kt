package org.steinko.plugin

/* ktlint-disable import-ordering */
import java.io.File
import kotlin.test.assertTrue
import org.gradle.testkit.runner.GradleRunner
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
/* ktlint-enable import-ordering */

object ProjectVersionPluginSystemTest : Spek({
    Feature("Build Script System Test") {
        Scenario("Test Plugin") {

            val projectDir = File("build/functionalTest")
                    projectDir.mkdirs()
                    projectDir.resolve("settings.gradle").writeText("")
                    projectDir.resolve("build.gradle").writeText("""
                        plugins {
                         id('org.steinko.projectversion')
                        }
                    """)

                val runner = GradleRunner.create()
                runner.forwardOutput()
                runner.withPluginClasspath()
                runner.withArguments("properties")
                runner.withProjectDir(projectDir)

                val result = runner.build()

                Then("should contain Hello from plugin") {
                    assertTrue(result.output.contains("version: 0.1-SNAPSHOT"))
                    }
            }
        }
})
