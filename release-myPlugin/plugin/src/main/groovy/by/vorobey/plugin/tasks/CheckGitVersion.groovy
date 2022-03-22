package by.vorobey.plugin.tasks

import by.vorobey.plugin.GitUtils
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

public class CheckGitVersion extends DefaultTask {

    @TaskAction
    def checkGit() {
        def gitVersion = GitUtils.getGitVersion();
        if (!gitVersion.contains("git")) {
            throw new GradleScriptException("No git", null);
        }else {
            println("current version = $gitVersion")
        }
    }
}