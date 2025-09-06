package psp.ud1_1_5.comandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskListFilterExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del proceso a buscar: ");
        String processName = sc.nextLine();

        List<String> processFound = findProcess(processName);
        for (String process: processFound) {
            System.out.println(process);
        }

    }

    /**
     * Obtiene los procesos que contienen el nombre indicado como argumento
     *
     * @param processName nombre o parte del nombres del proceso buscado
     * @return
     */
    private static List<String> findProcess(String processName) {
        List<String> processFound = new ArrayList<>();
        List<String> allProcess = getAllProcess();
        for (String process : allProcess) {
            if (process.contains(processName)) {
                processFound.add(process);
            }
        }
        return processFound;
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
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
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
