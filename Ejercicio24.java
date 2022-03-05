public class Ejercicio24 {
   public static int sinDerrotasEnCasa(char[][] matriz){
      int invictos = 0;
      for(int i=0; i<matriz.length; i++){
         int derrotas = 0;
         for(int j=0; j<matriz[i].length; j++){
            if (matriz[i][j] == '2'){
               derrotas += 1;
            }
         }
         if (derrotas == 0){
            invictos += 1;
         }
      }
      return invictos;
   }
}