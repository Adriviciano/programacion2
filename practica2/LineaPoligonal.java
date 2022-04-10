/*
Implementa en lenguaje Java una clase LineaPoligonal que permita representar líneas poligonales. Una
línea poligonal está formada por un conjunto de cero o más segmentos de modo que el extremo final de cada
segmento coincide con el extremo inicial del siguiente.
Podemos representar una línea poligonal mediante un vector de puntos. Por ejemplo, un vector que
contenga los puntos (2, 3), (4, 5), (6, 7) y (8, 9), en ese orden, representa una línea poligonal formada por tres
segmentos en la que el primer segmento va del punto (2, 3) al punto (4, 5), el segundo segmento va del (4, 5)
al (6, 7) y el tercer segmento va del (6, 7) al (8, 9).
Para mejorar la eficiencia de las operaciones que añaden y quitan puntos, utilizaremos otro atributo
que indique la cantidad de puntos de la línea. De esta manera distinguiremos entre la talla o capacidad del
vector (la cantidad máxima de puntos que puede almacenar) y la ocupación del vector indicada por el nuevo
atributo (la cantidad de puntos válidos que realmente contiene). Si el valor de este nuevo atributo es n > 1,
representará una línea poligonal formada por n−1 segmentos cuyos extremos son los puntos almacenados en
las n primeras posiciones del vector, de talla m ≥ n. Si el valor del nuevo atributo es cero o uno no tenemos
ningún segmento, pero consideraremos que se trata de una línea poligonal válida de longitud cero.
La especificación de la clase requiere que tenga los siguientes constructores y métodos públicos:
1. Un constructor sin parámetros LineaPoligonal() que permita crear una nueva línea poligonal que
inicialmente estará vacía. Para ello, debe crear un vector de puntos de una determinada talla inicial
(es habitual emplear un valor 8 o 10) que represente una línea sin puntos.
2. Un método void añadir(Punto punto) que permita extender la línea poligonal añadiéndole al final
el punto dado como parámetro.
El método debe redimensionar el vector de puntos únicamente cuando sea necesario (es decir, cuando
su talla m coincida con el número de puntos n), de modo que su nueva talla sea el doble de la anterior.
Si en el vector hay espacio disponible para un nuevo punto, este simplemente se añadirá al final.
© Universitat Jaume I 2021-2022
6 Programación II
3. Un método void quitar(int posición) que permita reducir la línea poligonal quitándole el punto
que ocupa la posición dada como parámetro, contando desde cero inclusive. La línea no debe cambiar
si la posición es menor que cero o mayor o igual que la cantidad de puntos.
El método debe suprimir el punto correspondiente sin disminuir nunca la talla del vector6 ni hacer uso
de ningún otro vector auxiliar.
4. Un método void quitar(Punto punto) que permita reducir la línea poligonal quitándole el punto
dado como parámetro. Para ello, debes llamar al método anterior. Si el punto aparece varias veces en
la línea, sólo se debe quitar su primera aparición. La línea no debe cambiar si no contiene el punto
dado.
5. Un método void trasladar(double desplazamientoX, double desplazamientoY) que permita modificar la línea poligonal desplazando cada uno de sus puntos.
6. Un método double longitud() que devuelva la longitud de la línea poligonal. Si la línea tiene cero
puntos o un punto, su longitud es cero. Si tiene dos o más puntos, su longitud es la suma de las
longitudes de los segmentos que la forman. La longitud de cada segmento es la distancia entre sus dos
puntos extremos.
7. Un método String toString() que permita obtener una representación de la línea poligonal en forma
de cadena. En dicha representación aparecen representados todos los puntos separados por --. La representación de cada punto es la propia de la clase Punto. Por ejemplo, la cadena (2.00, 3.00)--(4.00,
5.00)--(6.00, 7.00)--(8.00, 9.00) representa la línea poligonal definida por esos cuatro puntos
como extremos de sus tres segmentos. Los casos especiales en que tenemos cero puntos o un punto se
representan mediante la cadena vacía o mediante la cadena que representa un punto, respectivamente.
8. Un método boolean equals(Object otroObjeto) que devuelva true si la línea tiene los mismos
puntos y en el mismo orden que otra que reciba como parámetro y false en caso contrario. Si dos
líneas contienen los mismos puntos, pero en orden inverso, consideraremos que son diferentes.
*/
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
    
