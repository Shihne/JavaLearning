package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CreateCircle extends Application {

    private Slider slider = new Slider();
    private ColorPicker cp1 = new ColorPicker();
    private ColorPicker cp2 = new ColorPicker();
    private Circle circle = new Circle();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat JavaFX Application");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction();

        primaryStage.show();
    }

    private Parent initInterface() {
        HBox root = new HBox();

        VBox panel = new VBox();
        VBox result = new VBox();

        root.getChildren().addAll(panel, result);

        panel.getChildren().addAll(slider, cp1, cp2);
        result.getChildren().add(circle);
        panel.setPrefWidth(300);

        return root;
    }

    private void initInteraction() {

    }
}
