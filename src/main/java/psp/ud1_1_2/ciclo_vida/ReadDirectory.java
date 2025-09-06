package psp.ud1_1_2.ciclo_vida;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class ReadDirectory {

    public static void main(String[] arg) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del directorio a revisar:");
        String directory = sc.nextLine();
        read(directory,"read_directory.txt");
    }

    /**
     * Abre un CMD y muestra el contenido de un directorio recibido como argumento
     *
     * @param directory que queremos revisar
     * @throws IOException
     */
    public static void read(String directory, String outputFile) throws IOException {
        // Crear ProcessBuilder con el comando 'cmd' y 'dir' para listar archivos
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir");

        // Establecer el directorio donde se quiere ejecutar el comando 'dir'
        processBuilder.directory(new File(directory)); // Cambia el directorio de trabajo
        processBuilder.inheritIO();

        File archivoSalida = new File(outputFile);
        // Redirigir la salida del proceso al archivo
        processBuilder.redirectOutput(archivoSalida);

        // Iniciar el proceso
        Process process = processBuilder.start();
    }
}