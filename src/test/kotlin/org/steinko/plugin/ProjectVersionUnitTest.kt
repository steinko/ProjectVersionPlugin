package org.steinko.plugin

/* ktlint-disable import-ordering */
import kotlin.test.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
/* ktlint-enable import-ordering */

object ProjectVersionUnitTest : Spek({
    Feature("ProjectVersion Unit Test") {

        Scenario("project version with two parameter") {

            val projectversion = ProjectVersion(0, 1)

                Then("project should contain a version") {
                    assertEquals(projectversion.toString(), "0.1-SNAPSHOT")
                }
        }

        Scenario("relase project version") {
            val projectversion = ProjectVersion(0, 2, false)

            Then("project should contain a version") {
                    assertEquals(projectversion.toString(), "0.2")
                }
        }

        Scenario("snapshot project version") {
            val projectversion = ProjectVersion(0, 3, false)

            Then("project should contain a version") {
                    assertEquals(projectversion.toString(), "0.3-SNAPSHOT")
                }
        }
    }
})
