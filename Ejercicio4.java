import java.util.* ;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer un número entero (de tipo int)
        System.out.print("Introduce un número entero: ");
        int n1 = sc.nextInt();
        String lista = "";
        int j = n1 - 1;

        while (j > 0) {

            int cont = 0;

            int i = j;

            while (i > 0) {
                if (j % i == 0) {
                    cont += 1;
                }
                i -= 1;
            }
            if (cont == 2){
                lista = j + " " + lista;
            }
            j -= 1;
        }

        System.out.println("Los números primos menores que " + n1 + " son: " + lista);
        sc.close();
    }
}
