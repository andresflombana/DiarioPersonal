package mundo;
/**
 *
 * @author Andrés Lombana - Carlos Quenan
 */
public class Entrada {
    private int idEntrada; //Identificador de la entrada
    private String fecha; // Fecha de creación de la entrada
    private String descripcion; // Descripción de la entrada

    public Entrada(int idEntrada, String fecha, String descripcion) {
    this.idEntrada = idEntrada;
    this.fecha = fecha;
    this.descripcion = descripcion;
}

    /**
     * Método getter para obtener el ID de la entrada.
     */
    public int getIdEntrada() {
        return idEntrada;
    }
    /**
     * Método getter para obtener la fecha de la entrada.
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Método getter para obtener la descripción de la entrada.
     */
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
}
