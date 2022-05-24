package me.question.ui

import javafx.concurrent.Task
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ProgressBar
import javafx.scene.text.Text
import me.question.ui.runnable.QuestionUI

class Question {
    @FXML
    var time: Text? = null

    @FXML
    var ques1: Button? = null

    @FXML
    var ques2: Button? = null

    @FXML
    var ques3: Button? = null

    @FXML
    var ques4: Button? = null

    @FXML
    var questionText: Text? = null

    @FXML
    var progressBar: ProgressBar? = null

    companion object {
        @JvmStatic
        var qui: QuestionUI = QuestionUI()

        @JvmStatic
        var first: Boolean = true
    }

    private fun onTick() {
        val t = Thread {
            while (true) {
                if (first) {
                    qui.stage = 1
                    qui.questionCount = 1
                    first = false
                }
                qui.onAction()
                if (MainMenu.timer.passed(1000)) {
                    MainMenu.timerCountDown()
                    MainMenu.timer.reset()
                }
                time!!.text = MainMenu.timeSec.toString()
            }
        }
        if (Menu.started) {
            t.start()
            Menu.started = false
        }
    }

    @FXML
    fun onEvent(event: Event) {
        onTick()
    }

    @FXML
    fun onAction(event: ActionEvent) {
        /*
        if (qui.stage == 1) {
            ques1!!.text = qui.answer1
        }
         */
        if (!first) {
            qui.stage++
            qui.questionCount++
        }
        questionText!!.text = qui.question
        if (questionText!!.text.contains("以下哪个不是社交媒体")) {
            questionText!!.layoutX = questionText!!.text.length / 2.0
        } else {
            questionText!!.layoutX = questionText!!.text.length / 1.5
        }
        ques1!!.text = qui.answer1
        ques2!!.text = qui.answer2
        ques3!!.text = qui.answer3
        ques4!!.text = qui.answer4

        try {
            val task: Task<Void?> = object : Task<Void?>() {
                override fun call(): Void? {
                    try {
                        for (i in 0 until qui.stage) {
                            updateProgress(i.toLong(), qui.stage.toLong())
                            Thread.sleep(10)
                        }
                    } catch (ignored: Exception) {
                    }
                    return null
                }
            }
            progressBar!!.progressProperty().unbind()
            progressBar!!.progressProperty().bind(task.progressProperty())
        } catch (ignored: Exception) {
        }
    }
}