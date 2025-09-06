package psp.boletin.ud1.practica1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskListFinder {


    public static void main(String[] args) {
        List<Proceso> procesos = getProcesos();
        List<String> procesosBuscados = Arrays.asList("notepad.exe", "CalculatorApp.exe");
        imprimirResultados(procesosBuscados, procesos);
    }

    // Imprime resultados o mensajes de no encontrado
    private static void imprimirResultados(List<String> procesosBuscados, List<Proceso> encontrados) {
        for (String buscado : procesosBuscados) {
            boolean existe = false;
            for (Proceso p : encontrados) {
                if (p.getNombreImagen().equalsIgnoreCase(buscado)) {
                    existe = true;
                    System.out.println("Proceso encontrado: " + p.getNombreImagen()
                            + " | PID: " + p.getPid()
                            + " | Memoria: " + p.getUsoMemoria());
                }
            }
            if (!existe) {
                System.out.println("No se encontraron instancias de " + buscado);
            }
        }
    }

    private static List<Proceso> getProcesos() {
        List<Proceso> listaProcesos = new ArrayList<>();
        try {
            // Ejecutar el comando tasklist
            ProcessBuilder builder = new ProcessBuilder("tasklist");
            Process process = builder.start();

            // Leer la salida del comando tasklist
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;


            // Saltar las primeras líneas de cabecera
            for (int i = 0; i < 3; i++) {
                reader.readLine();
            }

            // Leer cada línea de los procesos
            while ((line = reader.readLine()) != null) {
                // Verificar que la línea no esté vacía
                if (line.trim().isEmpty()) continue;

                try {
                    Proceso p = Parsear.parsearLinea(line);
                    listaProcesos.add(p);
                } catch (Exception e) {
                    System.out.println("Error procesando línea: " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo los procesos" + e);
        }
        return listaProcesos;
    }
}
