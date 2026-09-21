import java.util.InputMismatchException;
import java.util.Scanner;

public class LB3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = 1.5;
        double c = 0.5;

        try {
            System.out.print("x = ");
            double x = scan.nextDouble();

            // Формули ОДЗ
            double N_Sqrt = Math.exp(x) - Math.pow(Math.cos(x * x * Math.pow(a, 5)), 4);
            double ZNM = a + x * Math.pow(c, 4);

            if (N_Sqrt < 0) {
                System.out.println("підкореневий вираз < 0");
            } else if (ZNM == 0) {
                System.out.println("ділення на нуль");
            } else {
                double V = Math.sqrt(N_Sqrt) + Math.pow(Math.atan(a - Math.pow(x, 5)), 4);
                double N = Math.pow(Math.abs(ZNM), 1.0 / Math.E);
                double L = V / N;

                System.out.println("L = " + L);
            }
        } catch (InputMismatchException e) {
            System.out.println("Помилка треба ввести число");
        } finally {
            scan.close();
        }
    }
}