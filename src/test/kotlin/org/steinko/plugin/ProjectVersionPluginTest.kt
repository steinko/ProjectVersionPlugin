package org.steinko.plugin

/* ktlint-disable import-ordering */
import kotlin.test.assertNotNull
import org.gradle.testfixtures.ProjectBuilder
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
/* ktlint-enable import-ordering */

object ProjectVersionPluginTest : Spek({
    Feature("ProjectVersionPluging Unit Test") {
        Scenario("should unit test ProjectVersionPlugin") {

            val project = ProjectBuilder.builder().build()

                When("applying pluggin") {
                    project.plugins.apply("org.steinko.projectversion")
                }

                Then("project should contain a greeting tasks") {
                    assertNotNull(project.tasks.findByName("greeting"))
                }
        }
    }
})
