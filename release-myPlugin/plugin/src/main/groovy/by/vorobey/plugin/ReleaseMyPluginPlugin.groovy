/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package by.vorobey.plugin

import by.vorobey.plugin.tasks.CheckGitStatus
import by.vorobey.plugin.tasks.CheckGitVersion
import by.vorobey.plugin.tasks.CreateMajorRelease
import by.vorobey.plugin.tasks.CreateMinorRelease

import org.gradle.api.Project
import org.gradle.api.Plugin

/**
 * A simple 'hello world' plugin.
 */
class ReleaseMyPluginPlugin implements Plugin<Project> {
    void apply(Project project) {

        /*// Register a task
        project.tasks.register("greeting") {
            doLast {
                println("Hello from plugin 'by.vorobey.plugin.greeting'")
            }
        }*/

        project.task('hello!!!') {
            doLast {
                println 'Hello from the helloPlugin'
            }
        }

        project.tasks.register("checkGitVersion", CheckGitVersion) {
            setGroup("release")
        }

        project.tasks.register("checkGitStatus", CheckGitStatus) {
            setGroup("release")
        }

        project.tasks.register("createMinorRelease", CreateMinorRelease) {
            //dependsOn("checkGitStatus")
            setGroup("release")
        }

        project.tasks.register("createMajorRelease", CreateMajorRelease) {
            //dependsOn("checkGitStatus")
            setGroup("release")
        }

        /*project.tasks.register("releaseBranch") {
            setGroup("release")
            def currentBrunch = GitUtils.currentBranch
            if (currentBrunch.contains(GitUtils.MAJOR_BRANCH)){
                dependsOn("createMajorRelease")
            } else {
                dependsOn("createMinorRelease")
            }
        }*/

    }
}
