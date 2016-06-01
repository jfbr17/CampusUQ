package campusuq.com.uniquindio.android.electiva.campusuq.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.noticiaFragment;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa adaptador de noticias
 */
public class AdaptadorDeNoticias  extends RecyclerView.Adapter<AdaptadorDeNoticias.NoticiaViewHolder>{

    private ArrayList<noticia> noticias;
    private static OnClickAdaptadorDeNoticia listener;
    /**
     * Metodo contructor de la clase adaptadorDeNoticia
     * @param noticias, el Arraylist de noticias
     * @param noticiaFragment, los fagmentos de las noticia
     */
    public AdaptadorDeNoticias(ArrayList<noticia> noticias, noticiaFragment noticiaFragment ) {
        this.noticias = noticias;
        listener = (OnClickAdaptadorDeNoticia) noticiaFragment;
    }
    /**
     * Metodo que permite crear una vista de tipo pelicula para el reciclerView
     * @param parent, El ViewGroup en la que se añadirá la nueva vista
     * @param viewType, El tipo de vista de la nueva vista.
     */
    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle_de_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;
    }
    /**
     * Metodo que visualizar los datos en la posicion especifica
     * @param holder, la vista a ser visualizada
     * @param position, la posicion de la vista.
     */
    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        noticia noticia = noticias.get(position);
        holder.binNoticia(noticia);
    }
    /**
     * Metodo que permite contar los elemmentos de la lista
     * @return el tamaño de la lista
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTitulo;
        private ImageView imagen;
        /**
         * Metodo contructor de la vista de tipo noticia
         * @param itemView, el item de la lista
         */
        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);

        }
        /**
         * Metodo que permite modificar los atributos de la noticia
         * @param n, la noticia
         */
        public void binNoticia(noticia n) {
            txtTitulo.setText(n.getTitulo());
            imagen.setImageResource(n.getImagen());
        }
        /**
         * Metodo que permite identificar el item de la vista presionado
         * @param v, la vista del evento
         */
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtTitulo.getText());
        }
    }

    public interface OnClickAdaptadorDeNoticia{
        public void onClickPosition(int pos);
    }

}
