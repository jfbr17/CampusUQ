package campusuq.com.uniquindio.android.electiva.campusuq.util;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;

import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.noticiaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.agendaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.sugerenciasFragment;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa adaptador de pager fragment
 */
public class AdaptadoDePagerFragmet extends FragmentPagerAdapter {

    private ArrayList<String> listaDeTiulos;
    /**
     * Metodo contructor de la clase AdaptadoDePagerFragmet
     * @param fm, el FragmentManager
     */
    public AdaptadoDePagerFragmet(FragmentManager fm) {
        super(fm);
        listaDeTiulos = new ArrayList<>();
        listaDeTiulos.add("Agenda");
        listaDeTiulos.add("Noticias");
        listaDeTiulos.add("Sugerir");
    }
    /**
     * Metodo que permite obtener el fragmento de cada item
     * @param position, la posicion
     */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                agendaFragment agenda = new agendaFragment();
                return agenda;
            case 1:
                noticiaFragment noticia = new noticiaFragment();
                return noticia;
            case 2:
                sugerenciasFragment sugerencias = new sugerenciasFragment();
                return sugerencias;
            default:
                return  null;
        }
    }
    /**
     * Metodo que permite contar los elemmentos de la lista
     * @return el tamaño de la lista
     */
    @Override
    public int getCount() {
        return listaDeTiulos.size();
    }
    /**
     * Metodo que permite obtener el titulo de la lista
     * @param position, la posicion en el arraylist
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return listaDeTiulos.get(position);
    }
}
