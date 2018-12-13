package objects.fractals;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Fractals extends Application {
    @Override
    public void start(Stage primaryStage) {
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
        Fractal mf = new MandelbrotFractal();
        Palette bawp = new BlackAndWhitePalette();
        int x0 = -200;
        int y0 = 200;
        double dx = 0.01;
        for (int x1 = 0; x1 < 400; x1++)
            for (int y1 = 0; y1 < 400; y1++) {
                pw.setColor(x1, y1, bawp.getColor(mf.getColor((x0 + x1) * dx, (y0 - y1) * dx)));
            }


        imageView.setImage(wi);
        pane.getChildren().addAll(imageView);
        return pane;
    }
}
