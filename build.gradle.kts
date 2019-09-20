plugins {
    `java-gradle-plugin`
        id("org.jetbrains.kotlin.jvm") version "1.3.41"
        id("org.jlleitschuh.gradle.ktlint") version "8.2.0"
}

repositories {
    jcenter()
    mavenCentral()
}

val spek2Version = "2.0.7"
dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek2Version")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

gradlePlugin {

    val projectversion by plugins.creating {
        id = "org.steinko.projectversion"
        implementationClass = "org.steinko.plugin.ProjectVersionPlugin"
    }
}

// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

gradlePlugin.testSourceSets(functionalTestSourceSet)
configurations.getByName("functionalTestImplementation").extendsFrom(configurations.getByName("testImplementation"))

// Add a task to run the functional tests
val functionalTest by tasks.creating(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
}

val check by tasks.getting(Task::class) {
    // Run the functional tests as part of `check`
    dependsOn(functionalTest)
}
