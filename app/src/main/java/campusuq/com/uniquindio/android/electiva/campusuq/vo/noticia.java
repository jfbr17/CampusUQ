package campusuq.com.uniquindio.android.electiva.campusuq.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Universidad del Quindio
 * @author Willian David Meza
 * @author Jhon Fredy Bedoya
 * @since  2015-05-04
 *
 * Actividad que que representa una noticia
 */
public class noticia implements Parcelable {


    private int id;
    private int imagen;
    private String titulo;
    private String texto;
    private String fecha;

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
     * Metodo contructor de la clase noticia
     * @param titulo, titulo de la pelicula
     * @param imagen, imagen de la noticia
     * @param fecha, fecha de la noticia
     */
    public noticia(String titulo, int imagen, String fecha, String texto) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.fecha = fecha;
        this.texto = texto;
    }

    /**
     * Metodo que permite guardar la informacion de la notica para ser enviada entre actividades
     * @param in, la parcela en donde se va guardar la informacion de la noticia
     */
    protected noticia(Parcel in) {
        titulo = in.readString();
        imagen = in.readInt();
        fecha = in.readString();
        fecha = in.readString();
    }

    /**
     * Metodo que permite obtener la fecha de la noticia
     * @return la fecha de la noticia
     */
     public String getFecha() {
         return fecha;
     }
    /**
     * Metodo que permite modificar la fecha de la noticia
     * @param fecha , la fecha de la noticia
     */
     public void setFecha(String fecha) {
         this.fecha = fecha;
     }
    /**
     * Metodo que permite obtener el texto de la noticia
     * @return el texto de la noticia
     */
     public String getTexto() {
         return texto;
     }
    /**
     * Metodo que permite modificar el texto de la noticia
     * @param texto, el text de la noticia
     */
     public void setTexto(String texto) {
          this.texto = texto;
     }
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
     public int getId() {
         return id;
     }
    /**
     * Metodo que permite modificar el id de la noticia
     * @param id, el id de la noticia
     */
     public void setId(int id) {
        this.id = id;
     }
    /**
     * Metodo que Describir los tipos de objetos especiales contenidas en la parcela
     * @return 0 objetos especiales
     */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * Metodo que permite escribir en la parcela destino la informacion de la pelicula
     * @param dest, la parcela destino
     * @param flags, bandera para identificar como el objeto debe ser escrito
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeInt(imagen);
        dest.writeString(fecha);
        dest.writeString(texto);
    }
    /**
     * Metodo que permite leer desde la parcela
     * @param in, la parcela  a ser leida con la informacion de la noticia
     */
    public void readFromParcel(Parcel in) {
        titulo=in.readString();
        imagen=in.readInt();
        fecha=in.readString();
        texto=in.readString();
    }

    /**
     * Interfaz que debe implementarse y proporciona como un campo
     * CREADOR pública que genera instancias de la clase parcelable de una parcela.
     */
    public static final Creator<noticia> CREATOR = new Creator<noticia>() {
        /**
         * Metodo que permite Crear una nueva instancia de la clase parcelable,
         * instanciándola de la parcela determinada
         * @param in, la parcela de la noticia
         */
        @Override
        public noticia createFromParcel(Parcel in) {
            return new noticia(in);
        }
        /**
         * Metodo que crea una matriz de la noticia parcelable
         * @param size, el tamaño de la matriz
         */
        @Override
        public noticia[] newArray(int size) {
            return new noticia[size];
        }
    };
}

