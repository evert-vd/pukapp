package com.evertvd.pukapp.vista.activitys;

import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.evertvd.pukapp.R;
import com.evertvd.pukapp.controller.controllerApi;
import com.evertvd.pukapp.vista.fragments.main.Clientes;
import com.evertvd.pukapp.vista.fragments.main.ContainerCompras;
import com.evertvd.pukapp.vista.fragments.main.ContainerVentas;
import com.evertvd.pukapp.vista.fragments.main.Proveedores;
import com.evertvd.pukapp.interfaces.ClienteService;
import com.evertvd.pukapp.modelo.Cliente;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //private  final String baseUrl="https://10.0.2.2:8080/";
    List<Cliente> clienteList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            startActivity(new Intent(this,ActivityReportes.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new ContainerVentas());
            ft.commit();

        } else if (id == R.id.nav_gallery) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new ContainerCompras());
            ft.commit();
        } else if (id == R.id.nav_slideshow) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new Clientes());
            ft.commit();
        } else if (id == R.id.nav_manage) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new Proveedores());
            ft.commit();

        } else if (id == R.id.nav_share) {

            Toast.makeText(this,"ckick en parametos",Toast.LENGTH_SHORT).show();
            /*
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
                        for (int i=0;i<clienteList.size();i++){
                            Log.e("Cliente",clienteList.get(i).getDireccion());
                        }
                }
                }

                @Override
                public void onFailure(Call<List<Cliente>> call, Throwable t) {
                    Log.e("TAG",String.valueOf("error"));
                }
            });
            */

            } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
