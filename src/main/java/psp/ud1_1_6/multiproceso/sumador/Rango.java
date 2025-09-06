package psp.ud1_1_6.multiproceso.sumador;

public class Rango {

    private int minimo;
    private int maximo;

    public Rango() {

    }

    public Rango(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    @Override
    public String toString() {
        return "Rango{" +
                "minimo=" + minimo +
                ", maximo=" + maximo +
                '}';
    }
}
