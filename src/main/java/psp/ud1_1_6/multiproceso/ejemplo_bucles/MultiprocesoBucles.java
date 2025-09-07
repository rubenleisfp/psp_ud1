package psp.ud1_1_6.multiproceso.ejemplo_bucles;

import java.io.IOException;

public class MultiprocesoBucles {

    public static void main(String[] args) {
        try {
            // Crear y lanzar un proceso
            ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", "target/classes", "psp.ud1_1_6.multiproceso.ejemplo_bucles.HelloProcess1");
            pb1.inheritIO();
            Process process1 = pb1.start();

            // Crear y lanzar otro proceso
            ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", "target/classes", "psp.ud1_1_6.multiproceso.ejemplo_bucles.HelloProcess2");
            pb2.inheritIO();
            Process process2 = pb2.start();

            // Esperar a que los procesos finalicen
            process1.waitFor();
            process2.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }
}
