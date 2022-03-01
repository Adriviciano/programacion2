import java.util.Scanner;

public class Ejercicio8 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // Leer un número entero (de tipo int)
      System.out.print("Introduce un número entero: ");
      int n1 = sc.nextInt();
      String lista = "";
      int j = n1 - 1;

      while (j > 0) {
         if (Ejercicio7.esPrimo(j) == true){
            lista = j + " " + lista;
         }
         j -= 1;
      }

      System.out.println("Los números primos menores que " + n1 + " son: " + lista);
      sc.close();
   }
}