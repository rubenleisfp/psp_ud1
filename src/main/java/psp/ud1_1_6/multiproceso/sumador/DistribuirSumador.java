package psp.ud1_1_6.multiproceso.sumador;

import java.io.*;
import java.util.List;

public class DistribuirSumador {

    static final int NUM_PROCESOS = 2;
    static final String PREFIJO_FICHEROS = "fich";

    /**
     *
     * Recibe 2 argumentos que definen un intervalo
     *
     * Divide el intervalo entre el numero de procesos
     * Cada proceso hace una suma parcial del intervalo recibido
     * Se abre cada uno de los ficheros para obtener la suma parcial y se suma
     * mostrando el resultado por pantalla
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //TODO
        //1. Crear una instancia de lanzadorSumador
        LanzadorSumador lanzadorSumador = new LanzadorSumador();

        //2. Obtener los valores minimo y maximo de nuestro rango
        int minimo = 5;
        int maximo = 12;

        System.out.println("Primer argumento: " + minimo);
        System.out.println("Segundo argumento: " + maximo);

        //3. Llamar a DividirRango para dividir el intervalo inicial entre el numero de procesos
        DividirRango dividirRango = new DividirRango();
        List<Rango> rangos = dividirRango.dividir(minimo, maximo, NUM_PROCESOS);

        //4. Iterar sobre los rangos obtenidos y llamar a lanzarSumador con el minimo, maximo y nombre de fichero(1,2,...n)
        int i=1;
        for (Rango rango: rangos) {
            String nombreFich = PREFIJO_FICHEROS + i;
            lanzadorSumador.lanzarSumador(rango.getMinimo(), rango.getMaximo(), nombreFich);
            i++;
        }

        //5. Esperamos un tiempo prudente para que todos los procesos terminen
        Thread.sleep(5000);

        //6. Llamar a getSumaTotal para obtener la suma parcial de cada proceso y sumarla
        int sumaTotal = getSumaTotal(NUM_PROCESOS);

        //7. Mostrar el resultado por pantalla
        System.out.println("La suma total es: " + sumaTotal);
    }

    /**
     * Abre los ficheros con las sumas parciales, las suma y las devuelve
     *
     * @param numFicheros
     * @return
     */
    public static int getSumaTotal(int numFicheros) {
        //TODO
        //1. Iterar sobre cada fichero creado y obtener la suma parcial del mismo llamado a getResultadoFichero
        //2. Sumar las sumas parciales
        int sumaTotal = 0;
        for (int i = 1; i <= numFicheros; i++) {
            sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + i);
        }
        return sumaTotal;
    }

    /**
     * Funcion que obtiene el contenido del fichero recibido como argumento
     * y me devuelve el resultado de una suma parcial
     *
     * @param nombreFichero ruta del fichero que quiero abrir para obtener el resultado parcial de la suma
     *                      fich1, fich2, ... ,fichn
     * @return
     */
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
