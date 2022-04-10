package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

   public Punto getPosición(){
      return posicion;
   }

   public int getValoración(){
      return valoracion;
   }

   public double distancia(Punto p){
      return  Math.sqrt((Math.pow(posicion.getX() - p.getX(), 2)) + (Math.pow(posicion.getY() - p.getY(), 2)));
   }

   public static Restaurante[] leeRestaurantes(String nombreFichero) throws FileNotFoundException{
      Scanner entrada = new Scanner(new File(nombreFichero), "UTF-8");

      String linea = entrada.nextLine();
      int n = Character.getNumericValue(linea.charAt(0));

      Restaurante[] vector = new Restaurante[n];

      int cont = 0;

      while(entrada.hasNextLine()) { 
         double x = entrada.nextDouble();
         double y = entrada.nextDouble();
         int valoracion = entrada.nextInt();
         String nombre = entrada.next();

         Punto posicion = new Punto(x, y);
         Restaurante rest = new Restaurante(nombre, posicion, valoracion);
         vector[cont] = rest;
         cont += 1;
      }

      return vector;
   }
}