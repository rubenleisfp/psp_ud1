package psp.boletin.ud1.practica2;

// Clase interna Proceso para almacenar información de los procesos
public class Proceso {

    private String nombreImagen;
    private int pid;
    private String nombreSesion;
    private double usoMemoria;  // En KB

    public Proceso() {

    }

    // Constructor
    public Proceso(String nombreImagen, int pid, String nombreSesion, double usoMemoria) {
        this.nombreImagen = nombreImagen;
        this.pid = pid;
        this.nombreSesion = nombreSesion;
        this.usoMemoria = usoMemoria;
    }

    public double getUsoMemoria() {
        return usoMemoria;
    }

    public void setNombreSesion(String nombreSesion) {
        this.nombreSesion = nombreSesion;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public void setUsoMemoria(double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "nombreImagen='" + nombreImagen + '\'' +
                ", pid=" + pid +
                ", nombreSesion='" + nombreSesion + '\'' +
                ", usoMemoria=" + usoMemoria +
                '}';
    }
}