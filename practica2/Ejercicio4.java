package practica2;

public class Ejercicio4 {
   
   public static Restaurante restauranteMejorValorado(Restaurante[] v, Punto p, double d){

      int mejorValoracion = 0;
      int posicion = 0;
      int cont = 0;

      for(int i=0; i<v.length; i++){
         if(p.distancia(v[i].getPosición()) <= d){
            cont += 1;
            if(v[i].getValoración() > mejorValoracion){
               mejorValoracion = v[i].getValoración();
               posicion = i;
            }
         }
      }

      if(cont == 0){
         return null;
      }
      else{
         return v[posicion];
      }
   }
}
