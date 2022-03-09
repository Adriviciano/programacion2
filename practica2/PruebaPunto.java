package practica2;
public class PruebaPunto {
   public static void main(String[] args) {

      double x = 1.5;
      double y = 4;
      
      Punto A = new Punto(x, y);
      Punto B = new Punto(y, x);
      Punto C = new Punto(x, y);
   
      System.out.println(A.distancia(B));
      System.out.println(B.distancia(A));
   
      System.out.println(A.toString());
      System.out.println(B.toString());
   
      System.out.println(A.equals(B));
      System.out.println(A.equals(C));
   
   }
}
