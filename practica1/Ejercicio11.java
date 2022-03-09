package practica1;
public class Ejercicio11 {
   public static boolean esSufijo(String cad1, String cad2){
      String posibleSufijo = cad2;
      String posiblePalabra = cad1;
      /*
      if (cad1.length() < cad2.length()){
         posibleSufijo = cad1;
         posiblePalabra = cad2;
      }
      */
      if (posiblePalabra.length() == 0){
         return false;
      }
      else if(posibleSufijo.length() == 0){
         return true;
      }
      int x=posiblePalabra.length();
      for (int i = 0; i < x; i++){
         if (posiblePalabra.charAt(i) == posibleSufijo.charAt(0)){
            int cont=1;
            while (cont < posibleSufijo.length()){
               if (posiblePalabra.charAt(i+cont) != posibleSufijo.charAt(0+cont)){
                  return false;
               }
               cont += 1;
            }
            return true;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      prueba("hola", "ola", true);
      prueba("hola", "osa", false);
      prueba("hola", "hola", true);
      prueba("hola", "", true);
   }

   private static void prueba(String s1, String s2, boolean esperado) {
      boolean resultado = esSufijo(s1, s2);
      System.out.format("Prueba con %s y %s: ", s1, s2);
      if (resultado == esperado)
      System.out.println("ok");
      else
      System.out.println("error");
      }

}