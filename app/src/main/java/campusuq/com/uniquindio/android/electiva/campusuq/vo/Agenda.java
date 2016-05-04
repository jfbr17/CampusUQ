package campusuq.com.uniquindio.android.electiva.campusuq.vo;


import java.lang.String;

/**
 * Universidad del Quindio
 * @author Willian David Meza
 * @author Jhon Fredy Bedoya
 * @since  2015-05-04
 *
 * Actividad que que representa una agenda
 */
public class Agenda {

    private String dependencia;
    private String numero;
    private String extencion;

    /**
     * Metodo contructor de la clase agenda
     * @param dependencia, la dependencia de la agenda
     * @param numero, el numero de la dependencia
     * @param extencion , la extencion del numero
     */
    public Agenda(String dependencia, String numero, String extencion) {
        this.dependencia = dependencia;
        this.numero = numero;
        this.extencion = extencion;
    }
    /**
     * Metodo que permite obtener la dependencia de la agenda
     * @return la dependencia de la agenda
     */
    public String getDependencia() {
        return dependencia;
    }
    /**
     * Metodo que permite modificar la dependencia
     * @param dependencia , la depenendencia de la agenda
     */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    /**
     * Metodo que permite obtener el numero de la dependencia
     * @return el numero de la dependencia
     */
    public String getNumero() {
        return numero;
    }
    /**
     * Metodo que permite modificar el numero de la dependencia
     * @param  numero , el numero de la dependencia
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * Metodo que permite obtener la extencion del numero
     * @return la extencion del numero
     */
    public String getExtencion() {
        return extencion;
    }
    /**
     * Metodo que permite modificar la extencion del numero
     * @param extencion , la extencion del numero
     */
    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }
}
