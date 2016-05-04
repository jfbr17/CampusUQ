package campusuq.com.uniquindio.android.electiva.campusuq.fragmets;


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
import campusuq.com.uniquindio.android.electiva.campusuq.util.AdaptadorDeNoticias;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;

public class noticiaFragment extends Fragment {

   // private RecyclerView listadoDeNoticias;
   // private AdaptadorDeNoticias adaptador;
   // private ArrayList<noticia> noticias;

    public noticiaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // noticias = new ArrayList();
       // noticias.add(new noticia("Noticia1",R.drawable.interstellar_encabezado));
      //  noticias.add(new noticia("Noticia2",R.drawable.interstellar_encabezado));
      //  noticias.add(new noticia("Noticia3",R.drawable.interstellar_encabezado));
      //  noticias.add(new noticia("Noticia4",R.drawable.interstellar_encabezado));
      //  noticias.add(new noticia("Noticia5",R.drawable.interstellar_encabezado));
     //   listadoDeNoticias= (RecyclerView) getView().findViewById(R.id.RecView);
      //  adaptador = new AdaptadorDeNoticias(noticias);
      //  listadoDeNoticias.setAdapter(adaptador);
     //   listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticia, container, false);
    }
   // @Override
   // public void onCreate(@Nullable Bundle savedInstanceState) {
  //      super.onCreate(savedInstanceState);
  //      setHasOptionsMenu(true);
    //}
}
