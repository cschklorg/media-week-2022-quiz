package me.question.ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.question.ui.runnable.QuestionUI;
import me.question.ui.util.TimerUtil;

import java.io.IOException;
import java.util.Objects;

public class MainMenu extends Application {
    public static Scene scene;
    public static Stage stages;
    public static int timeSec = 180;
    public static Long currentMills;
    public static TimerUtil timer = new TimerUtil();
    public static Menu menu = new Menu();
    public static Question ques = new Question();
    public static QuestionUI qui = new QuestionUI();

    public static void timerCountDown() {
        timeSec--;
    }

    public static void main(String[] args) {
        currentMills = System.currentTimeMillis();
        launch(args);
        /*
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    timerCountDown();
                    time.setText(timeSec + "");
                    Objects.requireNonNull(menu.getTime()).setText(timeSec + "");
                    Objects.requireNonNull(question.getTime()).setText(timeSec + "");
                    qui.onAction();
                } catch (Exception ignored) {
                }
            }
        }, 0L, 1000L);

         */
    }

    @Override
    public void start(Stage stage) throws IOException {
        stages = stage;
        /*
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        System.out.println(bounds.getWidth());
        System.out.println(bounds.getHeight());
        */

        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("menu.fxml"));
        scene = new Scene(fxmlLoader.load(), 1550, 870);

        //Set Full Screen
        stage.setMaximized(true);

        //Run Menu
        stage.setTitle("精彩Quiz题");
        stage.setScene(scene);
        stage.show();
    }
}