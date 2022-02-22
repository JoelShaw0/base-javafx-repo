package org.bibletranslationtools.app.main.ui

import org.bibletranslationtools.app.main.viewmodel.ContributorListViewModel
import tornadofx.*

class RootView : View() {
    private val viewModel: ContributorListViewModel by inject()

    init {
        importStylesheet(javaClass.getResource("/css/my.css").toExternalForm())
        workspace.header.removeFromParent()
    }

    override val root = vbox {

    }
}
