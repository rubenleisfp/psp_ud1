package psp.ud1_1_1.procesos;

import java.io.IOException;

public class ProcessFirstExample {
    public static void main(String[] args) {
        try {
            // Crear un nuevo proceso que abre Notepad (Windows)
            ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
            Process process = processBuilder.start();  // Iniciar el proceso
            System.out.println("Proceso iniciado: " + process.toString());
        } catch (IOException e) {
            System.err.println("Error al crear el proceso: " + e.getMessage());
        }
    }
}
