package psp.boletin.ud1.practica10;

public class ContarLetraProcess {

    public int contarAparicionesLetra(String line, char charBuscado) {
        int countA = 0;
        for (char c : line.toCharArray()) {
            if (Character.toUpperCase(c) == charBuscado) {
                countA++;
            }
        }
        return countA;
    }

    public static void main(String[] args){
        ContarLetraProcess process=new ContarLetraProcess();
        String line =args[0];
        char charBuscado ='A';
        int resultado=process.contarAparicionesLetra(line, charBuscado);
        System.out.println(resultado);
    }
}
