package com.version2.euskogourmetpedro5.ui.notifications;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.version2.euskogourmetpedro5.R;
import com.version2.euskogourmetpedro5.databinding.FragmentNotificationsBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
LinearLayout filaruta;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
filaruta=binding.filaRutasNot;
        String enlace="http://192.168.122.1:8080/EjemploAPI_6/mostrar";
        JsonArrayRequest getRequest=new JsonArrayRequest(Request.Method.GET, enlace, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                filaruta.removeAllViews();

                for(int i=0;i<response.length();i++){


                    try {
                        Integer idrutas=response.getJSONObject(i).optInt("idrutas");
                        String titulo=response.getJSONObject(i).optString("titulo");
                        String ciudad=response.getJSONObject(i).optString("ciudad");
                        String url=response.getJSONObject(i).optString("url");
                        String descripcion=response.getJSONObject(i).optString("descripcion");
                        Boolean completado=response.getJSONObject(i).optBoolean("completado");

                        addCatalogue(inflater,titulo,ciudad,descripcion,url,completado,filaruta,idrutas);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("DEBUG", error.toString());

            }
        });

        Volley.newRequestQueue(getActivity()).add(getRequest);


        return root;
    }

    private void addCatalogue(LayoutInflater inflater, String titulo, String ciudad, String descripcion, String url, Boolean completado, LinearLayout filaruta, Integer idrutas) {

        View itemview=inflater.inflate(R.layout.ruta, binding.filaRutasNot,false);
        TextView tituloE=itemview.findViewById(R.id.titulotxt);
        TextView ciudadE=itemview.findViewById(R.id.ciudadtxt);
        TextView descripcionE=itemview.findViewById(R.id.descripciontxt);
        ImageView rutaI=itemview.findViewById(R.id.rutaI);
        Button updatebtn=itemview.findViewById(R.id.updatebtn);


        tituloE.setText(titulo);
        ciudadE.setText(ciudad);
        descripcionE.setText(descripcion);

        Picasso.get()
                .load(url)
                .into(rutaI);

        updatebtn.setBackgroundColor(Color.RED);
        if(completado){
            updatebtn.setBackgroundColor(Color.GREEN);
            updatebtn.setEnabled(false);

        }
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateRuta(idrutas);
                updatebtn.setBackgroundColor(Color.GREEN);
                updatebtn.setEnabled(false);

            }
        });

        filaruta.addView(itemview);


    }

    private void updateRuta(Integer idrutas) {



        HashMap<String,String> params=new HashMap<>();

        params.put("idrutas",String.valueOf(idrutas));


        String enlace="http://192.168.122.1:8080/EjemploAPI_6/actualizar";


        StringRequest postRequest=new StringRequest(Request.Method.POST, enlace, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(requireContext(),"exito",Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("DEBUG",error.toString());

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        Volley.newRequestQueue(getActivity()).add(postRequest);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}