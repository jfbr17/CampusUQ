package campusuq.com.uniquindio.android.electiva.campusuq.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.noticia;


public class AdaptadorDeNoticias  extends RecyclerView.Adapter<AdaptadorDeNoticias.NoticiaViewHolder>{

    private ArrayList<noticia> noticias;
  //  private static OnClickAdaptadorDeNoticia listener;

    public AdaptadorDeNoticias(ArrayList<noticia> noticias ) {
        this.noticias = noticias;
       // listener= (OnClickAdaptadorDeNoticia) noticiaFragment;
    }

    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle_de_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;
    }

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        noticia noticia = noticias.get(position);
        holder.binNoticia(noticia);
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTitulo;
        private ImageView imagen;

        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
        }
        public void binNoticia(noticia n) {
            txtTitulo.setText(n.getTitulo());
            imagen.setImageResource(n.getImagen());
        }

        @Override
        public void onClick(View v) {

        }
    }

}
