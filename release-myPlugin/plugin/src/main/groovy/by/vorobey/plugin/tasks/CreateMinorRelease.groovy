package by.vorobey.plugin.tasks

import by.vorobey.plugin.GitUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateMinorRelease extends DefaultTask{

    @TaskAction
    def createMinorRelease() {
        def tags = GitUtils.getGitTagsResult
        //println(tags)

        def tagsArray = tags.split("\n")
        tagsArray.toList().forEach {println it}

        if (tagsArray.size()==0){
            def currentVersion = "v1.0"
            println(currentVersion)
        }

        def currentVersion = tagsArray[tagsArray.size() -1]
        println("current version = $currentVersion")

        def currentVersionSplitted = currentVersion.split('\\.')
        println("splitted current version = $currentVersionSplitted")

        def currentMinor = Integer.parseInt(currentVersionSplitted[1]) + 1
        def newVersion = String.join(".", currentVersionSplitted[0], currentMinor as String)
        println("newVersion = $newVersion")

        GitUtils.createTag(newVersion)

        ("git push origin $newVersion").execute()
    }


}
