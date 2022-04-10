package practica2;
import java.util.Calendar;

class Fecha{
   private int dia;
   private int mes;
   private int año;

   public Fecha(int dia, int mes, int año){
      this.dia = dia;
      this.mes = mes;
      this.año = año;
   }

   public Fecha(Fecha otraFecha){
      this.dia = otraFecha.dia;
      this.mes = otraFecha.mes;
      this.año = otraFecha.año;
   }

   public String toString(){
      return dia + "/" + mes + "/" + año;
   }

   public boolean equals(Object otroObjeto){
      if(otroObjeto instanceof Fecha){
         Fecha otraFecha = (Fecha)otroObjeto;
         return (this.dia == otraFecha.dia && this.mes == otraFecha.mes && this.año == otraFecha.año);
      }
      return false;
   }

   public int compareTo(Fecha otraFecha){
      if(this.año < otraFecha.año){
         return -1;
      }
      else if(this.año > otraFecha.año){
         return 1;
      }
      else{
         if(this.mes < otraFecha.mes){
            return -1;
         }
         else if(this.mes > otraFecha.mes){
            return 1;
         }
         else{
            if(this.dia < otraFecha.dia){
               return -1;
            }
            else if(this.dia > otraFecha.dia){
               return 1;
            }
         }
      }
      return 0;
   }

   public int getDía(){
      return dia;
   }
   
   public int getMes(){
      return mes;
   }

   public int getAño(){
      return año;
   }

   public static boolean añoBisiesto(int año){
      if(año % 4 == 0 && año % 100 != 0 || año % 400 == 0){
         return true;
      }
      return false;
   }

   public static int díasMes(int mes, int año){
      switch(mes){
         case 1:
         case 3:
         case 5:
         case 7:
         case 8:
         case 10:
         case 12:
            return 31;
         case 4:
         case 6:
         case 9:
         case 11:
            return 30;
         case 2:
            if(añoBisiesto(año)){
               return 29;
            }
            else{
               return 28;
            }
      }
      return 0;
   }

   public static Fecha hoy(){
      Calendar calendario = Calendar.getInstance();
      int dia = calendario.get(Calendar.DAY_OF_MONTH);
      int mes = calendario.get(Calendar.MONTH) + 1;
      int año = calendario.get(Calendar.YEAR);
      return new Fecha(dia, mes, año);
   }

   public Fecha díaSiguiente(){
      int dia = this.dia;
      int mes = this.mes;
      int año = this.año;
      if(dia < díasMes(mes, año)){
         dia++;
      }
      else{
         dia = 1;
         if(mes < 12){
            mes++;
         }
         else{
            mes = 1;
            año++;
         }
      }
      return new Fecha(dia, mes, año);
   }

}