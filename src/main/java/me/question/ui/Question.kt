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

    @FXML
    var quesAns: Text? = null

    companion object {
        @JvmStatic
        var qui: QuestionUI = QuestionUI()

        @JvmStatic
        var first: Boolean = true

        @JvmStatic
        var currentStage: Int = 0

        @JvmStatic
        var correct: Int = 0
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
        if (qui.questionCount <= 10) {
            if (!first) {
                qui.stage = RandomUtil.nextInt(1, 15)
                currentStage = qui.stage
                /*
                if (qui.questionMap != null && qui.questionMap.contains(qui.questionID)) {
                    //qui.stage++
                    qui.stage = RandomUtil.nextInt(1, 15)
                    currentStage = qui.stage
                }

                 */
                if (!qui.questionMap.contains(qui.questionID)) {
                    qui.questionCount++
                } else {
                    //qui.stageList.forEach { qui.stage = RandomUtil.nextInt(1, 15, it) }
                    qui.stage = RandomUtil.nextInt(1, 15, qui.stage)
                    currentStage = qui.stage
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
                //qui.questionMap[qui.questionID] = event.source
                if (event.source is Button) {
                    if ((event.source as Button).text.equals(qui.correctAns))
                    correct++
                    quesAns!!.text = correct.toString()
                }
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
            /*
            qui.questionMap.forEach {
                if (it.component2().equals(qui.correctAns)) {
                    correct++
                    println(correct)
                }
            }
            */
            //println(correct)
            //exitProcess(0)
        }
    }
}