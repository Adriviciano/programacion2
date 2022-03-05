import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Ejercicio23 {
   public static char[][] crearMatrizResultados(String[] vector, String fichero) throws FileNotFoundException{
      int n = vector.length;
      char[][] matriz = new char[n][n];
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            matriz[i][j] = '-';
         }
      }
      int locales;
      int visitantes;
      Scanner entrada = new Scanner(new File(fichero)); 
      while(entrada.hasNextLine()) { 
         String linea = entrada.nextLine();
         String [] partido = new String[4];
         int inicio = 0;
         int fin = 0;
         for (int y = 0; y < 4; y++){
            while (linea.charAt(fin) != ' '){
               fin += 1;
            }
            partido[y] = linea.substring(inicio, fin);
            inicio = fin + 1;
            fin = inicio;
         }
         for (int x = 0; x < vector.length; x++){
            if(vector[x] == partido[0]){
               locales = x;
            }
            else if(vector[x] == partido[2]){
               visitantes = x;
            }
         }
         if (Integer.parseInt(partido[1]) > Integer.parseInt(partido[3])){
            matriz[locales][visitantes] = '1';
         }
         else if(Integer.parseInt(partido[1]) < Integer.parseInt(partido[3])){
            matriz[locales][visitantes] = '2';
         }
         else{
            matriz[locales][visitantes] = 'X';
         }
      } 
      entrada.close();
      return matriz;
   }
}
