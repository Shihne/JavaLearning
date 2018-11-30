package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ImageViewInterface extends Application {

    private ListView<File> listView;
    private ImageView imageView;
    private VBox rightPane;
    private Map<String, Double> map = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Просмотр изображений");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction();
        primaryStage.show();

        initData();
    }

    private Parent initInterface() {
        SplitPane splitPane = new SplitPane();
        listView = new ListView<>();
        rightPane = new VBox();
        HBox btn_and_tf = new HBox();
        Button button = new Button("Выбрать");
        TextField textField = new TextField();
        Pane pane = new Pane();
        imageView = new ImageView();
        imageView.setPreserveRatio(true);

        pane.getChildren().add(imageView);
        btn_and_tf.getChildren().addAll(textField, button);
        rightPane.getChildren().addAll(btn_and_tf, pane);
        splitPane.getItems().addAll(listView, rightPane);

        HBox.setHgrow(textField, Priority.ALWAYS);

        listView.setCellFactory(
                (lv) -> new ListCell<File>() {
                    @Override
                    protected void updateItem(File item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty)
                            setText("");
                        else {
//                            URL picURL = ImageViewInterface.class.getResource(item.toString());
//                            System.out.println("url: " + picURL);
                            ImageView iv = new ImageView(new Image(item.toURI().toString()));
                            iv.setFitHeight(100);
                            iv.setFitWidth(100);
                            iv.setPreserveRatio(true);
                            setGraphic(iv);
                            String str = item.toString();
                            setText(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));
                        }
                    }
                }
        );
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

    private void initInteraction() {

        imageView.imageProperty().bind(
                Bindings.createObjectBinding(
                        () -> {
                            File file = listView.getSelectionModel().getSelectedItem();
                            if (file != null) {
                                return new Image(file.toURI().toString());
                            } else
                                return null;
                            },
                        listView.getSelectionModel().selectedItemProperty()
                )
        );


        imageView.fitWidthProperty().bind(
                rightPane.widthProperty()
                /*Bindings.createDoubleBinding(
                        () -> {
                            if (rightPane.getWidth() < map.get(imageView.toString()))
                                return rightPane.getWidth();
                            else
                                return imageView.getFitWidth();
                        },
                        rightPane.widthProperty()
                )*/
        );
        imageView.fitHeightProperty().bind(
                rightPane.heightProperty()
        );
    }
}
