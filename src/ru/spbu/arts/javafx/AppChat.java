/*package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppChat extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat JavaFX Application");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private Parent initInterface() {
        HBox root = new HBox();

        VBox rootLeft = new VBox();
        VBox rootRight = new VBox();
        root.getChildren().addAll(rootLeft, rootRight);

        TextArea ta = new TextArea("Just a dialog");
        HBox tfb = new HBox();
        rootLeft.getChildren().addAll(ta, tfb);

        Label ll = new Label("Contacts");
        ListView lv = new ListView();
        rootRight.getChildren().addAll(ll, lv);

        TextField tf = new TextField("Enter something");
        Button bn = new Button("Send");
        tfb.getChildren().addAll(tf, bn);

        VBox.setVgrow(ta, Priority.ALWAYS);
        HBox.setHgrow(ta, Priority.ALWAYS);
        tfb.setAlignment(Pos.BOTTOM_LEFT);
        HBox.setHgrow(rootLeft, Priority.ALWAYS);
        VBox.setVgrow(lv, Priority.ALWAYS);
        HBox.setHgrow(tf, Priority.ALWAYS);
        //rootRight.setAlignment(Pos.BOTTOM_RIGHT);

        return root;
    }
}*/
