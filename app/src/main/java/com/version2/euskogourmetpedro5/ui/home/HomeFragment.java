package com.version2.euskogourmetpedro5.ui.home;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.version2.euskogourmetpedro5.R;
import com.version2.euskogourmetpedro5.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
LinearLayout filaRuta;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
filaRuta=binding.filaRuta;

        String enlace="http://192.168.122.1:8080/EjemploAPI_6/mostrar";
        JsonArrayRequest getRequest=new JsonArrayRequest(Request.Method.GET, enlace, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                filaRuta.removeAllViews();

                for(int i=0;i<response.length();i++){


                    try {
                        Integer idrutas=response.getJSONObject(i).optInt("idrutas");
                        String titulo=response.getJSONObject(i).optString("titulo");
                        String ciudad=response.getJSONObject(i).optString("ciudad");
                        String url=response.getJSONObject(i).optString("url");
                        String descripcion=response.getJSONObject(i).optString("descripcion");
                        Boolean completado=response.getJSONObject(i).optBoolean("completado");

                   addCatalogue(inflater,titulo,ciudad,descripcion,url,completado,filaRuta);

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

    private void addCatalogue(LayoutInflater inflater, String titulo, String ciudad, String descripcion, String url, Boolean completado, LinearLayout filaRuta) {

    View itemview=inflater.inflate(R.layout.ruta, binding.filaRuta,false);
    TextView tituloE=itemview.findViewById(R.id.titulotxt);
        TextView ciudadE=itemview.findViewById(R.id.ciudadtxt);
        TextView descripcionE=itemview.findViewById(R.id.descripciontxt);
        ImageView rutaI=itemview.findViewById(R.id.rutaI);
        Button updatebtn=itemview.findViewById(R.id.updatebtn);

        updatebtn.setVisibility(View.INVISIBLE);
        tituloE.setText(titulo);
        ciudadE.setText(ciudad);
        descripcionE.setText(descripcion);

        Picasso.get()
                .load(url)
                .into(rutaI);

filaRuta.addView(itemview);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}