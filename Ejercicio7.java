import java.util.Scanner;

public class Ejercicio7 {

   public static boolean esPrimo(int num){
      int cont = 0;

      int i = num;
      
      while (i > 0){
            if (num % i == 0){
               cont += 1;
            }
            i-=1;
      }
      if (cont <=2){
         return true;
      }
      else{
         return false;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Introduce un número entero: ");
      int n1 = sc.nextInt();

      if (esPrimo(n1) == true){
         System.out.println("Es primo");
      }
      else{
         System.out.println("No es primo");
      }

      sc.close();
   }
}