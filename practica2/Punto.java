package practica2;
public class Punto{

   private double x;
   private double y;

   public Punto(double x, double y){
      this.x = x;
      this.y = y;
   }

   public Punto(){
      this(0, 0);
   }

   public double getX(){
      return x;
   }

   public double getY(){
      return y;
   }

   public Punto desplazar(double desplazamientoX, double desplazamientoY){
      double puntoX = x + desplazamientoX;
      double puntoY = y + desplazamientoY;
      Punto a = new Punto(puntoX, puntoY);
      return a;
   }

   public double distancia(Punto otroPunto){
      return Math.sqrt(Math.pow((otroPunto.getX() - x), 2) + Math.pow((otroPunto.getY() - y), 2));
   }

   public String toString(){
      return "(" + x + ", " + y + ")";
   }

   public boolean equals(Object otroObjeto){
      if (this == otroObjeto){
         return true;
      }
      if(!(otroObjeto instanceof Punto)){
         return false;
      }
      Punto otroPunto = (Punto) otroObjeto;
      return x == otroPunto.getX() && y == otroPunto.getY();
   }
}