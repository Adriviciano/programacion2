package practica1;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer un número entero (de tipo int)
        System.out.print("Introduce un número entero: ");
        int n1 = sc.nextInt();
        int cont = 0;

        int i = n1;
        
        while (i > 0){
            if (n1 % i == 0){
                cont += 1;
            }
            i-=1;
        }

        if (cont <= 2){
            System.out.println("Es primo");
        }
        else{
            System.out.println("No es primo");
        }

        sc.close();
    }
}
