import java.util.Scanner;

public class DobleFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer un número entero (de tipo int)
        System.out.print("Introduce un número entero: ");
        int n1 = sc.nextInt();
        int fact = 1;

        switch (n1%2){
            case 0:
                for (int i = 2; i <= n1; i += 2){
                    fact *= i;
                }
                break;
            default:
                for (int i = 1; i <= n1; i += 2){
                    fact *= i;
                }
        }

        System.out.println(n1 + "!! = " + fact);

        sc.close();
    }
}