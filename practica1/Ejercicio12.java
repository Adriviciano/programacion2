package practica1;
public class Ejercicio12 {
   public static int contarPalabras(String cad) {

      String espacio = " ";
      int palabras = 1;
      for (int i = 0; i<cad.length(); i++) {
         if (cad.charAt(i) == espacio.charAt(0)){
            palabras += 1;
         }
      }
      return palabras;
   }

   public static void main(String[] args) {
      System.out.println(contarPalabras("Dos palabras") + " = 2?");
      System.out.println(contarPalabras("Ahora tres palabras") + " = 3?");
      System.out.println(contarPalabras("Ahora son tres palabras") + " = 4?");
      System.out.println(contarPalabras("esta cadena contiene cinco palabras") + " = 5?");
   }
}