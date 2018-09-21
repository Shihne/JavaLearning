public class ExceptionCatch1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            try {
                f(i);
            } catch (Exception e) {
                System.out.println(i + " - исключение");
            }
        }
    }

    public static void f(int x) throws Exception {
        if (x % 2 == 0)
            throw new Exception();
    }


}
