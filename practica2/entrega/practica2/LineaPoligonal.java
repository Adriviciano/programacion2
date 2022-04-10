package practica2;
import java.util.Locale;

public class LineaPoligonal {
   private Punto[] puntos;
   private int talla;
   private int ocupacion;
    
   public LineaPoligonal(){
        puntos = new Punto[8];
        talla = 8;
        ocupacion = 0;
   }
    
   public void añadir(Punto punto){
      if(ocupacion == talla){
         talla = talla * 2;
         Punto[] aux = new Punto[talla];
         for(int i = 0; i < ocupacion; i++){
               aux[i] = puntos[i];
         }
         puntos = aux;
      }
      puntos[ocupacion] = punto;
      ocupacion++;
   }
    
   public void quitar(int posicion){
      if(posicion < 0 || posicion >= ocupacion){
         return;
      }
      for(int i = posicion; i < ocupacion - 1; i++){
         puntos[i] = puntos[i + 1];
      }
      ocupacion--;
   }
    
   public void quitar(Punto punto){
      for(int i = 0; i < ocupacion; i++){
         if(puntos[i].equals(punto)){
            quitar(i);
            return;
         }
      }
   }
    
   public void trasladar(double desplazamientoX, double desplazamientoY){
      for(int i = 0; i < ocupacion; i++){
         puntos[i] = puntos[i].desplazar(desplazamientoX, desplazamientoY);
      }
   }
    
   public double longitud(){
      double longitud = 0;
      for(int i = 0; i < ocupacion - 1; i++){
         longitud += puntos[i].distancia(puntos[i + 1]);
      }
      return longitud;
   }

   public String toString(){
      String cadena = "";
      for(int i = 0; i < ocupacion; i++){
         if (i == 0){
            cadena += "(" + String.format(Locale.US, "%.2f", puntos[i].getX()) + ", " + String.format(Locale.US, "%.2f", puntos[i].getY()) + ")";
         }
         else{
            cadena += "--(" + String.format(Locale.US, "%.2f", puntos[i].getX()) + ", " + String.format(Locale.US, "%.2f", puntos[i].getY()) + ")";
         }
      }
      return cadena;
   }

   public boolean equals(Object otroObjeto){
      if(otroObjeto instanceof LineaPoligonal){
         LineaPoligonal otraLinea = (LineaPoligonal) otroObjeto;
         if(ocupacion != otraLinea.ocupacion){
            return false;
         }
         for(int i = 0; i < ocupacion; i++){
            if(!puntos[i].equals(otraLinea.puntos[i])){
               return false;
            }
         }
         return true;
      }
      return false;
   }
}