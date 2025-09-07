package psp.ud1_1_6.multiproceso.sumador;

import java.util.ArrayList;
import java.util.List;

public class DividirRango {

    /**
     * Metodo que divide el intervalo entre el numero de procesos
     * @param minimo
     * @param maximo
     * @param numRangos
     * @return
     */
    public List<Rango> dividir(int minimo , int maximo, int numRangos) {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }

    public static void main(String[] args) {
        DividirRango dividirRango = new DividirRango();
        List<Rango> rangos = dividirRango.dividir(5, 14, 3);
        for (Rango rango : rangos) {
            System.out.println(rango);
        }
    }

}
