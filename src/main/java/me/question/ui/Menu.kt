package me.question.ui

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ProgressBar
import javafx.scene.text.Text
import me.question.ui.runnable.QuestionUI

class Menu {
    @FXML
    var startButton: Button? = null

    @FXML
    var time: Text? = null

    @FXML
    var progressBar: ProgressBar? = null

    companion object {
        @JvmStatic
        var scene: Scene? = null

        @JvmStatic
        var qui: QuestionUI? = QuestionUI()

        @JvmStatic
        var ques: Question? = Question()

        @JvmStatic
        var started: Boolean = false
    }

    @FXML
    fun onAction(event: ActionEvent) {
        val fxmlLoader = FXMLLoader(MainMenu::class.java.getResource("Question.fxml"))
        if (event.source.equals(startButton)) {
            MainMenu.scene = null
            scene = Scene(fxmlLoader.load(), 1550.0, 870.0)
            MainMenu.stages.scene = scene
            MainMenu.stages.show()

            qui!!.stage = 1

            MainMenu.timer.reset()
            started = true
        }
    }
}