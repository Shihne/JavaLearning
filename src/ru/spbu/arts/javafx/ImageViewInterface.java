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
import java.util.Arrays;
import java.util.List;


public class ImageViewInterface extends Application {

    private ListView<File> listView;

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

        /*listView.setCellFactory(
                (lv) -> new ListCell<File>() {
                    @Override
                    protected void updateItem(File item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty)
                            setText("Пусто");
                        else {
//                            URL picURL = ImageViewInterface.class.getResource(item.toString());
//                            System.out.println("url: " + picURL);
                            Image i = new Image(item.getAbsolutePath());
                            setGraphic(new ImageView(i));
                        }
                    }
                }
        );*/
        return splitPane;
    }

    private void initData() {
        File folder = new File("src/ru/spbu/arts/javafx/images/");
        File[] files = folder.listFiles();
        List<File> pics = Arrays.asList(files != null ? files : new File[0]);
        System.out.println(pics);
        ObservableList<File> images = FXCollections.observableList(pics);
        listView.setItems(images);

    }
}
