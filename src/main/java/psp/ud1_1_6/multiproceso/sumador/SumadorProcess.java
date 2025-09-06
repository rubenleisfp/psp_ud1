package psp.ud1_1_6.multiproceso.sumador;

public class SumadorProcess {

    public int sumar(int n1, int n2) {
        int resultado = 0;
        for (int i = n1; i <= n2; i++) {
            resultado = resultado + i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        SumadorProcess process = new SumadorProcess();
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int resultado = process.sumar(n1, n2);
        System.out.println(resultado);
    }
}