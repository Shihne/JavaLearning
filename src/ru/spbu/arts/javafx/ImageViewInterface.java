package ru.spbu.arts.javafx;
/*
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
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ImageViewInterface extends Application {

    private ListView<File> listView;
    private ImageView imageView;
    private VBox rightPane;
    private DirectoryChooser directoryChooser = new DirectoryChooser();

    private Button button;
    private TextField textField;
    private Label label;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Просмотр изображений");
        configuringDirectoryChooser(directoryChooser);
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction();

        button.setOnAction(event -> {
            File dir = directoryChooser.showDialog(primaryStage);
            if (dir != null)
                textField.setText(dir.getAbsolutePath());
            else
                textField.setText(null);
        });

        primaryStage.show();

    }

    private Parent initInterface() {
        SplitPane splitPane = new SplitPane();
        listView = new ListView<>();
        rightPane = new VBox();
        HBox btn_and_tf = new HBox();
        button = new Button("Выбрать папку");
        textField = new TextField(directoryChooser.getInitialDirectory().getAbsolutePath());
        Pane pane = new Pane();
        label = new Label("Выберите изображение");
        imageView = new ImageView();
        imageView.setPreserveRatio(true);

        pane.getChildren().addAll(label, imageView);
        btn_and_tf.getChildren().addAll(textField, button);
        rightPane.getChildren().addAll(btn_and_tf, pane);
        splitPane.getItems().addAll(listView, rightPane);

        HBox.setHgrow(textField, Priority.ALWAYS);

        listView.setCellFactory(
                (lv) -> new ListCell<File>() {
                    @Override
                    protected void updateItem(File item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText("");
                            setGraphic(null);
                        } else {
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
        listView.setPlaceholder(new Label("Нет изображений"));
        return splitPane;
    }

    private ObservableList<File> initData(File folder) {
        File[] files = folder.listFiles();
        //List<File> pics = Arrays.asList(files != null ? files : new File[0]);
        List<File> pics = new ArrayList<>();
        if (files != null) {
            for (File file : files)
                if (file.isFile()) {
                    Image image = new Image(file.toURI().toString());
                    //System.out.println(image.getUrl());
                    if (!image.isError())
                        pics.add(file);
                    else {
                        String err = file.toURI().toString();
                        System.out.println(err.substring(err.lastIndexOf("/") + 1) + " - не удалось загрузить");
                    }
                }
        }
        //System.out.println(pics);
        return FXCollections.observableList(pics);
    }

    private void initInteraction() {
        listView.itemsProperty().bind(
                Bindings.createObjectBinding(
                        () -> {
                            File folder = new File(textField.getText());
                            return initData(folder);
                        },
                        textField.textProperty()
                )
        );

        imageView.imageProperty().bind(
                Bindings.createObjectBinding(
                        () -> {
                            File file = listView.getSelectionModel().getSelectedItem();
                            if (file != null) {
                                label.setText("");
                                return new Image(file.toURI().toString());
                            } else {
                                label.setText("Выберите изображение");
                                return null;
                            }
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
/*        );
        imageView.fitHeightProperty().bind(
                rightPane.heightProperty()
        );
    }

    private void configuringDirectoryChooser(DirectoryChooser directoryChooser) {
        directoryChooser.setTitle("Выбор папки");
        directoryChooser.setInitialDirectory(new File("src/ru/spbu/arts/javafx/images/"));
    }
}
*/