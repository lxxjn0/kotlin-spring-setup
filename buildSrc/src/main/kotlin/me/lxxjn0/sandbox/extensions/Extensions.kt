import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.KotlinBuildScript

fun KotlinBuildScript.configure(projects: Iterable<String>, configureAction: Action<in Project>): Iterable<Project> =
    configure(projects.map { project(it) }, configureAction)
