package campusuq.com.uniquindio.android.electiva.campusuq.vo;

import java.util.Date;

/**
 * Universidad del Quindio
 * @author Willian David Meza
 * @author Jhon Fredy Bedoya
 * @since  2015-05-04
 *
 * Actividad que que representa una noticia
 */
public class noticia {

  //  private int id;
    private int imagen;
    private String titulo;
 //   private String texto;
  //  private Date fecha;

    /**
     * Metodo contructor de la clase noticia
     * @param titulo, titulo de la pelicula
     * @param imagen, imagen de la noticia
     */
    public noticia( String titulo, int imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }
    /**
     * Metodo que permite obtener la fecha de la noticia
     * @return la fecha de la noticia
     */
  //  public Date getFecha() {
  //      return fecha;
  //  }
    /**
     * Metodo que permite modificar la fecha de la noticia
     * @param fecha , la fecha de la noticia
     */
  //  public void setFecha(Date fecha) {
   //     this.fecha = fecha;
   // }
    /**
     * Metodo que permite obtener el texto de la noticia
     * @return el texto de la noticia
     */
  //  public String getTexto() {
  //      return texto;
  //  }
    /**
     * Metodo que permite modificar el texto de la noticia
     * @param texto, el text de la noticia
     */
  //  public void setTexto(String texto) {
  //      this.texto = texto;
  //  }
    /**
     * Metodo que permite obtener el titulo de la noticia
     * @return el titulo de la noticia
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Metodo que permite modificar el titulo de la noticia
     * @param titulo , el titulo de la noticia
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Metodo que permite obtener la imagen de la noticia
     * @return la imagen de la noticia
     */
    public int getImagen() {
        return imagen;
    }
    /**
     * Metodo que permite modificar la imagen de la noticia
     * @param imagen , la imagen de la noticia
     */
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    /**
     * Metodo que permite obtener el id de la noticia
     * @return el id de la noticia
     */
  //  public int getId() {
   //     return id;
   // }
    /**
     * Metodo que permite modificar el id de la noticia
     * @param id, el id de la noticia
     */
   // public void setId(int id) {
   //     this.id = id;
   // }
}

