package practica2; // Indica aquí el nombre del paquete que utilizas.

// Para que este programa de prueba funcione correctamente es importante:
//   1. Que el método toString() de la clase LineaPoligonal use el formato indicado
//      en el enunciado del ejercicio 10.
//   2. Que el método toString() de la clase Punto use el formato indicado en el
//      enunciado del ejercicio 1.


public class LineaPoligonalPruebas01 {
/*
    public static void main(String[] args) {
        System.out.println("Comprobamos el constructor de LineaPoligonal...");
        LineaPoligonal miLinea = new LineaPoligonal();
        verificaResultado(miLinea, "", 0);

        Punto p = new Punto(1, 1);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(1.00, 1.00)", 0);

        System.out.println("Quitamos el punto " + p + "...");
        miLinea.quitar(p);
        verificaResultado(miLinea, "", 0);

        p = new Punto(0, 0);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)", 0);

        p = new Punto(10, 0);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)--(10.00, 0.00)", 10);

        p = new Punto(0, 10);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)--(10.00, 0.00)--(0.00, 10.00)",
                24.14213562373095);

        p = new Punto(0, 0);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea,
                "(0.00, 0.00)--(10.00, 0.00)--(0.00, 10.00)--(0.00, 0.00)",
                34.14213562373095);

        System.out.println("Trasladamos 100 unidades en X y 100 en Y...");
        miLinea.trasladar(100, 100);
        verificaResultado(miLinea,
                "(100.00, 100.00)--(110.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                34.14213562373095);

        System.out.println("Quitamos el segundo punto...");
        miLinea.quitar(1);
        verificaResultado(miLinea, "(100.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                20.0);

        System.out.println("Quitamos el punto de la posición 8 (que no existe)...");
        miLinea.quitar(8);
        verificaResultado(miLinea, "(100.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                20.0);

        p = new Punto(12, 34);
        System.out.println("Quitamos el punto " + p + " (que no existe)...");
        miLinea.quitar(p);
        verificaResultado(miLinea, "(100.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                20.0);

        p = new Punto(100, 100);
        System.out.println("Quitamos el punto " + p + "...");
        miLinea.quitar(p);
        verificaResultado(miLinea, "(100.00, 110.00)--(100.00, 100.00)", 10.0);

        p = new Punto(200, 200);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        System.out.println(
                "Y lo trasladamos (solo el punto) un desplazamiento de -100 en X y -100 en Y...");
        p = p.desplazar(-100, -100);
        verificaResultado(miLinea, "(100.00, 110.00)--(100.00, 100.00)--(200.00, 200.00)",
                151.4213562373095);

        System.out.println("Comparamos consigo mismo");
        boolean sonIguales = miLinea.equals(miLinea);
        if (sonIguales) {
            System.out.println("  --> BIEN");
        } else {
            System.out.println("  --> MAL: Debería ser true");
        }

        System.out.println();
        System.out.println("Comparamos con otra linea poligonal diferente");
        LineaPoligonal otraLinea = new LineaPoligonal();
        otraLinea.añadir(new Punto(100, 110));
        otraLinea.añadir(new Punto(110, 110));
        otraLinea.añadir(new Punto(200, 200));
        sonIguales = miLinea.equals(otraLinea);
        if (sonIguales) {
            System.out.println("  --> MAL: Debería ser false");
        } else {
            System.out.println("  --> BIEN");
        }

        System.out.println();
        System.out.println("Comparamos con otra linea poligonal creada con objetos Punto "
                + "diferentes, pero que contienen los mismos valores en X e Y");
        LineaPoligonal otraIgual = new LineaPoligonal();
        otraIgual.añadir(new Punto(100, 110));
        otraIgual.añadir(new Punto(100, 100));
        otraIgual.añadir(new Punto(200, 200));
        sonIguales = miLinea.equals(otraIgual);
        if (sonIguales) {
            System.out.println("  --> BIEN");
        } else {
            System.out.println("  --> MAL: Debería ser true");
        }
    }


    public static void verificaResultado(LineaPoligonal l, String resultadoCorrecto,
            double longitudCorrecta) {

        String miResultado = l.toString();
        double miLongitud = l.longitud();

        System.out.println("  linea poligonal = " + miResultado);
        System.out.println("  con longitud = " + miLongitud);

        if (miResultado.equals(resultadoCorrecto)
                && Math.abs(miLongitud - longitudCorrecta) < 1E-6) {
            System.out.println("  --> BIEN");
        } else {
            System.out.println("  --> MAL: Debería ser  " + resultadoCorrecto
                    + " con longitud " + longitudCorrecta);
        }
        System.out.println();
    }
*/
}
