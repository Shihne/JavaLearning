package ru.spbu.arts.javafx;
/*
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;



public class AppExample extends Application {

    /*
    Реализуем метод start, который объясняет, как запускается приложение. В качестве аргумента в этот метод передаётся
    Stage - ссылка на окно приложения. У окна есть заголовок, кнопки закрытия окна, бордюр для изменения размеров окна
    и т.д.
     *//*
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World JavaFX Application");

        Parent root = initInterface();
        //Задаем сцену,сцена содержит информацию о Parent, т.е. том, что показывать на экране. И инфромацию о том, как
        //показывать. Это размер окна и другие параметры
        primaryStage.setScene(new Scene(root/*, width, height*/  /*));

        //отобразить окно на экране
        primaryStage.show();
    }

    private Parent initInterface() {
        //в конструкторе можно сразу указать детей, т.е. все подузлы
        //и ещё можно сразу указать внешний отступ (padding из css)
        HBox root = new HBox();

        root.setSpacing(10); //можно указать отступ позже

        Button bl = new Button("Hello");
        Label ll = new Label("Just a text");
        TextField tfl = new TextField("enter something");

        //чтобы добавить детей, обращаемся к списку детей и пользуемся методом, который позволяет добавить в список
        //сразу несколько элементов. Можно использовать метод add, но он добавит один элемент.
        //В JavaFX чуть-чуть другие коллекции, не такие как мы привыкли. Коллекции в JavaFX позволяют следить за своим
        //содержимым, т.е. root сразу поймет, что ему добавили детей и перерисуется.
        root.getChildren().addAll(bl, ll, tfl);

        //ещё можно при создании указать детей:
        //HBox root1 = new HBox(bl, ll, tfl);

        //давайте теперь добавим Constraint для элементов
        //было бы естественно сделать так
        //b1.setConstraint(какой, значение)

        //HBox - означает, что констрейнт понимают все HBox-ы
        //HGrow - название constraint, это тот, который говорит, растягивать ли элемент. Always - всегда
        HBox.setHgrow(tfl, Priority.ALWAYS);
        HBox.setMargin(bl, new Insets(8));

        //а это не constraint, это просто свойство нашего HBox,
        //все элементы должны располагаться снизу по центру.
        //Idea подсказывает, что писать в качестве
        root.setAlignment(Pos.BOTTOM_CENTER);

        return root;
    }
}
*/