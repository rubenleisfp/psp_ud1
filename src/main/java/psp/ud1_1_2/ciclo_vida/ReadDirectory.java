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
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }
}