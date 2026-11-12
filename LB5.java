import expression.ExpressionCalculator;

public class LB5 {
    public static void main(String[] args) {
        ExpressionCalculator defaultObject = new ExpressionCalculator();
        ExpressionCalculator parameterObject = new ExpressionCalculator(1.2, 0.8, 0.4);

        show("Конструктор за замовчуванням", defaultObject);
        show("Конструктор з параметрами", parameterObject);
    }

    private static void show(String title, ExpressionCalculator object) {
        System.out.println(title);
        System.out.printf("a = %.2f, c = %.2f, x = %.2f%n", object.getA(), object.getC(), object.getX());
        System.out.printf("Нестатичний метод: %.6f%n", object.calculate());
        System.out.printf("Статичний метод: %.6f%n", ExpressionCalculator.calculate(object.getA(), object.getC(), object.getX()));
    }
}