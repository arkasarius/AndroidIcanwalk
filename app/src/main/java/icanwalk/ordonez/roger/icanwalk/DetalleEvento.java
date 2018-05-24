package icanwalk.ordonez.roger.icanwalk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetalleEvento.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetalleEvento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleEvento extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int positionEvento;
    ArrayList<Event> eventos;
    ArrayList<String> UIDS;
    private OnFragmentInteractionListener mListener;

    public DetalleEvento() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleEvento.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleEvento newInstance(String param1, String param2) {
        DetalleEvento fragment = new DetalleEvento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static  DetalleEvento newInstance(int exampleInt) {
        DetalleEvento fragment = new DetalleEvento();

        Bundle args = new Bundle();
        args.putInt("exampleInt", exampleInt);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            positionEvento = getArguments().getInt("exampleInt",-1);
           // Toast.makeText(getContext(), Integer.toString(positionEvento), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ///display info data

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("eventos");
        eventos = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventos.clear();
                UIDS=new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UIDS.add(snapshot.getKey());
                    Event event = snapshot.getValue(Event.class);
                    eventos.add(event);
                }
                Event a = eventos.get(positionEvento);
                //Toast.makeText(getContext(), Integer.toString(positionEvento), Toast.LENGTH_SHORT).show();
                TextView nomevent,direccio,dataevent,usuaricreador,descripcio,usuaris;
                nomevent=getActivity().findViewById(R.id.idnomevent);
                direccio=getActivity().findViewById(R.id.iddireccio);
                dataevent=getActivity().findViewById(R.id.iddata);
                usuaricreador=getActivity().findViewById(R.id.idcreador);
                descripcio=getActivity().findViewById(R.id.iddescripcio);
                usuaris=getActivity().findViewById(R.id.idusers);
                Button button = getActivity().findViewById(R.id.buto);
                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        //Toast.makeText(getContext(), UIDS.get(positionEvento), Toast.LENGTH_SHORT).show();
                        eventos.get(positionEvento);
                        String theID = UIDS.get(positionEvento);
                        Event x =eventos.get(positionEvento);
                        List<String> popu = x.getUsuarisRegistrats();
                        popu.add("rogerAndroid");
                        x.setUsuarisRegistrats(popu);
                        Toast.makeText(getContext(), Integer.toString(popu.size()), Toast.LENGTH_SHORT).show();
                        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                        mDatabase.child("eventos").child(theID).child("usuarisRegistrats").child(Integer.toString(popu.size()-1)).setValue("rogerproaso");



                        //myRef.getKey();
                    }
                });

                nomevent.setText(a.getNom());
                direccio.setText(a.getDireccio());
                dataevent.setText(a.getDiaMesAny()+"  "+a.getTimeHoraMinutes());
                usuaricreador.setText(a.getCreador());
                descripcio.setText(a.getDescripcioLlarga());
                usuaris.setText(a.getUsuarisRegistrats().size()+"/"+a.getLimitUsuaris());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return inflater.inflate(R.layout.fragment_detalle_evento, container, false);
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

    @Override
    public void onClick(View v) {

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
