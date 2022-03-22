package by.vorobey.plugin.tasks


import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class ReleaseTask extends DefaultTask {

   /* @TaskAction
    def release() {

        if (GitUtils.currentBranch == 'master') {
            new CreateMajorRelease().createMajorRelease()
        } else {
            new CreateMinorRelease().createMinorRelease()
        }

    }*/
}
