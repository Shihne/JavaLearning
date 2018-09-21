public class ExceptionCatch1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            try {
                f(i);
                System.out.println("Не исключение");
            } catch (Exception e) {
                System.out.println("Исключение");
            }
        }
    }

    public static void f(int x) throws Exception {
        if (x % 2 == 0)
            throw new Exception();
    }


}
