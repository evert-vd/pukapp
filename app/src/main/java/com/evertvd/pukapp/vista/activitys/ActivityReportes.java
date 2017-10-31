package com.evertvd.pukapp.vista.activitys;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.evertvd.pukapp.R;
import com.evertvd.pukapp.vista.fragments.main.ContainerVentas;
import com.evertvd.pukapp.vista.fragments.reportes.Compras;

public class ActivityReportes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, new Compras());
        ft.commit();

    }

}
