package psp.ud1_1_6.multiproceso.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessCounter {
    public static void main(String[] args) {

        contarProcesosExe();

        //Apartado Investiga
//        String detalleProceso = buscarProceso("Notepad");
//        System.out.println("detalleProceso: " + detalleProceso);
    }

    public static String buscarProceso(String nombreProceso) {
        String detalleProceso = "PROCESO NO ENCONTRADO";
        try {
            // Crear un proceso para ejecutar el comando tasklist (Windows)
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "tasklist");
            Process process = processBuilder.start();

            // Leer la salida del proceso (los procesos listados)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Contar las líneas que representan procesos
            List<String> lines = getProcessOutputLines(process);
            for (String line : lines) {
                if (line.contains(nombreProceso)) {
                    detalleProceso = line;
                }
            }
            return detalleProceso;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void contarProcesosExe() {
        int processCount = 0;
        List<String> lines = getAllProcess();
        for (String line : lines) {
            if (line.contains(".exe")) {
                processCount++;
            }
        }
        System.out.println("Número total de procesos activos: " + processCount);
    }


    /**
     * Obtiene una lista con todos los procesos del sistema
     *
     * @return
     */
    private static List<String> getAllProcess() {
        List<String> processList = new ArrayList<>();
        try {
            // Crear el proceso para ejecutar "tasklist"
            ProcessBuilder builder = new ProcessBuilder("tasklist");
            // Iniciar el proceso
            Process process = builder.start();
            processList = getProcessOutputLines(process);
            return processList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return processList;
    }

    /**
     * Obtiene una lista de procesos de la salida estandar
     *
     * @param process
     * @return
     * @throws IOException
     */
    private static List<String> getProcessOutputLines(Process process) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }


}
