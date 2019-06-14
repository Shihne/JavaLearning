package objects.str_transformers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TransformersRealization {

    public static void main(String[] args) {

        StringTransformer stringTransformer = s -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == 'F')
                    stringBuilder.append("F+F--F+F");
                else
                    stringBuilder.append(s.charAt(i));
            return stringBuilder.toString();
        };

        System.out.println(stringTransformer.transform("F", 2));

        try {
            Files.writeString(Paths.get("transformer.txt"), stringTransformer.transform("F", 10), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
