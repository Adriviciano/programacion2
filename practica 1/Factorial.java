import java.util.Scanner;

public class Factorial {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // Leer un número entero (de tipo int)
      System.out.print("Introduce un número entero: ");
      int n1 = sc.nextInt();

      int fact = 1;
      for (int i = 1; i <= n1; i++){
         fact *= i;
      }

      System.out.println(n1 + "! = " + fact);

      sc.close();
   }
}