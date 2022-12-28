package gestionescolar;
/**
 *
 * @author Jean
 */
public class Asignatura {
    public int clave;
    public int calif;
    private String nombre;
    
    public Asignatura() {
    }

    public Asignatura(int clave, int calif, String nombre) {
        this.clave = clave; 
        this.calif = calif;
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public int getCalif() {
        return calif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setCalif(int calif) {
        this.calif = calif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "-Clave:" + clave +
                "  -Calificacion:" + calif + 
                "\t-Materia: " + nombre+"\n";
    }
    
}
