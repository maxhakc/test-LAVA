import java.util.InputMismatchException;
import java.util.Scanner;

public class LB4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("a: ");
            double a = scan.nextDouble();

            System.out.print("c: ");
            double c = scan.nextDouble();

            int n = 1;
            double xStart = -10.0 - 2.5 * n;
            double xEnd = 5.0 + 1.2 * n;     
            double dx = 0.5 + n / 20.0;      

            // FOR
            System.out.println("\nFOR:");
            for (double x = xStart; x <= xEnd + 1e-9; x += dx) {
                double nSqrt = Math.exp(x) - Math.pow(Math.cos(x * x * Math.pow(a, 5)), 4);
                double znm = a + x * Math.pow(c, 4);

                if (nSqrt < 0) {
                    System.out.printf("x = %6.2f | ОДЗ: підкореневий вираз < 0%n", x);
                    continue;
                }

                if (Math.abs(znm) < 1e-9) {
                    System.out.printf("x = %6.2f | ОДЗ: ділення на нуль%n", x);
                    continue; 
                }

                double v = Math.sqrt(nSqrt) + Math.pow(Math.atan(a - Math.pow(x, 5)), 4);
                double denom = Math.pow(Math.abs(znm), 1.0 / Math.E);
                double l = v / denom;

                System.out.printf("x = %6.2f | L = %f%n", x, l);
            }


            // WHILE
            System.out.println("\nWHILE");
            double x = xStart;
            while (x <= xEnd + 1e-9) {
                double nSqrt = Math.exp(x) - Math.pow(Math.cos(x * x * Math.pow(a, 5)), 4);
                double znm = a + x * Math.pow(c, 4);

                if (nSqrt < 0) {
                    System.out.printf("x = %6.2f | ОДЗ: підкореневий вираз < 0%n", x);
                    x += dx; 
                    continue; 
                }

                if (Math.abs(znm) < 1e-9) {
                    System.out.printf("x = %6.2f | ОДЗ: ділення на нуль%n", x);
                    x += dx;  
                    continue;
                }

                double v = Math.sqrt(nSqrt) + Math.pow(Math.atan(a - Math.pow(x, 5)), 4);
                double denom = Math.pow(Math.abs(znm), 1.0 / Math.E);
                double l = v / denom;

                System.out.printf("x = %6.2f | L = %f%n", x, l);

                x += dx;
            }

        } catch (InputMismatchException e) {
            System.out.println("треба ввести число");
        } finally {
            scan.close();
        }
    }
}