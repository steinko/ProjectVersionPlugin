package org.steinko.plugin

/* ktlint-disable import-ordering */
import org.gradle.api.Plugin
import org.gradle.api.Project
/* ktlint-enable import-ordering */

class ProjectVersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Register a task
        project.tasks.register("greeting") { task ->
            task.doLast {
                println("Hello from plugin 'org.steinko.plugin.greeting'")
            }
        }
    }
}
