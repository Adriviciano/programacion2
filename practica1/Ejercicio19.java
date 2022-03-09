package practica1;
import java.util.Arrays;

public class Ejercicio19 {
   public static int[] eliminarValor(int[] vector, int num) {
      int size = vector.length;
      for (int i = 0; i <vector.length; i++) {
         if (vector[i] == num) {
            size -= 1;
         }
      }
      int[] nuevo = new int[size];
      int cont = 0;
      for (int j = 0; j < vector.length; j++){
         if (vector[j] != num) {
            nuevo[j-cont] = vector[j];
         }
         else {
            cont += 1;
         }
      }
      return nuevo;
   }

   public static void main(String[] args) {
      int[] vector1={1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      System.out.println(Arrays.toString(eliminarValor(vector1, 7)));
      System.out.println(Arrays.toString(eliminarValor(vector1, 2)));
      System.out.println(Arrays.toString(eliminarValor(vector1, 5)));
      System.out.println(Arrays.toString(eliminarValor(vector1, 8)));
   }
}
