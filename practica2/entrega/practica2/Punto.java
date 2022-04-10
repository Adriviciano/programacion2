package practica2;
import java.util.Locale;

public class Punto{
   private double x;
   private double y;
   
   public Punto(double x, double y){
      this.x = x;
      this.y = y;
   }
   
   public Punto(){
      this.x = 0;
      this.y = 0;
   }
   
   public double getX(){
      return this.x;
   }
   
   public double getY(){
      return this.y;
   }
   
   public Punto desplazar(double desplazamientoX, double desplazamientoY){
      return new Punto(this.x + desplazamientoX, this.y + desplazamientoY);
   }
   
   public double distancia(Punto otroPunto){
      return Math.sqrt(Math.pow(this.x - otroPunto.getX(), 2) + Math.pow(this.y - otroPunto.getY(), 2));
   }
   
   public String toString(){
      return String.format(Locale.US, "(%.2f, %.2f)", this.x, this.y);
   }
   
   public boolean equals(Object otroObjeto){
      if(otroObjeto instanceof Punto){
         Punto otroPunto = (Punto) otroObjeto;
         return (this.x == otroPunto.getX() && this.y == otroPunto.getY());
      }
      return false;
   }
}