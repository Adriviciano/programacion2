import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Partidos {

   public static char[][] crearMatrizResultados(String[] vector, String fichero) throws FileNotFoundException{
      int n = vector.length;
      char[][] matriz = new char[n][n];
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            matriz[i][j] = '-';
         }
      }

      int locales = 0;
      int visitantes = 0;

      String [] partido = new String[4];

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
         }
         for (int x = 0; x < vector.length; x++){
            if(vector[x].equals(partido[2])){
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

   public static String obtenerLíder(String[] vector, char[][] matriz){

      //vector para ordenar las puntuaciones en casa
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
         }
         puntuaciones[i] = puntos;
      }

      //ordenar las puntuaciones fuera de casa
      int indice = 0;
      for(int i=0; i<matriz.length; i++){
         int puntos = 0;
         for(int j=0; j<matriz[i].length; j++){
            if (matriz[j][indice] == '2'){
               puntos += 3;
            }
            else if (matriz[j][indice] == 'X'){
               puntos += 1;
            }
         }
         puntuaciones[indice] += puntos;
         indice += 1;
      }

      int maximo = 0;
      int maxvalor = 0;
      for(int x=0; x<puntuaciones.length; x++){
         if (puntuaciones[x] > maxvalor){
            maxvalor = puntuaciones[x];
            maximo = x;
         }
      }
      return vector[maximo];
   }
   public static void imprimirMatriz(char[][] matriz){
      for(int i=0; i < matriz.length; i++){
         for(int j=0;j<matriz[i].length; j++){
            System.out.print(matriz[i][j] + " ");
         }
         System.out.println("");
      }
   }

   public static void main(String[] args) throws FileNotFoundException{
      String[] nombresEquipos = {"Athletic_Club_de_Bilbao", "CA_Osasuna", 
                           "CD_Alavés", "Club_Atlético_de_Madrid", 
                           "Cádiz_CF", "Elche_CF", "FC_Barcelona", 
                           "Getafe_CF", "Granada_CF", "Levante_UD", 
                           "RCD_Espanyol", "RCD_Mallorca", "RC_Celta", 
                           "Rayo_Vallecano", "Real_Betis_Balompié", 
                           "Real_Madrid_CF", "Real_Sociedad_de_Fútbol", 
                           "Sevilla_FC", "Valencia_CF", "Villarreal_CF"};

      imprimirMatriz(crearMatrizResultados(nombresEquipos, "liga21-22-jornada25-sin-aplazados.txt"));
      System.out.println(sinDerrotasEnCasa(crearMatrizResultados(nombresEquipos, "liga21-22-jornada25-sin-aplazados.txt")));
      System.out.println(obtenerLíder(nombresEquipos, crearMatrizResultados(nombresEquipos, "liga21-22-jornada25-sin-aplazados.txt")));
      
   }
}