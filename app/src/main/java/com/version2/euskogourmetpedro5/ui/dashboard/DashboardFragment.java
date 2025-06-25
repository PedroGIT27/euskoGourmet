package com.version2.euskogourmetpedro5.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.version2.euskogourmetpedro5.databinding.FragmentDashboardBinding;

import java.util.HashMap;
import java.util.Map;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button sendbtn=binding.sendbtn;

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titulo=binding.tituloE.getText().toString();
                String ciudad=binding.ciudadE.getText().toString();
                String url=binding.urlE.getText().toString();
                String descripcion=binding.descripcionE.getText().toString();

                if(titulo.isEmpty()||ciudad.isEmpty()||url.isEmpty()||descripcion.isEmpty()){

                    return;
                }

                aniadirRuta(titulo,ciudad,url,descripcion);


            }
        });





        return root;
    }

    private void aniadirRuta(String titulo, String ciudad, String url, String descripcion) {


        HashMap<String,String> params=new HashMap<>();

        params.put("titulo",titulo);
        params.put("ciudad",ciudad);
        params.put("url",url);
        params.put("descripcion",descripcion);

        String enlace="http://192.168.122.1:8080/EjemploAPI_6/aniadir";


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