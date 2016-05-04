package campusuq.com.uniquindio.android.electiva.campusuq.fragmets;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.util.AdaptadorDeAgenda;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.Agenda;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa la agenda fragment
 */
public class agendaFragment extends Fragment implements View.OnClickListener {


    private RecyclerView agendaRecycler;
    private AdaptadorDeAgenda adaptador;
    private ArrayList<Agenda> Agenda;
    /**
     * Metodo constructor del fragmanto
     */
    public agendaFragment() {
        // Required empty public constructor
    }
    /**
     * Metodo que nos permite la inicializacion de los elementos que van a ser agregados al reciclerView
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre fragmentos
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Agenda = new ArrayList();
        Agenda.add(new Agenda("Secretaria", "0367402383", "ext 308"));
        Agenda.add(new Agenda("Direccion", "0367402383", "ext 318"));
        Agenda.add(new Agenda("Proyecto", "0367402383", "ext 300"));
        Agenda.add(new Agenda("Laboratorio", "0367402383", "ext 311"));
        Agenda.add(new Agenda("GRID", "0367402383", "ext 315"));
        Agenda.add(new Agenda("CEIFI", "0367402383", "ext 319"));
        agendaRecycler= (RecyclerView) getView().findViewById(R.id.RecView);
        adaptador = new AdaptadorDeAgenda(Agenda);
        agendaRecycler.setAdapter(adaptador);
        agendaRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
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
        return inflater.inflate(R.layout.fragment_agenda, container, false);
    }
    /**
     * Metodo que permite identificar el item de la vista presionado
     * @param v, la vista del evento
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("0367402383"));
        startActivity(intent);
    }
}
