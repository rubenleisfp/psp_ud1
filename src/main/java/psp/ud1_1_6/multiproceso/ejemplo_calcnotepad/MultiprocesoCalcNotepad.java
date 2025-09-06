package psp.ud1_1_6.multiproceso.ejemplo_calcnotepad;

import java.io.IOException;

public class MultiprocesoCalcNotepad {
    public static void main(String[] args) {
        try {
            // Crear y lanzar el proceso para abrir la Calculadora
            ProcessBuilder pb1 = new ProcessBuilder("calc.exe");
            Process process1 = pb1.start();

            // Crear y lanzar el proceso para abrir el Bloc de Notas
            ProcessBuilder pb2 = new ProcessBuilder("notepad.exe");
            Process process2 = pb2.start();

            // Esperar a que los procesos finalicen (opcional)
            // Puedes comentar estas líneas si no necesitas esperar a que los procesos terminen
            process1.waitFor();
            process2.waitFor();
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}