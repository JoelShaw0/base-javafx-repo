package org.bibletranslationtools.app.main.ui

import tornadofx.*

class RootView : View() {
    init {
        importStylesheet(javaClass.getResource("/css/my.css").toExternalForm())
        workspace.header.removeFromParent()
    }

    val list = listOf<Int>(1,2,3).toObservable()
    var i = 4

    override val root = vbox {
        label("hello")

        listview(list) {

        }

//        list.onChange { changed ->
//            changed.next()
//            println(changed.list)
//        }

        button("Change List") {
            setOnAction {
                list.addAll(i++)
            }
        }
    }
}
