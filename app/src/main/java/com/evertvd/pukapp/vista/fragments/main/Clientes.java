package com.evertvd.pukapp.vista.fragments.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.evertvd.pukapp.R;

import com.evertvd.pukapp.interfaces.ClienteService;
import com.evertvd.pukapp.modelo.Cliente;
import com.evertvd.pukapp.vista.adapters.ClienteAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class Clientes extends Fragment {

    private TabLayout tabLayout;
    private View view;
    private  final String baseUrl="https://pukapp.000webhostapp.com/";
    private List<Cliente>clienteList;
    ClienteAdapter adapter;
    RecyclerView recycler;
    RecyclerView.LayoutManager lManager;
    public Clientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_proveedores, container, false);
        tabLayout=(TabLayout)getActivity().findViewById(R.id.tabs);
        tabLayout.setVisibility(View.GONE);





        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClienteService clienteService=retrofit.create(ClienteService.class);
        final Call<List<Cliente>> lista = clienteService.getCliente();
        lista.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if(response.isSuccessful()){
                    clienteList=response.body();
                    //Log.e("TAG",String.valueOf(clienteList.size()));

                    //adapter=new ClienteAdapter(clienteList, getActivity());
                    //recycler.setAdapter(adapter);
                    //recycler.setItemAnimator(new DefaultItemAnimator());
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Log.e("TAG",String.valueOf("error"));
            }
        });

        for (int i=0;i<clienteList.size();i++){
            Log.e("DATO", clienteList.get(i).getDireccion());
        }

        String[] array = new String[] {
                "Elemento 1"
                ,"Elemento 2"
                ,"Elemento 3"
                ,"Elemento 4"
                ,"Elemento 5"
                ,"Elemento 6"
        };

        ListAdapter adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array);
        //Asociamos el adaptador a la vista.
        ListView lv = (ListView)view.findViewById(android.R.id.list);
        lv.setAdapter(adaptador);



/*
        recycler = (RecyclerView)view.findViewById(R.id.recylcerClientes);
        recycler.setHasFixedSize(true);
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter=new ClienteAdapter(clienteList, getActivity());
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    */

        return view;
    }

}
