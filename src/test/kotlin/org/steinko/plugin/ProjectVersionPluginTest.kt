package org.steinko.plugin

/* ktlint-disable import-ordering */
import kotlin.test.assertNotNull
import kotlin.test.Test
import org.gradle.testfixtures.ProjectBuilder
/* ktlint-enable import-ordering */

class ProjectVersionPluginTest {
    @Test fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("org.steinko.projectversion")

        // Verify the result
        assertNotNull(project.tasks.findByName("greeting"))
    }
}
