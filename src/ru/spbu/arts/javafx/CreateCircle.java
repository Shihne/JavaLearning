package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Map;

public class CreateCircle extends Application {

    private Slider slider = new Slider();
    private ColorPicker cp1 = new ColorPicker();
    private ColorPicker cp2 = new ColorPicker();
    private Circle circle = new Circle();
    private Pane pane = new Pane();
    private VBox panel = new VBox();
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



        root.getChildren().addAll(panel, pane);

        Label radius = new Label("Выберите радиус");
        Label circle_color = new Label("Выберите цвет круга");
        Label bgColor = new Label("Выберите цвет фона");
        panel.getChildren().addAll(radius, slider, circle_color, cp1, bgColor, cp2);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        cp2.setValue(Color.CORAL);
        pane.getChildren().add(circle);
        HBox.setHgrow(pane, Priority.ALWAYS);
        panel.setPrefWidth(300);
        pane.setPrefWidth(300);

        return root;
    }

    private void initInteraction() {
        circle.radiusProperty().bind(
                slider.valueProperty()
        );
        circle.fillProperty().bind(
                cp1.valueProperty()
        );

        //TODO используйте связывание вместо слушателей

        pane.backgroundProperty().bind(
                Bindings.createObjectBinding(
                        () -> new Background(new BackgroundFill(cp2.getValue(), new CornerRadii(0), Insets.EMPTY)),
                        cp2.valueProperty()
                )
        );

        /*panel.heightProperty().addListener(
                prop -> circle.setCenterY(panel.getHeight() / 2)
        );
        panel.widthProperty().addListener(
                prop -> circle.setCenterX(panel.getWidth() / 2)
        );

        circle.setCenterX(panel.getWidth() / 2);
        circle.setCenterY(panel.getHeight() / 2);*/

        circle.centerYProperty().bind(
                Bindings.createDoubleBinding(
                        () -> panel.getHeight() / 2,
                        panel.heightProperty()
                )
        );
        circle.centerXProperty().bind(
                Bindings.createDoubleBinding(
                        () -> pane.getWidth() / 2,
                        pane.widthProperty()
                )
        );
        slider.maxProperty().bind(
                Bindings.createDoubleBinding(
                        () -> pane.getWidth() / 2,
                        pane.widthProperty()
                )
        );
    }
}
