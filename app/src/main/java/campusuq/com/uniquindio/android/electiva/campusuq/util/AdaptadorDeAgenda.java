package campusuq.com.uniquindio.android.electiva.campusuq.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import campusuq.com.uniquindio.android.electiva.campusuq.R;
import campusuq.com.uniquindio.android.electiva.campusuq.fragmets.agendaFragment;
import campusuq.com.uniquindio.android.electiva.campusuq.vo.Agenda;
/**
 * Universidad del Quindio
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-05-04
 *
 * Actividad que implementa adaptador de agenda
 */
public class AdaptadorDeAgenda  extends RecyclerView.Adapter<AdaptadorDeAgenda.AgendaViewHolder> {

    private ArrayList<Agenda> Agenda;
    private static OnClickAdaptadorDeAgenda listener;
    /**
     * Metodo contructor de la clase adaptadorDeAgenda
     * @param agenda, el Arraylist de agenda
     */
    public AdaptadorDeAgenda(ArrayList<Agenda> agenda) {
        this.Agenda = agenda;
    }
    /**
     * Metodo que permite crear una vista de tipo pelicula para el reciclerView
     * @param parent, El ViewGroup en la que se añadirá la nueva vista
     * @param viewType, El tipo de vista de la nueva vista.
     */
    @Override
    public AgendaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle_de_agenda, parent, false);
        AgendaViewHolder agendaVH = new AgendaViewHolder(itemView);
        return agendaVH;
    }
    /**
     * Metodo que visualizar los datos en la posicion especifica
     * @param holder, la vista a ser visualizada
     * @param position, la posicion de la vista.
     */
    @Override
    public void onBindViewHolder(AgendaViewHolder holder, int position) {
        Agenda agenda = Agenda.get(position);
        holder.binAgenda(agenda);
    }
    /**
     * Metodo que permite contar los elemmentos de la lista
     * @return el tamaño de la lista
     */
    @Override
    public int getItemCount() {
        return Agenda.size();
    }

    public static class AgendaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtDependencia;
        private TextView numero;
        private TextView extencion;
        /**
         * Metodo contructor de la vista de tipo agenda
         * @param itemView, el item de la lista
         */
        public AgendaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtDependencia = (TextView) itemView.findViewById(R.id.dependencia);
            numero = (TextView) itemView.findViewById(R.id.numero);
            extencion = (TextView) itemView.findViewById(R.id.extencion);

        }
        /**
         * Metodo que permite modificar los atributos de la agenda
         * @paraman, la agenda
         */
        public void binAgenda(Agenda a) {
            txtDependencia.setText(a.getDependencia());
            numero.setText(a.getNumero());
            extencion.setText(a.getExtencion());
        }
        /**
         * Metodo que permite identificar el item de la vista presionado
         * @param v, la vista del evento
         */
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtDependencia.getText());
        }
    }
    public interface OnClickAdaptadorDeAgenda{
        public void onClickPosition(int pos);
    }

}
