package org.steinko.plugin

/* ktlint-disable */
import org.gradle.api.Plugin
import org.gradle.api.Project


class ProjectVersionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val projectVersion = ProjectVersion(0, 1) 
            project.setProperty("version", projectVersion.toString()) 
    }
}
/* ktlint-enable */
