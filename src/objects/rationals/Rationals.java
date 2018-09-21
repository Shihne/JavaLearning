package objects.rationals;

public class Rationals {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 6);
        Rational r2 = new Rational(1, 3);
        Rational r3 = r1.add(r2);
        System.out.println(r3);

        Rational r4 = r1.sub(r2);
        System.out.println(r4);

        Rational r5 = r1.mul(r2);
        System.out.println(r5);

        Rational r6 = r1.div(r2);
        System.out.println(r6);

        Rational r7 = new Rational(-1, 7);
        Rational r8 = new Rational(5);
        Rational r9 = r7.add(r8);
        System.out.println(r9);

        Rational f = Rational.ZERO;
        System.out.println(f.toString());
        System.out.println(Rational.ONE.toString());

        Rational rr = new Rational(5, 10);
        System.out.println(rr.toString());

        Rational rr1 = new Rational(1, 6);
        Rational rr2 = new Rational(1, 3);

        Rational rr3 = Rational.add(rr1, rr2);
        System.out.println(rr3);

        Rational rr4 = Rational.sub(rr1, rr2);
        System.out.println(rr4);

        Rational rr5 = Rational.mul(rr1, rr2);
        System.out.println(rr5);

        Rational rr6 = Rational.div(rr1, rr2);
        System.out.println(rr6);

        System.out.println(seriesSumPrt(20));
        System.out.println(seriesSumStr(19));
        System.out.println(seriesSumStr(20));

        // 275295799 * 20 + 77597520 - превосходит максимальное значения для Integer
    }

    public static Rational getRational(int n) {
        Rational r = new Rational(1,1);
        for (int i = 2; i <= n; i++) {
            r = r.add(new Rational(1, i));
        }
        return r;
    }
    public static double seriesSumPrt(int n) {
        Rational r = getRational(n);
        return r.toDouble();
    }
    public static String seriesSumStr(int n) {
        Rational r = getRational(n);
        return r.toString();
    }
}
