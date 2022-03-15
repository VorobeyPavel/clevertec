package me.msvasilets.plugin.tasks

import me.msvasilets.plugin.GitUtils
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckGitStatus extends DefaultTask {

    @TaskAction
    def checkStatus() {
        def statusResult = GitUtils.gitStatusResult
        if (statusResult.contains("new file") || statusResult.contains("modified")) {
            throw new GradleScriptException("Uncommitted changes was found", null)
        }
    }

}
