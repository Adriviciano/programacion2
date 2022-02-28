import java.util.Scanner;

public class MasDivisores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer un número entero (de tipo int)
        System.out.print("Introduce un número entero: ");
        int n1 = sc.nextInt();
        int maxDivisores = 2;
        int numero = 2;

        int j = n1 - 1;

        while (j > 96) {

            System.out.println(j);
            int i = j;

            int cont = 0;
            while (i > 0) {
                if (n1 % i == 0) {
                    cont += 1;
                }
                i -= 1;
            }
            System.out.println(cont);
            if (cont > maxDivisores) {
                maxDivisores = cont;
                System.out.println(maxDivisores);
                numero = j;
                System.out.println(numero);
            }
            j-=1;
        }
        System.out.println("El número con más divisores es " + numero + "(" + maxDivisores + " divisores)");
        sc.close();
    }
}

