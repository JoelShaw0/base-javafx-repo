package org.bibletranslationtools.app.main.ui

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.ListCell
import javafx.scene.layout.HBox
import org.bibletranslationtools.app.main.entity.Contributor
import tornadofx.*

/** List cell combines UI and data to render */
class ContributorListCell : ListCell<Contributor>() {
    private val cellGraphic = ContributorCell()

    override fun updateItem(item: Contributor?, empty: Boolean) {
        super.updateItem(item, empty)

        if (empty || item == null) {
            graphic = null
            return
        }

        graphic = cellGraphic.apply {
            name.set(item.name)
        }
    }
}

/** Cell's UI element */
class ContributorCell : HBox() {
    val name = SimpleStringProperty()

    init {
        addClass("contributor-list__cell")

        label(name)
    }
}