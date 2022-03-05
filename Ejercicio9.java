import java.util.Scanner;

public class Ejercicio9 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // Leer un número entero (de tipo int)
      System.out.print("Introduce un número entero: ");
      int n1 = sc.nextInt();
      int mult = 1;
      int j = n1;

      while (j > 0) {
         if (Ejercicio7.esPrimo(j) == true){
            mult *= j;
         }
         j -= 1;
      }

      System.out.println(n1 + "# = " + mult);
      sc.close();
   }
}