package practica2;
import java.util.Locale;

/* Implementa en lenguaje Java una clase Punto que permita representar puntos formados por dos coordenadas x e y. Ambas se deben guardar en atributos privados de tipo double. La especicación de la clase
requiere que tenga los siguientes constructores y métodos públicos:
1. Un constructor Punto(double x, double y) que permita crear un nuevo punto dándole sus coordenadas.
2. Un constructor sin parámetros Punto() que permita crear un nuevo punto con coordenadas (0, 0).
3. Un método double getX() que devuelva la coordenada x del punto.
4. Un método double getY() que devuelva la coordenada y del punto.
5. Un método Punto desplazar(double desplazamientoX, double desplazamientoY) que devuelva el
nuevo punto obtenido al sumarle al punto los desplazamientos que se le pasen como parámetros. Ten
en cuenta que la llamada p.desplazar(a, b) no debe modificar p.
6. Un método double distancia(Punto otroPunto) que permita calcular la distancia entre el punto y
otro punto que se le pase como parámetro.
Recuerda que la distancia entre (x1, y1) y (x2, y2) es p
(x2 − x1)
2 + (y2 − y1)
2. Para calcularla puedes
utilizar Math.sqrt y Math.pow.
7. Un método String toString() que permita obtener una cadena formada por las coordenadas del
punto, encerradas entre paréntesis y separadas por una coma y un blanco. Por ejemplo, para el punto
de coordenadas 3,5 y 2,45 se devolvería la cadena "(3.50, 2.45)"
(Fíjate en que usamos un punto como separador de la parte entera y de la parte decimal de los números, para evitar confundir
la coma decimal con la coma que separa la x de la y. Además, los números se muestran con solo dos decimales. Para conseguir
todo ello, puedes devolver la cadena String.format(Locale.US, "( %.2f, %.2f)", x, y).)

8. Un método boolean equals(Object otroObjeto) que devuelva true si el punto tiene las mismas
coordenadas que otro que se le pase como parámetro y false en caso contrario.

*/
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