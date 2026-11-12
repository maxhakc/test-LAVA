import java.util.Scanner;

public class LB1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = 1.5;
        double c = 0.5;

        System.out.print("x = ");
        double x = scan.nextDouble();

        double V = Math.sqrt(Math.exp(x) - Math.pow(Math.cos(x * x * Math.pow(a, 5)), 4)) + 
                   Math.pow(Math.atan(a - Math.pow(x, 5)), 4);
        
        double N = Math.pow(Math.abs(a + x * Math.pow(c, 4)), 1.0 / Math.E);

        double L = V / N;

        System.out.println("L = " + L);
    }
}