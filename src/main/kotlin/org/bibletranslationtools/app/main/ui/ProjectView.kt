package org.bibletranslationtools.app.main.ui

import javafx.animation.*
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.image.Image
import javafx.scene.image.WritableImage
import javafx.scene.text.FontWeight
import javafx.util.Duration
import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign.MaterialDesign
import tornadofx.*
import java.io.FileInputStream

class ProjectView : View() {

    private val nameProperty = SimpleStringProperty()

    private val breadCrumb = BreadCrumb().apply {
        titleProperty.bind(this@ProjectView.nameProperty)
        activeTitleProperty.set("Project")
        iconProperty.set(FontIcon(MaterialDesign.MDI_BOOK))
        onClickAction {
            navigator.dock<ProjectView>()
        }
    }
    private val navigator: Navigator by inject()
    private val mainViewModel = find<MainViewModel>()
    private var animating = false

    override val root = vbox {
        spacing = 20.0
        paddingAll = 20.0
        alignment = Pos.CENTER

        label("ListView example:") {
            style {
                fontWeight = FontWeight.BOLD
            }
        }

        hbox {
            add(
                imageview {
                    fitWidth = 200.0
                    fitHeight = 50.0
                    image = Image(FileInputStream("D:\\Downloads\\wav1.png"))
                }
            )
            add(
                imageview {
                    fitWidth = 200.0
                    fitHeight = 50.0
                    image = Image(FileInputStream("D:\\Downloads\\wav2.jpg"))
                }
            )
            add(
                imageview {
                    fitWidth = 200.0
                    fitHeight = 50.0
                    image = Image(FileInputStream("D:\\Downloads\\wav3.png"))
                }
            )
            onMouseClicked = EventHandler {
//                if (animating) {
//                    return@EventHandler
//                }
//                animating = true
                moveNode(this as Node)
                this.add(imageview {
                    fitWidth = 200.0
                    fitHeight = 50.0
                    image = Image(FileInputStream("D:\\Downloads\\wav3.png"))
                })
            }
        }
    }

    init {
        nameProperty.bind(mainViewModel.activeBookProperty)
    }

    private fun fadeTransition(node: Node, onFinish: () -> Unit) {
        val ft = FadeTransition(Duration.millis(800.0), node)
        ft.fromValue = 1.0
        ft.toValue = 0.0
        ft.cycleCount = 2
        ft.isAutoReverse = true
        ft.onFinished = EventHandler {
            onFinish()
//            ft.stop()
        }
        ft.play()
    }

    private fun moveNode(node: Node) {
        node.toFront()
        val distance = 200.0
        val tt = TranslateTransition(Duration.millis(2000.0), node)
        tt.cycleCount = 1
        tt.byX = -distance
//        tt.isAutoReverse = true
        tt.onFinished = EventHandler {
//            onFinish()
            animating = false
        }
        tt.play()
    }

    private fun revertTranslateTransition(node: Node, onFinish: () -> Unit) {
        val distance = node.translateY
        val tt = TranslateTransition(Duration.millis(1.0), node)
        tt.cycleCount = 1
        tt.byY = -distance     // revert the distance moved...
        tt.onFinished = EventHandler {
//            node.toBack()
            node.viewOrder = 1.0
            onFinish()
        }
        tt.play()
    }
}
