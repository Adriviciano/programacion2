package practica1;
import java.util.Scanner;

public class Ejercicio6 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Introduce un número entero: ");
      int n1 = sc.nextInt();
      int max_divisores = 1;
      int mayor_numero = 1;

      while (n1 > 0){
         //saber los divisores de un numero
         int i = n1;
         int cont = 0;

         while (i > 0) {
            if (n1 % i == 0){
               cont += 1;
            }
            i -= 1;
         }
         if (cont > max_divisores){
            max_divisores = cont;
            mayor_numero = n1;
         }
         cont = 0;
         n1 -= 1;
      }
      
      System.out.println("El número con más divisores es " + mayor_numero + " (" + max_divisores + " divisores)");
      sc.close();

   }
}