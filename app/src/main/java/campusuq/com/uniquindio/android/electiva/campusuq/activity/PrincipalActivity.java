package campusuq.com.uniquindio.android.electiva.campusuq.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.noticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.agendaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.detalleNoticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;
import campusuq.com.uniquindio.android.electiva.campusuq.util.AdaptadoDePagerFragmet;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * clase que implementa la actividad principal
 */
public class PrincipalActivity extends AppCompatActivity implements noticiaFragment.OnNoticiaSeleccionadaListener {

    private noticiaFragment noticiasFragment;
    private ArrayList<noticia> noticias;
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
        AdaptadoDePagerFragmet adapter = new AdaptadoDePagerFragmet(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdaptadoDePagerFragmet(getSupportFragmentManager()));
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

}
