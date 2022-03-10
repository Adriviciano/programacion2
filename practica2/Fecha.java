package practica2;

public class Fecha {

   private int dia;
   private int mes;
   private int año;

   public Fecha(int dia, int mes, int año) {
      this.dia = dia;
      this.mes =mes;
      this.año = año;
   }

   public Fecha(Fecha otraFecha){
      otraFecha = (Fecha) otraFecha;
   }

   public String toString(){
      return dia + "/" + mes + "/" + año;
   }

   public boolean equals(Object otroObjeto){
      if(!(otroObjeto instanceof Punto)){
         return false;
      }
      return this == otroObjeto;
   }

   
}
