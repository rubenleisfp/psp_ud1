package psp.ud1_1_6.multiproceso.sumador;

import java.io.File;

public class LanzadorSumador {

    /**
     * Recibe 2 argumentos, que son los número entre los cuales quiero realizar la suma
     * Habría un proceso que lance sumador para realizar esta tarea
     * El tercer argumento sera el fichero donde se guardaran el resultado
     *
     * @param n1
     * @param n2
     * @param fichResultado
     */
    public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {
        String clase = "psp.ud1_1_6.multiproceso.sumador.SumadorProcess";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(
                    "java", "-cp", "target/classes", clase,
                    n1.toString(), n2.toString());

            //  pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fichResultado));
            pb.start();
        } catch (Exception e) {
            System.err.println("Error al lanzar el proceso: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LanzadorSumador l = new LanzadorSumador();
        l.lanzarSumador(1, 5, "result1.txt");
        l.lanzarSumador(6, 10, "result2.txt");
        System.out.println("Ok");
    }
}
