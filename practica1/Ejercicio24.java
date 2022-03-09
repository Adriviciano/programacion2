package practica1;
import java.io.FileNotFoundException;

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
   public static void main(String[] args) throws FileNotFoundException {
      String[] nombresEquipos = {"Athletic_Club_de_Bilbao", "CA_Osasuna", 
                           "CD_Alavés", "Club_Atlético_de_Madrid", 
                           "Cádiz_CF", "Elche_CF", "FC_Barcelona", 
                           "Getafe_CF", "Granada_CF", "Levante_UD", 
                           "RCD_Espanyol", "RCD_Mallorca", "RC_Celta", 
                           "Rayo_Vallecano", "Real_Betis_Balompié", 
                           "Real_Madrid_CF", "Real_Sociedad_de_Fútbol", 
                           "Sevilla_FC", "Valencia_CF", "Villarreal_CF"};

      System.out.println(sinDerrotasEnCasa(Ejercicio23.crearMatrizResultados(nombresEquipos, "liga21-22-jornada25-sin-aplazados.txt")));
   }
}