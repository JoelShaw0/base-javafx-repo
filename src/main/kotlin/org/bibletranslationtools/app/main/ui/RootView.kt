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

    override val root = vbox {
        userInput = textfield()
        if (database.createNewFile())
        {
            println("File Created")
        }
        else
        {
            println("Already exists")
        }
        listview(list) {

        }

        button("Add Contributor") {
            setOnAction {
                list.add(userInput.text)
                database.appendText(userInput.text + "\n")
            }
            style{

            }
        }
    }
}
