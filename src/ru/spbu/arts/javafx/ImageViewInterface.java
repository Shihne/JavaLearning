package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ImageViewInterface extends Application {

    private ListView<Image> listView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Просмотр изображений");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        initData();
    }

    private Parent initInterface() {
        SplitPane splitPane = new SplitPane();
        listView = new ListView<>();
        VBox rightPane = new VBox();
        HBox btn_and_tf = new HBox();
        Button button = new Button("Выбрать");
        TextField textField = new TextField();
        Pane pane = new Pane();
        ImageView imageView = new ImageView();

        pane.getChildren().add(imageView);
        btn_and_tf.getChildren().addAll(textField, button);
        rightPane.getChildren().addAll(btn_and_tf, pane);
        splitPane.getItems().addAll(listView, rightPane);

        HBox.setHgrow(textField, Priority.ALWAYS);



        return splitPane;
    }

    private void initData() {

        List<Image> pics = new ArrayList<>();

        ObservableList<Image> images = FXCollections.observableList(pics);


    }
}
