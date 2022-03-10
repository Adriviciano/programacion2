package practica2;

public class Restaurante {
   
   private String nombre;
   private Punto posicion;
   private int valoracion;

   public Restaurante(String nombre, Punto posicion, int valoracion){
      this.nombre = nombre;
      this.posicion = posicion;
      this.valoracion = valoracion;
   }

   public String getNombre(){
      return nombre;
   }

   public Punto getPosicion(){
      return posicion;
   }

   public int getValoracion(){
      return valoracion;
   }

   public double distancia(Punto p){
      return Math.sqrt(Math.pow((p.getX() - posicion.getX()), 2) + Math.pow((p.getY() - posicion.getY()), 2));
   }
/*
   public static Restaurante[] leeRestaurantes(String nombreFichero){

   }*/

}
