package practica3;

import java.util.Locale;


public class LineaPoligonal {
   private ArrayList<Punto> puntos;
   private int talla;
   private int ocupacion;
    
   public LineaPoligonal(){
        talla = 8;
        ocupacion = 0;
   }
    
   public void añadir(Punto punto){
      puntos.add(punto);
      if (ocupacion == talla){
         talla ++;
      }
      ocupacion++;
   }
    
   public void quitar(int posicion){
      puntos.remove(posicion);
   }
    
   public void quitar(Punto punto){
      int i=0;
      while (puntos[i] != null){
         if puntos[i] == punto){
            puntos.remove(i);
         }
         i++;
      }
   }
    
   public void trasladar(double desplazamientoX, double desplazamientoY){
      int i=0;
      while (puntos[i] != null){
         puntos[i] = puntos[i].desplazar(desplazamientoX, desplazamientoY);
         i++;
      }
   }
    
   public double longitud(){
      double longitud = 0;
      int i=0;
      while (puntos[i+1] != null){
         longitud += puntos[i].distancia(puntos[i + 1]);
         i++;
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