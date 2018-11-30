package objects.fractals;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Fractals extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Фрактал");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Parent initInterface() {
        Pane pane = new Pane();
        ImageView imageView = new ImageView();
        WritableImage wi = new WritableImage(400, 400);
        PixelWriter pw = wi.getPixelWriter();
        //Fractal cf = new CircleFractal();
        //Palette bawp = new BlackAndWhitePalette();


        imageView.setImage(wi);
        pane.getChildren().addAll(imageView);
        return pane;
    }
}
