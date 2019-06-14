package objects.str_transformers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SVGTransform {
    public static void main(String[] args) {
        String rect = "<rect x=\"0\" y=\"0\" height=\"100\" width=\"100\" style=\"stroke: #000000; fill: #F3BC16\" />";

        StringTransformer st = s -> {
            StringBuilder sb = new StringBuilder();
            sb.append("\n<g transform=\"scale(0.333333333333, 0.333333333333)\" >");
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (!(i == 1 && j == 1)) {
                        sb.append("\n<g transform=\"translate(").append(i * 100).append(", ").append(j * 100).append(")\" >");
                        sb.append("\n\t").append(s);
                        sb.append("\n</g>");
                    }
            sb.append("\n</g>");
            return sb.toString();
        };

        try {
            Files.writeString(Paths.get("transformer.svg"),
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">" +
                    st.transform(rect, 4) + "\n</svg>",
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
