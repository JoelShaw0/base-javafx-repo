package org.bibletranslationtools.app.main.ui

import tornadofx.*

class RootView : View() {
    init {
        importStylesheet(javaClass.getResource("/css/my.css").toExternalForm())
        workspace.header.removeFromParent()
    }

    override val root = vbox {
        label("hello")
    }
}
