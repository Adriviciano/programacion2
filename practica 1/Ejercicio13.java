public class Ejercicio13 {
   public static String obtenerPalabra(String cad, int num){
      String palabra = "";
      if (num < 1 || num >= Ejercicio12.contarPalabras(cad)){
         return null;
      }

      int posicion = 1;
      String espacio = " ";
      for (int i = 0; i<cad.length(); i++) {
         if (cad.charAt(i) == espacio.charAt(0)){
            posicion += 1;
         }
         if (posicion == num){
            int j = i + 1;
            while (cad.charAt(j) != espacio.charAt(0)){

               j += 1;
            }
            return palabra;
         }
      }
      return palabra; 
   }

   public static void main(String[] args) {
      System.out.println(obtenerPalabra("Uno dos tres cuatro cinco seis siete ocho nueve", 7) + " = 8?");
      System.out.println(obtenerPalabra("Uno dos tres cuatro cinco seis siete ocho nueve", 2) + " = 3?");
      System.out.println(obtenerPalabra("Uno dos tres cuatro cinco seis siete ocho nueve", -1) + " = null?");
      System.out.println(obtenerPalabra("Uno dos tres cuatro cinco seis siete ocho nueve", 9) + " = null?");
   }
}