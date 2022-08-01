rootProject.name = "alfred-api"

plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.0.18"
}

gitHooks {
    commitMsg { conventionalCommits() }
    createHooks()
}
