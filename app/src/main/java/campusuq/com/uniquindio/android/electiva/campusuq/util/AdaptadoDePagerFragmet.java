package campusuq.com.uniquindio.android.electiva.campusuq.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.noticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.numerostelefonicosFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.sugerenciasFragment;


public class AdaptadoDePagerFragmet extends FragmentPagerAdapter {

    private ArrayList<String> listaDeTiulos;
    public AdaptadoDePagerFragmet(FragmentManager fm) {
        super(fm);
        listaDeTiulos = new ArrayList<>();
        listaDeTiulos.add("Noticias");
        listaDeTiulos.add("Agenda");
        listaDeTiulos.add("sugerir");

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                noticiaFragment noticia = new noticiaFragment();
                return noticia;
            case 1:
                numerostelefonicosFragment agenda = new numerostelefonicosFragment();
                return agenda;
            case 2:
                sugerenciasFragment sugerencias = new sugerenciasFragment();
                return sugerencias;
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return listaDeTiulos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listaDeTiulos.get(position);
    }
}
