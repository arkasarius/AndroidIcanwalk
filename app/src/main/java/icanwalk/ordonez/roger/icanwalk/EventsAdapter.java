package icanwalk.ordonez.roger.icanwalk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {


    ArrayList<Event> eventos;

    public EventsAdapter(ArrayList<Event> events){
        eventos=events;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {
        holder.titulo.setText(eventos.get(position).getNom());
        holder.dia.setText(eventos.get(position).getDiaMesAny());
        holder.hora.setText(eventos.get(position).getTimeHoraMinutes());
        holder.direccio.setText(eventos.get(position).getDireccio());
        holder.descripcio.setText(eventos.get(position).getDescripcioCurta());
        holder.preu.setText(Double.toString(eventos.get(position).getPreu()));
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo,dia,hora,direccio,descripcio,preu;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.titulo);
            dia=itemView.findViewById(R.id.diaMesAny);
            hora=itemView.findViewById(R.id.timeHourMinute);
            direccio=itemView.findViewById(R.id.direcction);
            descripcio=itemView.findViewById(R.id.descriptionShort);
            preu=itemView.findViewById(R.id.pr);
        }
    }
}
