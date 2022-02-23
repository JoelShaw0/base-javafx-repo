package org.bibletranslationtools.app.main

import javafx.stage.Stage
import org.bibletranslationtools.app.main.entity.Contributor
import org.bibletranslationtools.app.main.persistence.ContributorRepository
import org.bibletranslationtools.app.main.ui.RootView
import tornadofx.*

class DemoApp: App(RootView::class) {
    override fun start(stage: Stage) {
        super.start(stage)

        stage.minWidth = 500.0
        stage.width = 800.0
        stage.minHeight = 500.0
    }
}

fun main(args: Array<String>) {
    launch<DemoApp>(args)
}
