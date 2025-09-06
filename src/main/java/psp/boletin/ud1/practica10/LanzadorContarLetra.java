package psp.boletin.ud1.practica10;

import java.io.File;

public class LanzadorContarLetra {

        /**
         * Recibe 1 un argumento. La linea sobre la cual quiero contar letras
         *
         *
         * @param n1
         * @param fichResultado
         */
        public void lanzarContarLetra(String n1, String fichResultado){
                String clase="psp.boletin.ud1.practica10.ContarLetraProcess";
                ProcessBuilder pb;
                try {
                        pb = new ProcessBuilder(
                                "java", "-cp", "target/classes", clase,
                                n1);

                        pb.redirectError(new File("errores.txt"));
                        pb.redirectOutput(new File(fichResultado));
                        pb.start();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public static void main(String[] args){
                LanzadorContarLetra l = new LanzadorContarLetra();
                l.lanzarContarLetra("HOLA AMIGO" ,"contarLetra1.txt");
                l.lanzarContarLetra("ADIO ENEMIGO", "contarLetra2.txt");
                System.out.println("Ok");
        }
}
