package campusuq.com.uniquindio.android.electiva.campusuq.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.detalleNoticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa el detalle noticia
 */
public class detallenoticiaActivity extends AppCompatActivity {
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallenoticia);

        detalleNoticiaFragment detalleDeNoticia = (detalleNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula);
        noticia noticia = (noticia) getIntent().getExtras().getParcelable("noticia");
        detalleDeNoticia.showDetail(noticia);
    }
}
