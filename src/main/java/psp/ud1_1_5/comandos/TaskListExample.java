package psp.ud1_1_5.comandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskListExample {
    public static void main(String[] args) {
        try {
            // Crear el proceso para ejecutar "tasklist"
            ProcessBuilder builder = new ProcessBuilder("tasklist");

            // Iniciar el proceso
            Process process = builder.start();

            // Capturar y mostrar la salida del comando "tasklist"
            List<String> outputLines = getProcessOutputLines(process);
            for (String line : outputLines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Recoger la informacion de salida del proceso y guardarla en una lista de String
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
