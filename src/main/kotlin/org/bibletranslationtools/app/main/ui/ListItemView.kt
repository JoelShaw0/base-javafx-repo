package org.bibletranslationtools.app.main.ui

import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.animation.TranslateTransition
import javafx.scene.control.ListCell
import javafx.scene.layout.HBox
import javafx.util.Duration
import tornadofx.*

class ListItemView() : ListCell<ListItemNode>() {
    override fun updateItem(itemNode: ListItemNode?, empty: Boolean) {
        super.updateItem(itemNode, empty)
        val node = ListItemNode(itemNode?.content ?: "empty")
        graphic = node
    }
}

class ListItemNode(val content: String?) : HBox() {
    init {
        prefWidth = 100.0
        prefHeight = 30.0
        add(
            label {
                text = content
            }
        )
    }
}
