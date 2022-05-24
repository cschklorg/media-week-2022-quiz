module me.question.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires kotlin.stdlib;
    requires java.desktop;

    opens me.question.ui to javafx.fxml;
    exports me.question.ui;
    exports me.question.ui.runnable;
    opens me.question.ui.runnable to javafx.fxml;
}