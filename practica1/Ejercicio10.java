package practica1;
import java.util.Scanner;
public class Ejercicio10 {
   public static int contarDivisores(int num){
      int cont = 0;
      int i = num;
      while (i > 0) {
         if (num % i == 0){
            cont += 1;
         }
         i -= 1;
      }
      return cont;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Introduce un número entero: ");
      int n1 = sc.nextInt();
      int max_divisores = 1;
      int mayor_numero = 1;

      while (n1 > 0){
         if (contarDivisores(n1) > max_divisores){
            max_divisores = contarDivisores(n1);
            mayor_numero = n1;
         }
         n1 -= 1;
      }
      
      System.out.println("El número con más divisores es " + mayor_numero + " (" + max_divisores + " divisores)");
      sc.close();
   }
}
