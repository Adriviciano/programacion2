package practica1;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer un número entero (de tipo int)
        System.out.print("Introduce un número entero: ");
        int n1 = sc.nextInt();
        int mult = 1;
        int j = n1;

        while (j > 0) {

            int cont = 0;

            int i = j;

            while (i > 0) {
                if (j % i == 0) {
                    cont += 1;
                }
                i -= 1;
            }
            if (cont == 2){
                mult *= j;
            }
            j -= 1;
        }

        System.out.println(n1 + "# = " + mult);
        sc.close();
    }
}