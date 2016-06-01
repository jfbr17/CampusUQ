package campusuq.com.uniquindio.android.electiva.campusuq.activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.noticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.agendaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.detalleNoticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.Agenda;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;
import campusuq.com.uniquindio.android.electiva.campusuq.util.AdaptadoDePagerFragmet;

import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since 2015-05-04
 *
 * clase que implementa la actividad principal
 */
public class PrincipalActivity extends AppCompatActivity implements noticiaFragment.OnNoticiaSeleccionadaListener, agendaFragment.OnAgendaSeleccionadaListener {


    private noticiaFragment noticiasFragment;
    private agendaFragment agendaFragment;
    private ArrayList<noticia> noticias;
    private ArrayList<Agenda> Agenda;


    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdaptadoDePagerFragmet(getSupportFragmentManager(), this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#FFffffff")));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFffffff"));

        String cuerpo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

        noticias = new ArrayList();
        noticias.add(new noticia("Noticia1", R.drawable.noticia, "2016-05-04", cuerpo));
        noticias.add(new noticia("Noticia2", R.drawable.noticia, "2016-05-04", cuerpo));
        noticias.add(new noticia("Noticia3", R.drawable.noticia, "2016-05-04", cuerpo));
        noticias.add(new noticia("Noticia4", R.drawable.noticia, "2016-05-04", cuerpo));
        noticias.add(new noticia("Noticia5", R.drawable.noticia, "2016-05-04", cuerpo));

        noticiasFragment = (noticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_peliculas);
        noticiasFragment.setNoticias(noticias);

         Agenda = new ArrayList();
         Agenda.add(new Agenda("Secretaria", "0367402383"));
         Agenda.add(new Agenda("Direccion", "0367402383"));
         Agenda.add(new Agenda("Proyecto", "0367402383"));
         Agenda.add(new Agenda("Laboratorio", "0367402383"));
         Agenda.add(new Agenda("GRID", "0367402383"));
         Agenda.add(new Agenda("CEIFI", "0367402383"));

        agendaFragment = (agendaFragment) getSupportFragmentManager().findFragmentById(R.id.RecView);
//        agendaFragment.setAgenda(Agenda);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoticiaSeleccionada(int position) {

        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula) != null;
        if (esFragmento) {
            ((detalleNoticiaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula)).showDetail(noticias.get(position));
        } else {
            Intent intent = new Intent(PrincipalActivity.this,
                    detallenoticiaActivity.class);
            intent.putExtra("noticia", noticias.get(position));
            startActivity(intent);
        }
    }

    @Override
    public void onAgendaSeleccionada(int position) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Agenda.get(position).getNumero()));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        }catch (ActivityNotFoundException activityException){
            Log.e("ET", "No se pudo realizar la llamada.", activityException);
        }
    }

}
