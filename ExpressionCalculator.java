package expression;

public class ExpressionCalculator {
    private double a;
    private double c;
    private double x;

    public ExpressionCalculator() {
        this(1.0, 1.0, 0.5);
    }

    public ExpressionCalculator(double a, double c, double x) {
        this.a = a;
        this.c = c;
        this.x = x;
    }

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    public double getC() { return c; }
    public void setC(double c) { this.c = c; }
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double calculate() {
        double radicand = Math.exp(x) - Math.pow(Math.cos(x * x * Math.pow(a, 5)), 4);
        double denominatorBase = a + x * Math.pow(c, 4);
        if (radicand < 0 || denominatorBase == 0) {
            throw new IllegalArgumentException("Значення не належать області визначення виразу.");
        }
        double numerator = Math.sqrt(radicand) + Math.pow(Math.atan(a - Math.pow(x, 5)), 4);
        return numerator / Math.pow(Math.abs(denominatorBase), 1.0 / Math.E);
    }

    public static double calculate(double a, double c, double x) {
        return new ExpressionCalculator(a, c, x).calculate();
    }
}