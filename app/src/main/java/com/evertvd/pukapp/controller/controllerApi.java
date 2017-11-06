package com.evertvd.pukapp.controller;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.evertvd.pukapp.R;
import com.evertvd.pukapp.interfaces.ClienteService;
import com.evertvd.pukapp.modelo.Cliente;
import com.evertvd.pukapp.vista.adapters.ClienteAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by evertvd on 03/11/2017.
 */

public class controllerApi implements Callback<List<Cliente>> {

    static final String BASE_URL = "https://pukapp.000webhostapp.com/";

    ClienteAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private Context context;
    private View view;

    public void start(Context context, View view) {
        this.context=context;
        this.view=view;
        Gson gson = new GsonBuilder()
        .setLenient()
        .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ClienteService gerritAPI = retrofit.create(ClienteService.class);

        Call<List<Cliente>> call = gerritAPI.getCliente();
        call.enqueue(this);


    }



    @Override
    public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
        if(response.isSuccessful()) {
            List<Cliente> clienteList = response.body();


            //adapter.notifyDataSetChanged();


           // fastScroller.setRecyclerView(recyclerView);

        } else {
            Log.e("TAG2", String.valueOf(response.errorBody()));

            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Cliente>> call, Throwable t) {
        t.printStackTrace();
        Log.e("TAG3", "error");
    }
}

