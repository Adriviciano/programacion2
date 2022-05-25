package practica3;  // Indica aquí el nombre del paquete que utilizas

import practica2.Punto; // Importa aquí la clase Punto

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestLineaPoligonal {

    private LineaPoligonal líneaInicial, líneaLarga;
    private String         representaciónLíneaLarga;
    private int            longitudInicialLíneaLarga;
    private Punto[]        puntosLíneaLarga;


    @Before
    public void setUp() throws Exception {
        líneaInicial = new LineaPoligonal();
        puntosLíneaLarga = new Punto[] { new Punto(1, 2), new Punto(3, 4),
                new Punto(5, 6), new Punto(7, 8), new Punto(5, 6) };
        líneaLarga = construyeLínea(puntosLíneaLarga);
        representaciónLíneaLarga = "(1.00, 2.00)--(3.00, 4.00)--(5.00, 6.00)--(7.00, 8.00)--(5.00, 6.00)";
        longitudInicialLíneaLarga = puntosLíneaLarga.length;
    }


    private LineaPoligonal construyeLínea(Punto[] puntos) {
        LineaPoligonal línea = new LineaPoligonal();
        for (Punto punto : puntos)
            línea.añadir(punto);
        return línea;
    }


    @Test
    public void líneaPoligonalVacía() {
        longitudBien(líneaInicial, 0, "en el constructor");
        representaciónBien(líneaInicial, "", "en el constructor");
    }


    @Test
    public void añadir() {
        líneaInicial.añadir(new Punto(4, 5));
        longitudBien(líneaInicial, 0, "al añadir un punto");
        representaciónBien(líneaInicial, "(4.00, 5.00)", "al añadir un punto");
        líneaInicial.añadir(new Punto(5, 5));
        longitudBien(líneaInicial, 1, "al añadir un punto");
        representaciónBien(líneaInicial, "(4.00, 5.00)--(5.00, 5.00)",
                "al añadir un punto");
        líneaInicial.añadir(new Punto(15, 5));
        longitudBien(líneaInicial, 11, "al añadir un punto");
        representaciónBien(líneaInicial, "(4.00, 5.00)--(5.00, 5.00)--(15.00, 5.00)",
                "al añadir un punto");
    }


    @Test
    public void quitarNegativoNoInfluye() {
        líneaLarga.quitar(-1);
        representaciónBien(líneaLarga, representaciónLíneaLarga,
                "al intentar quitar el elemento -1");
    }


    @Test
    public void quitarMuyGrandeNoInfluye() {
        líneaLarga.quitar(longitudInicialLíneaLarga);
        representaciónBien(líneaLarga, representaciónLíneaLarga,
                "al intentar quitar el elemento después del último");
    }


    @Test
    public void quitarElementoCero() {
        líneaLarga.quitar(0);
        String rep = eliminaEnRepresentación(representaciónLíneaLarga, 0);
        representaciónBien(líneaLarga, rep, "al intentar quitar el elemento cero");
    }


    @Test
    public void quitarÚltimoElemento() {
        líneaLarga.quitar(longitudInicialLíneaLarga - 1);
        String rep = eliminaEnRepresentación(representaciónLíneaLarga,
                longitudInicialLíneaLarga - 1);
        representaciónBien(líneaLarga, rep, "al intentar quitar el último elemento");
    }


    @Test
    public void quitarPunto() {
        líneaLarga.quitar(2);
        String rep = eliminaEnRepresentación(representaciónLíneaLarga, 2);
        representaciónBien(líneaLarga, rep, "al intentar quitar el segundo elemento");
    }


    @Test
    public void quitarPrimeraAparición() {
        líneaLarga.quitar(puntosLíneaLarga[2]);
        String rep = eliminaEnRepresentación(representaciónLíneaLarga, 2);
        representaciónBien(líneaLarga, rep, "al intentar quitar el segundo elemento");
    }


    // JL:
    @Test
    public void quitarPuntoQueNoExiste() {
        líneaLarga.quitar(new Punto(99999, 99999));
        String rep = representaciónLíneaLarga;
        representaciónBien(líneaLarga, rep, "al intentar quitar un punto que no existe");
    }


    @Test
    public void trasladar() {
        int desplazamientoX = 2, desplazamientoY = 4;
        Punto[] puntosTrasladados = new Punto[puntosLíneaLarga.length];
        for (int i = 0; i < puntosLíneaLarga.length; i++)
            puntosTrasladados[i] = puntosLíneaLarga[i].desplazar(desplazamientoX,
                    desplazamientoY);
        LineaPoligonal trasladada = construyeLínea(puntosTrasladados);
        líneaLarga.trasladar(desplazamientoX, desplazamientoY);
        assertEquals("Error al desplazar la línea", trasladada, líneaLarga);
    }


    @Test
    public void longitud() {
        double l = 0;
        assertEquals("La longitud de una línea vacía debe ser cero.",
                líneaInicial.longitud(), l, 1e-6);
        Punto punto = puntosLíneaLarga[0];
        líneaInicial.añadir(punto);
        assertEquals("La longitud de una línea de un punto debe ser cero.",
                líneaInicial.longitud(), l, 1e-6);
        for (int i = 1; i < puntosLíneaLarga.length; i++) {
            l += punto.distancia(puntosLíneaLarga[i]);
            punto = puntosLíneaLarga[i];
            líneaInicial.añadir(punto);
            assertEquals("Error en la longitud de la línea " + líneaInicial,
                    líneaInicial.longitud(), l, 1e-6);
        }
    }


    @Test
    public void testToString() {
        representaciónBien(líneaInicial, "", "vacía");
        líneaInicial.añadir(new Punto(2, 3));
        representaciónBien(líneaInicial, "(2.00, 3.00)", "con un punto");
        representaciónBien(líneaLarga, representaciónLíneaLarga,
                representaciónLíneaLarga);
    }


    @Test
    public void unaLíneaVacíaNoEsLarga() {
        assertNotEquals("La línea vacía y otra línea no son iguales", líneaInicial,
                líneaLarga);
    }


    @Test
    public void igualesCopia() {
        LineaPoligonal otraLínea = new LineaPoligonal();
        for (Punto punto : puntosLíneaLarga)
            otraLínea.añadir(punto);
        assertEquals("Estas líneas son iguales", líneaLarga, otraLínea);
    }


    @Test
    public void distintasOrdenInverso() {
        LineaPoligonal otraLínea = new LineaPoligonal();
        for (int i = puntosLíneaLarga.length - 1; i >= 0; i--)
            otraLínea.añadir(puntosLíneaLarga[i]);
        assertNotEquals("Estas líneas son distintas por el orden de los puntos",
                líneaLarga, otraLínea);
    }


    private void representaciónBien(LineaPoligonal línea, String esperado,
            String mensaje) {
        assertEquals("Error en la representación de la línea " + mensaje, esperado,
                línea.toString());
    }


    private void longitudBien(LineaPoligonal línea, double l, String mensaje) {
        assertEquals("Error en la longitud de la línea " + mensaje, l, línea.longitud(),
                1e-6);
    }


    private String eliminaEnRepresentación(String representación, int posición) {
        String[] partes = representación.split("--");
        StringBuilder r = new StringBuilder();
        String sep = "";
        for (int i = 0; i < partes.length; i++)
            if (i != posición) {
                r.append(sep);
                r.append(partes[i]);
                sep = "--";
            }
        return r.toString();
    }
}
