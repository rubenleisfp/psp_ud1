package psp.boletin.ud1.practica1;

import java.util.ArrayList;
import java.util.List;

public class Parsear {

    /**
     * Main para probar el parser con ejemplos reales de lineas obtenidas mediante tasklist
     * @param args
     */
    public static void main(String[] args) {
        String linea1 = "csrss.exe                      512 Services                   0     2.260 KB";
        String linea2 = "svchost.exe                    804 Services                   0    12.060 KB";
        List<String> lineas = new ArrayList<>();
        lineas.add(linea1);
        lineas.add(linea2);

        List<Proceso> procesos= parsearLineas(lineas);
        double sumatorio = 0;
        for (Proceso p : procesos) {
            sumatorio = sumatorio + p.getUsoMemoria();
            System.out.println(p);
        }
        System.out.println("Sumatorio " + sumatorio);
    }

    /**
     * Recibe una lista de lineas y las convierte en una lista de procesos
     * @param lineas que obtenemos del sistema con la descripcion de los procesos
     * @return
     */
    public static List<Proceso> parsearLineas(List<String> lineas) {
        List<Proceso> procesos = new ArrayList<>();
        for (String linea: lineas) {
            Proceso proceso =parsearLinea(linea);
            procesos.add(proceso);
        }
        return procesos;
    }

    /**
     * Recibe una linea con la informacion detallada del proceso.
     * Trocea la linea para obtener cada uno de los campos que forma un proceso
     *
     * @param linea contiene la informacion detallada del proceso
     * @return
     */
    public static Proceso parsearLinea(String linea) {
        String nombreImagen = linea.substring(0, 25).trim();
        int pid = Integer.parseInt(linea.substring(25, 35).trim());
        String nombreSesion = linea.substring(35, 47).trim();
        //Quitamos el separador de millares, no aporta
        String usoMemoriaStr = linea.substring(63,73).replace(".","");
        double usoMemoria = Double.parseDouble(usoMemoriaStr);
        Proceso proceso = new Proceso(nombreImagen, pid, nombreSesion, usoMemoria);
        return proceso;
    }

}
