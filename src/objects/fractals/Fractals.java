package objects.fractals;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Fractals extends Application {

    private double dx = 0.01;
    private int width = 400;
    private double x0 = width * dx * (-0.5);
    private int height = 400;
    private double y0 = height * dx * 0.5;
    private Pane pane = new Pane();
    private ImageView imageView = new ImageView();
    private Fractal mf = new MandelbrotFractal();
    private Palette bwgp = new BlackWhiteGradientPalette();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Фрактал");
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode s = event.getCode();
                double dx0 = dx;
                if (s.equals(KeyCode.LEFT))
                    x0 -= pane.getWidth() / 10 * dx;
                else if (s.equals(KeyCode.RIGHT))
                    x0 += pane.getWidth() / 10 * dx;
                else if (s.equals(KeyCode.UP))
                    y0 += pane.getHeight() / 10 * dx;
                else if (s.equals(KeyCode.DOWN))
                    y0 -= pane.getHeight() / 10 * dx;
                else if (s.equals(KeyCode.A)) {
                    dx = dx / 1.1;
                    x0 += (pane.getWidth() * dx0 - pane.getWidth() * dx) / 2;
                    y0 -= (pane.getHeight() * dx0 - pane.getHeight() * dx) / 2;
                } else if (s.equals(KeyCode.D)) {
                    dx = dx * 1.1;
                    x0 -= (pane.getWidth() * dx - pane.getWidth() * dx0) / 2;
                    y0 += (pane.getHeight() * dx - pane.getHeight() * dx0) / 2;
                }
                setFractal();
            }
        });
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction();
        primaryStage.show();
    }

    private Parent initInterface() {
        //Fractal cf = new CircleFractal();
        //Palette bawp = new BlackAndWhitePalette();
        setFractal();
        pane.getChildren().addAll(imageView);
        return pane;
    }

    private void setFractal() {
        WritableImage wi = new WritableImage(width, height);
        PixelWriter pw = wi.getPixelWriter();
        for (int x1 = 0; x1 < width; x1++)
            for (int y1 = 0; y1 < height; y1++) {
                pw.setColor(x1, y1, bwgp.getColor(mf.getColor(x0 + x1 * dx, y0 - y1 * dx)));
            }
        imageView.setImage(wi);
    }

    private void initInteraction() {
        pane.widthProperty().addListener(
                prop -> {
                    width = (int) pane.getWidth();
                    x0 = width * dx * (-0.5);
                    setFractal();
                }
        );
        pane.heightProperty().addListener(
                prop -> {
                    height = (int) pane.getHeight();
                    y0 = height * dx * 0.5;
                    setFractal();
                }
        );

    }
}
