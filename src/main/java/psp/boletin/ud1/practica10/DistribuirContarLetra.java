package psp.boletin.ud1.practica10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DistribuirContarLetra {

    static final String FILE_PATH = "texto.txt";
    static final String PREFIJO_FICHEROS = "Fichero_cuenta_a_";

    /* Recibe dos parámetros y hará
     * la suma de los valores comprendidos
     * entre ambos parámetros
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        LanzadorContarLetra lanzadorContarLetra = new LanzadorContarLetra();

        List<String> lineas = obtenerLineasFichero(FILE_PATH);

        int lineNumber = 1;
        for (String line : lineas) {
            // Crear proceso para cada línea
            String nombreFich = PREFIJO_FICHEROS + lineNumber;
            lanzadorContarLetra.lanzarContarLetra(line, nombreFich);
            lineNumber++;
        }

        // Esperamos un tiempo prudente para que todos los procesos terminen
        Thread.sleep(5000);

        int sumaTotal = getSumaTotal(lineNumber);
        System.out.println("La suma total es: " + sumaTotal);
    }

    public static List<String> obtenerLineasFichero(String filePath) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                // Crear proceso para cada línea
                lineas.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineas;
    }

    public static int getSumaTotal(int numFicheros) {
        int sumaTotal = 0;
        for (int i = 1; i < numFicheros; i++) {
            sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + i);
        }
        return sumaTotal;
    }

    public static int getResultadoFichero(String nombreFichero) {
        int suma = 0;
        try (FileInputStream fichero = new FileInputStream(nombreFichero);
             InputStreamReader fir = new InputStreamReader(fichero);
             BufferedReader br = new BufferedReader(fir)) {

            String linea = br.readLine();
            suma = Integer.parseInt(linea); // Cambiado a parseInt

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número incorrecto en " + nombreFichero);
        }
        return suma;
    }


}
