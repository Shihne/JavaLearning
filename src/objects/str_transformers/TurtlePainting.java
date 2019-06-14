package objects.str_transformers;

import TurtleGraphics.Pen;
import TurtleGraphics.StandardPen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TurtlePainting {
    public static void main(String[] args) {
        Pen turtle = new StandardPen();
//        turtle.turn(90);
        turtle.up();
//        turtle.move(1020);
//        turtle.turn(90);
//        turtle.move(530);
//        turtle.turn(-270);
        turtle.move(-1000, -100);
        turtle.setDirection(0);
        turtle.down();
        try {
            //byte[] data = Files.readAllBytes(Paths.get("transformer.txt"));
            String content = Files.readString(Path.of("transformer.txt"));

            for (int i = 0; i < content.length(); i++)
                switch (content.charAt(i)) {
                    case 'F': turtle.move(0.025); break;
                    case '+': turtle.turn(60); break;
                    case '-': turtle.turn(-60); break;
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
