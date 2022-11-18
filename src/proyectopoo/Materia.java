package proyectopoo;
/**
 *
 * @author Equipo D
 */
public class Materia {
    private String nombre;
    private static int creditos = 1; 
    private int calificacion;
    private int aprobadaOrd; //1 = Si; 0 = No

    public Materia() {
    }

    public Materia(String nombre, int calificacion, int aprobadaOrd) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.aprobadaOrd = aprobadaOrd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        int cal = (int)(Math.random()*(5)+6);
        setCalificacion(cal);
    }

    public static int getCreditos() {
        return creditos;
    }

    public static void setCreditos(int creditos) {
        Materia.creditos = creditos;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
        int aprobado = (int)(Math.random()*2);
        setAprobadaOrd(aprobado);
    }

    public int getAprobadaOrd() {
        return aprobadaOrd;
    }

    public void setAprobadaOrd(int aprobadaOrd) {
        this.aprobadaOrd = aprobadaOrd;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + 
                ", calificacion=" + calificacion + 
                ", aprobadaOrd=" + getAprobadaOrd() + '}';
    }
   
}
