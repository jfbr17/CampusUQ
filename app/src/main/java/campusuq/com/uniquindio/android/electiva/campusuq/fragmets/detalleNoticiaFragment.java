package campusuq.com.uniquindio.android.electiva.campusuq.fragmets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;

/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa el detalle noticia fragment
 */
public class detalleNoticiaFragment extends Fragment  implements View.OnClickListener{


    private TextView titulo;
    private ImageView imagen;
    private TextView fecha;
    private TextView texto;
    private noticia noticia;
    /**
     * Metodo constructor del fragmanto
     */
    public detalleNoticiaFragment() {
        // Required empty public constructor
    }
    /**
     * Metodo que nos permite la inicializacion de los elementos que van a ser agregados al reciclerView
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre fragmentos
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }

    /**
     * Metodo que nos permite ver los detaller de la noticia
     * @param noticia, la noticia que se requiere ver los detalles
     */
    public void showDetail(noticia noticia) {
        this.noticia= noticia;
        titulo = (TextView) getView().findViewById(R.id.titulo_de_detalle_pelicula);
        titulo.setText(noticia.getTitulo());
        fecha = (TextView) getView().findViewById(R.id.fecha_de_detalle_pelicula);
        fecha.setText(noticia.getFecha());
        texto = (TextView) getView().findViewById(R.id.descripcion_de_detalle_pelicula);
        texto.setText(noticia.getTexto());
        imagen = (ImageView) getView().findViewById(R.id.imagen_detalle);
        imagen.setImageResource(noticia.getImagen());
    }
    /**
     * Metodo que permite identificar el item de la vista presionado
     * @param v, la vista del evento
     */
    @Override
    public void onClick(View v) {
    }


}
