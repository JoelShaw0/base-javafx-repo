package org.bibletranslationtools.app.main.ui

import javafx.animation.*
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.CacheHint
import javafx.scene.Node
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.image.WritableImage
import javafx.scene.text.FontWeight
import javafx.util.Duration
import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign.MaterialDesign
import tornadofx.*
import java.io.FileInputStream

class ProjectView : View() {

    private val nameProperty = SimpleStringProperty()
    private val navigator: Navigator by inject()
    private val mainViewModel = find<MainViewModel>()
    private var animating = false
    private var dragContextX = 0.0

    val listData = observableListOf<ImageView>()

    init {

    }

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
            fitToParentWidth()
            fitToParentHeight()
            repeat(250) {

                add(
                    imageview {
                        if (it > 2) {
                            isVisible = false
                        }
//                        isCache = true
//                        isCacheShape = true
//                        cacheHint = CacheHint.SPEED
                        fitWidth = 200.0
                        fitHeight = 250.0
                        image = Image(FileInputStream("D:\\Downloads\\wav1.png"))
                    }
                )
            }
//            add(
//                imageview {
//                    fitWidth = 200.0
//                    fitHeight = 50.0
//                    image = Image(FileInputStream("D:\\Downloads\\wav2.jpg"))
//                }
//            )
//            add(
//                imageview {
//                    fitWidth = 200.0
//                    fitHeight = 50.0
//                    image = Image(FileInputStream("D:\\Downloads\\wav3.png"))
//                }
//            )

            onMousePressed = EventHandler {
                val node = it.source as Node
                dragContextX = node.translateX - it.sceneX
                println("Press: " + dragContextX)
            }

            onMouseDragged = EventHandler {
                val node = it.source as Node
                node.translateX = dragContextX + it.sceneX
                println(node.translateX)
            }
            onMouseReleased = EventHandler {
                println("Released at " + it.sceneX)
            }
        }
    }

    init {
        nameProperty.bind(mainViewModel.activeBookProperty)
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
