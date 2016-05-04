package campusuq.com.uniquindio.android.electiva.campusuq.fragmets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import campusuq.com.uniquindio.android.electiva.campusuq.R;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa la sugerencia fragment
 */
public class sugerenciasFragment extends Fragment {

    /**
     * Metodo constructor del fragmanto
     */
    public sugerenciasFragment() {
        // Required empty public constructor
    }
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes del fragmento
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre fragmentos
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugerencias, container, false);
    }

}
