package objects.rationals;

public class Rational {

    public static int gcd(int n, int d) {
        int smallest;
        int nod = 1;
        if (n > d)
            smallest = d;
        else
            smallest = n;
        for (int i = smallest; i > 0; i--)
            if (n % i == 0 && d % i == 0) {
                nod = i;
                break;
            }
        return nod;
    }

    public static Rational add(Rational r1, Rational r2) {
        return new Rational(r1.getNumerator() * r2.getDenominator() + r1.getDenominator() * r2.getNumerator(), r1.getDenominator() * r2.getDenominator());
    }
    public static Rational sub(Rational r1, Rational r2) {
        return new Rational(r1.getNumerator() * r2.getDenominator() - r1.getDenominator() * r2.getNumerator(), r1.getDenominator() * r2.getDenominator());
    }
    public static Rational mul(Rational r1, Rational r2) {
        return new Rational(r1.getNumerator() * r2.getNumerator(), r1.getDenominator() * r2.getDenominator());
    }
    public static Rational div(Rational r1, Rational r2) {
        return new Rational(r1.getNumerator() * r2.getDenominator(), r1.getDenominator() * r2.getNumerator());
    }

    public static final Rational ZERO = new Rational(0);
    public static final Rational ONE = new Rational(1, 1);

    private int n;
    private int d;

    public Rational(int n, int d) {
        int nod = gcd(Math.abs(n), Math.abs(d));
        this.n = n / nod;
        this.d = d / nod;
    }

    public Rational(int n) {
        this.n = n;
        this.d = 1;
    }

    public String toString() {
        if (d == 1)
            return n + "";
        else if (n == 0)
            return "0";
        else if (d == 0)
            return "doesn't exist";
        else
            return n + "/" + d;
    }

    public double toDouble() {
        return (double)n / d;
    }

    public int getNumerator() { return n; }
    public int getDenominator() {
        return d;
    }

    /*public void set(Rational r) {
        this.n = r.getNumerator();
        this.d = r.getDenominator();
    }*/

    public Rational add(Rational r) {
        return new Rational(n * r.getDenominator() + d * r.getNumerator(), d * r.getDenominator());
    }
    /*public void addInPlace(Rational r) {
        set(add(r));
    }*/

    public Rational sub(Rational r) {
        return new Rational(n * r.getDenominator() - d * r.getNumerator(), d * r.getDenominator());
    }

    /*public void subInPlace(Rational r) {
        set(sub(r));
    }*/

    public Rational mul(Rational r) {
        return new Rational(n * r.getNumerator(), d * r.getDenominator());
    }
    /*public void mulInPlace(Rational r) {
        set(mul(r));
    }*/

    public Rational div(Rational r) {
        return new Rational(n * r.getDenominator(), d * r.getNumerator());
    }
    /*public void divInPlace(Rational r) {
        set(div(r));
    }*/
}
