package icanwalk.ordonez.roger.icanwalk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Event> eventos;
    RecyclerView recyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("eventos");
/*    private String nom;
    private String direccio;
    private String creador;
    private Latlon posicio;
    private Date data;
    private List<String> usuarisRegistrats;
    private double preu;
    private double limitUsuaris;
    private String descripcioCurta;
    private String descripcioLlarga;
    private Latlon geolocalitzacio;

        Date data = new Date();
        List<String> usuaris= new ArrayList<String>();
        usuaris.add("usuari1");
        usuaris.add("usuari2");
        Event event = new Event("roger","direccio","creador",new Latlon(3.0,4.0),data,usuaris,30.0,10.0,"descripcio Curta","descripcio LLarga",new Latlon(3.0,5.0));

        // myRef.setValue(event);

        myRef.push().setValue(event);
        // Read from the database
        /*
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Event value = dataSnapshot.getValue(Event.class);
                Toast.makeText(getContext(), value.gestNom(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });
*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_events, container, false);
        eventos = new ArrayList<>();
        recyclerView=view.findViewById(R.id.eventsID);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        EventsAdapter adapter = new EventsAdapter(eventos);
        PopulateEventos(adapter);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), eventos.get(recyclerView.getChildAdapterPosition(v)).getNom(), Toast.LENGTH_SHORT).show();
                int itemPosition = recyclerView.getChildLayoutPosition(v);
                Fragment frag = DetalleEvento.newInstance(itemPosition);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void PopulateEventos(final EventsAdapter adapter) {
        /*
        * new Event("roger","direccio","creador",new Latlon(3.0,4.0),data,usuaris,30.0,10.0,"descripcio Curta","descripcio LLarga",new Latlon(3.0,5.0));

         *
        Date data = new Date();
        List<String> usuaris= new ArrayList<String>();
        usuaris.add("usuari1");
        usuaris.add("usuari2");
        eventos.add(new Event("roger","direccio","creador",new Latlon(3.0,4.0),data,usuaris,30.0,10.0,"descripcio Curta","descripcio LLarga",new Latlon(3.0,5.0)));
        eventos.add(new Event("Puntacana","direccio","creador",new Latlon(3.0,4.0),data,usuaris,30.0,10.0,"descripcio Curta","descripcio LLarga",new Latlon(3.0,5.0)));
        */
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("eventos");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventos.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Event event = snapshot.getValue(Event.class);
                    eventos.add(event);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
