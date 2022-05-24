package me.question.ui

import javafx.concurrent.Task
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ProgressBar
import javafx.scene.text.Text
import me.question.ui.runnable.QuestionUI
import me.question.ui.util.RandomUtil

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

        @JvmStatic
        var currentStage: Int = 0
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
        //TODO 给予每一个题目一个专属的ID
        if (qui.questionMap.size <= 10) {
            if (!first) {
                qui.stage = RandomUtil.nextInt(1, 15)
                currentStage = qui.stage
                if (qui.questionMap != null && qui.questionMap.contains(currentStage)) {
                    //qui.stage++
                    qui.stage = RandomUtil.nextInt(1, 15)
                    currentStage = qui.stage
                }
                if (!qui.questionMap.contains(currentStage)) {
                    qui.questionCount++
                }
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

            if (event.source.equals(ques1)
                || event.source.equals(ques2)
                || event.source.equals(ques3)
                || event.source.equals(ques4)
            ) {
                qui.questionMap[qui.stage] = event.source
            }

            try {
                val task: Task<Void?> = object : Task<Void?>() {
                    override fun call(): Void? {
                        try {
                            for (i in 0 until qui.stage) {
                                updateProgress(i.toDouble(), currentStage.toDouble())
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
        } else {
            //
        }
    }
}