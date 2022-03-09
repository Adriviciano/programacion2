package practica1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Ejercicio23 {
   public static char[][] crearMatrizResultados(String[] vector, String fichero) throws FileNotFoundException{
      
      
      //crear la matriz y llenarla de '-'
      int n = vector.length;
      char[][] matriz = new char[n][n];
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            matriz[i][j] = '-';
         }
      }

      //inicializar las variables local y visitante
      int locales = 0;
      int visitantes = 0;

      String [] partido = new String[4];

      //lectura del fichero
      Scanner entrada = new Scanner(new File(fichero), "UTF-8"); 
      while(entrada.hasNextLine()) { 
         String linea = entrada.nextLine() + " ";
         int inicio = 0;
         int fin = 0;

         //bucle para dividir la linea en un array de 4 strings
         for (int y = 0; fin < linea.length(); y++){
            while (linea.charAt(fin) != ' '){
               fin += 1;
            }
            partido[y] = linea.substring(inicio, fin);
            inicio = fin + 1;
            fin = inicio;
         }

         //bucle para buscar el local y el visitante
         for (int x = 0; x < vector.length; x++){
            if(vector[x].equals(partido[0])){
               locales = x;
            }
            else if(vector[x].equals(partido[2])){

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
   public static void imprimirMatriz(char[][] matriz){
      for(int i=0; i < matriz.length; i++){
         for(int j=0;j<matriz[i].length; j++){
            System.out.print(matriz[i][j] + " ");
         }
         System.out.println("");
      }
   }

   public static void main(String[] args) throws FileNotFoundException {
      String[] nombresEquipos = {"Athletic_Club_de_Bilbao", "CA_Osasuna", 
      "CD_Alavés", "Club_Atlético_de_Madrid", 
      "Cádiz_CF", "Elche_CF", "FC_Barcelona", 
      "Getafe_CF", "Granada_CF", "Levante_UD", 
      "RCD_Espanyol", "RCD_Mallorca", "RC_Celta", 
      "Rayo_Vallecano", "Real_Betis_Balompié", 
      "Real_Madrid_CF", "Real_Sociedad_de_Fútbol", 
      "Sevilla_FC", "Valencia_CF", "Villarreal_CF"};

      imprimirMatriz(crearMatrizResultados(nombresEquipos, "liga21-22-jornada25-sin-aplazados.txt"));
   }
}
