import java.util.Random;
import java.util.stream.IntStream;

public class ThrowCoin {
    public static void main(String[] args) {
        Random r = new Random();
//        long m = IntStream.generate(() -> r.nextInt(2)).limit(100).filter(x -> x == 1).count();
        long m = IntStream.generate(() -> r.nextInt(2)).limit(100).sum();

        System.out.println("Орёл -> " + m);
        System.out.println("Решка -> " + (100 - m));
    }
}
