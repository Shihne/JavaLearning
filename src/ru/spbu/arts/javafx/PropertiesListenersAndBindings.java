package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PropertiesListenersAndBindings extends Application {

    //поля класса. Они живут и доступны всё время, пока жив класс, т.е. окно программы
    private TextField textField1;
    private Button button1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Properties, Listeners, and Bindings");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction(); //новый метод, в нём будет описывать поведение элементов интерфейса

        primaryStage.show();
    }



    private Parent initInterface() {
        FlowPane root = new FlowPane();

        //--------------------------------------
        VBox example1 = new VBox();
        //Стараться давать переменным осмысленные названия. Здесь button1 означает только, что это кнопка для первого
        //примера.
        textField1 = new TextField();
        button1 = new Button("Пример 1");
        example1.getChildren().addAll(textField1, button1);

        //давайте раскрасим панель example1
        example1.setBackground( //фон
                new Background(
                        new BackgroundFill(
                                Color.web("#FF0000"), //Цвет может выступать заполнителем фона
                                new CornerRadii(0), //радиус закругления углов
                                Insets.EMPTY //пустой отступ для закраски
                        ) //заполнитель для фона
                )
        );
        example1.setStyle("-fx-background-color: #00FF00"); //другой способ, чуть короче
                                                            //пользуемся CSS со стилями из javafx

        root.getChildren().addAll(example1);
        //-----------------------
        return root;
    }

    private void initInteraction() {
        //-----------Пример1-----------
        //как заставить кнопку что-то делать

        //1) универсальный, но сложный способ
        //В JavaFX реализована работа с событиями. Разные объекты генерируют события
        //можно добавлять слушателей (обработчиков), которые реагируют на интересующие их события.
        //Кнопка генерирует событие типа ActionEvent.ACTION, это происходит в момент нажатия на кнопку. Нажатие может
        //быть разным: мышкой, кнопкой Enter, пробелом, касанием экрана и т.п.
        //В принципе, все Node, включая кнопку, генерируют ещё и события мыши, т.е. можно реагировать на событие, что
        // на кнопку наведена/нажата/отпущена мышь.
        //Но в этой программе нам это не интересно
        button1.addEventHandler(
                ActionEvent.ACTION,
                a -> System.out.println("pressed: " + a)
                //второе - действие, в виде лямбда выражения.
                //а - информация о событии. В этой информации всегда можно найти источник события. Если бы у нас было
                // событие от мыши, мы бы дополнительно могли получить инфу о положении курсора.
        );
    }
}
