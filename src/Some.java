
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Some {
    public static void main(String[] args) {
        System.out.println(Stream.of("abc", "def", " g").collect(Collectors.joining()));

    }

}
