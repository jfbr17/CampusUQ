package campusuq.com.uniquindio.android.electiva.campusuq.fragmets;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.util.Utilidades;
import campusuq.com.uniquindio.android.electiva.campusuq.util.AdaptadorDeNoticias;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa la noticia fragment
 */
public class noticiaFragment extends Fragment implements AdaptadorDeNoticias.OnClickAdaptadorDeNoticia {

    private RecyclerView listadoDeNoticias;
    private AdaptadorDeNoticias adaptador;
    private ArrayList<noticia> noticias;
    private OnNoticiaSeleccionadaListener listener;

    /**
     * Metodo constructor del fragmanto
     */
    public noticiaFragment() {
        // Required empty public constructor
    }
    /**
     * Metodo que nos permite la inicializacion de los elementos que van a ser agregados al reciclerView
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre fragmentos
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        noticias = new ArrayList();
        noticias.add(new noticia("Noticia1", R.drawable.interstellar_encabezado));
        noticias.add(new noticia("Noticia2", R.drawable.interstellar_encabezado));
        noticias.add(new noticia("Noticia3", R.drawable.interstellar_encabezado));
        noticias.add(new noticia("Noticia4", R.drawable.interstellar_encabezado));
        noticias.add(new noticia("Noticia5", R.drawable.interstellar_encabezado));
        listadoDeNoticias = (RecyclerView) getView().findViewById(R.id.RecView);
        adaptador = new AdaptadorDeNoticias(noticias, this);
        listadoDeNoticias.setAdapter(adaptador);
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
    /**
     * Metodo que nos permite asociar el fragmento con un layout
     * @param inflater, el layout para inflar el fragmento
     * @param container, es la vista padre que contiene el fragmento.
     * @param savedInstanceState, bundle que nos permite guar estados.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticia, container, false);
    }
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes del fragmento
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre fragmentos
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * Metodo que nos permite asociar el fragmento a una actividad
     * @param context, el contexto del fragmento
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                listener = (OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPeliculaSeleccionadaListener");
            }
        }

    }


    /**
     * Metodo identificar que opcion es seleccionada y
     * relalizar las correspondientes acciones
     *
     * @param item, el item seleccionado
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cambiar_idioma) {
            Utilidades.cambiarIdioma(getContext());
            Intent intent = getActivity().getIntent();
            getActivity().finish();
            startActivity(intent);
            return true;
        }
        else if(id == R.id.pagina_universidad){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uniquindio.edu.co/"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Metodo que nos inflar  el menu
     * @param menu, el menu a ser inflado
     * @param inflater, el menuInflanter para ser agregado a el menu
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
    /**
     * Metodo utlizado identificar la pelicula seleccionada
     * @param pos, la posicion presionada
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onNoticiaSeleccionada(pos);
    }


    public interface OnNoticiaSeleccionadaListener {
        void onNoticiaSeleccionada(int position);
    }
    /**
     * Metodo que permite obtener lasticias nos de la lista
     * @return las noticias del arraylist
     */
    public ArrayList<noticia> getNoticias() {
        return noticias;
    }
    /**
     * Metodo que permite modificar el arraylist de noticias
     * @param noticias, arraylist de noticias a introducir en la lista
     */
    public void setNoticias(ArrayList<noticia> noticias) {
        this.noticias = noticias;
    }
}
