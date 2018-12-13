package objects.fractals;

public class MandelbrotFractal implements Fractal {
    private static final int N = 1000;
    @Override
    public double getColor(double p, double q) {
        double x = 0;
        double y = 0;
        double x1;
        double y1;
        double z;
        for (int n = 0; n <= N; n++) {
            x1 = x * x - y * y + p;
            y1 = 2 * x * y + q;
            x = x1;
            y = y1;
            if (x * x + y * y > 4)
                return (double) n / N;

        }
        return 1;
    }
}
