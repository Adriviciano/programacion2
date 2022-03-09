package practica1;
public class Ejercicio25 {
   public static String obtenerLíder(String[] vector, char[][] matriz){
      int[] puntuaciones = new int[vector.length];
      for(int i=0; i<matriz.length; i++){
         int puntos = 0;
         for(int j=0; j<matriz[i].length; j++){
            if (matriz[i][j] == '1'){
               puntos += 3;
            }
            else if (matriz[i][j] == 'X'){
               puntos += 1;
            }
            puntuaciones[j] = puntos;
         }
      }
      int maximo = 0;
      for(int x=0; x<puntuaciones.length; x++){
         if (puntuaciones[x] > maximo){
            maximo = puntuaciones[x];
         }
      }
      return vector[maximo];
   }

   
}