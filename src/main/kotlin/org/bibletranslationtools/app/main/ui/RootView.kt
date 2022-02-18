package org.bibletranslationtools.app.main.ui

import tornadofx.*
//import java.awt.TextField
import javafx.scene.control.TextField
import java.io.File
//import com.google.gson.Gson
//import com.google.gson.GsonBuilder

class RootView : View() {
    init {
        importStylesheet(javaClass.getResource("/css/my.css").toExternalForm())
        workspace.header.removeFromParent()
    }

    val list = listOf<String>().toObservable()
    var userInput: TextField by singleAssign()
    val database = File ("ContributorDB.txt")

    while ()
    {

    }

    override val root = vbox {
        userInput = textfield()

        listview(list) {

        }

        button("Add Contributor (To beginning)") {
            setOnAction {
                list.add(0 ,userInput.text)
                database.appendText(userInput.text + "\n")
            }
            style{

            }
        }
        button("Add Contributor (To End)") {
            setOnAction {
                list.add(userInput.text)
                database.appendText(userInput.text + "\n")
            }
            style{

            }
        }
    }
}
