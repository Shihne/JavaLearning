package ru.spbu.arts.javafx;
/*
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Donkey extends Application {
    private ImageView imageView;
    private Pane pane;
    private Label question;
    private List<Question> questions = new ArrayList<>();
    private int number = 0;
    private int trueCounts = 0;
    private Button button;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Осёл");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction();
        primaryStage.show();

        loadText();
        loadImage();
    }

    private Parent initInterface() {
        VBox root = new VBox();
        root.setSpacing(5);
        root.setPrefWidth(700);
        root.setPrefHeight(600);
        HBox title = new HBox();
        title.setSpacing(6);
        pane = new Pane();
        question = new Label();
        button = new Button("Начать заново");
        button.setVisible(false);
        imageView = new ImageView();
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);
        imageView.setCursor(Cursor.HAND);

        title.getChildren().addAll(question, button);
        pane.getChildren().addAll(imageView);
        root.getChildren().addAll(title, pane);

        HBox.setHgrow(question, Priority.ALWAYS);
        HBox.setHgrow(pane, Priority.ALWAYS);
        VBox.setVgrow(pane, Priority.ALWAYS);
        return root;
    }

    private void loadImage() {
        try (
                InputStream image = Donkey
                        .class
                        .getResourceAsStream("donkey.jpg")
        ) {
            Image img = new Image(image);
            imageView.setImage(img);
        } catch (IOException e) {
            // \o
        }
    }

    private void initInteraction() {
        imageView.fitWidthProperty().bind(
                pane.widthProperty()
        );
        imageView.fitHeightProperty().bind(
                pane.heightProperty()
        );
        imageView.setOnMouseClicked(event -> {
            String msg = "(x: " + event.getX() + ", y: " + event.getY() + ") -- (sceneX: " +
                    event.getSceneX() + ", sceneY: " + event.getSceneY() + ") -- " + "(screenX: " +
                    event.getScreenX() + ", screenY: " + event.getScreenY() + ")";
            System.out.println(msg);
            checkCoordinates(event.getX(), event.getY());
        });
        button.setOnMouseClicked(event -> {
            if (button.isVisible()) {
                number = 0;
                trueCounts = 0;
                question.setText(questions.get(number).getQuestion());
                button.setVisible(false);
            }
        });
    }

    private void loadText() {
        try (
                InputStream text = Donkey
                        .class
                        .getResourceAsStream("donkey.txt")
        ) {
            Scanner sc = new Scanner(text);

            while (sc.hasNextLine()) {
                String x = sc.next();
                String y = sc.next();
                String width = sc.next();
                String height = sc.next();
                String quest = sc.next() + sc.nextLine();
                questions.add(new Question(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(width),
                        Integer.parseInt(height), quest));
                System.out.println(x + ", " + y + ", " + width + ", " + height + ", " + quest + ", ");
            }

        } catch (IOException e) {
            //
        }
        question.setText(questions.get(number).getQuestion());
    }

    private void checkCoordinates(double x, double y) {
        Question qst = questions.get(number);
        if (x >= qst.getX() && x <= qst.getX() + qst.getWidth() && y >= qst.getY()
                && y <= qst.getY() + qst.getHeight()) {
            trueCounts++;
            System.out.println("Верно");
        } else
            System.out.println("Неверно");
        number++;
        if (number != questions.size())
            question.setText(questions.get(number).getQuestion());
        else {
            question.setText("Вы закончили: " + trueCounts + "/" + number);
            button.setVisible(true);
        }
    }
}
*/