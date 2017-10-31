package com.evertvd.pukapp.vista.fragments.main;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.evertvd.pukapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompraFactura extends Fragment implements View.OnClickListener {

    private View view;
    private ImageButton imgAdd, imgClear;
    private ViewGroup layout;
    private int idLayout;
    RelativeLayout relativeLayout1,relativeLayout2,relativeLayout3,relativeLayout4,relativeLayout5;
    int i=0;

    public CompraFactura() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_compra_factura, container, false);

        layout = (ViewGroup)view.findViewById(R.id.layoutAdd);

        imgAdd =(ImageButton)view.findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(this);
        imgClear=(ImageButton)view.findViewById(R.id.imgClear);
        imgClear.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imgAdd){
            if(i<5){
                i++;
                addChild(i);
            }else{
                Toast.makeText(getActivity(),"Limite de detalle excedido", Toast.LENGTH_SHORT).show();
            }

        }else if(view.getId()==R.id.imgClear){
          if(i>0){
              removeChild(i);
              i--;
          }

        }
    }



    @SuppressLint("InlinedApi")
    private void addChild(int i)
    {
        Log.e("indicador+", String.valueOf(i));
        LayoutInflater inflater=LayoutInflater.from(getActivity());
        idLayout=R.layout.layout_add;

        if(i==1){
            relativeLayout1 = (RelativeLayout) inflater.inflate(idLayout, null, false);
            layout.addView(relativeLayout1);
        }else if(i==2){
            relativeLayout2 = (RelativeLayout) inflater.inflate(idLayout, null, false);
            layout.addView(relativeLayout2);
        }else if(i==3){
            relativeLayout3 = (RelativeLayout) inflater.inflate(idLayout, null, false);
            layout.addView(relativeLayout3);
        }else if(i==4){
            relativeLayout4 = (RelativeLayout) inflater.inflate(idLayout, null, false);
            layout.addView(relativeLayout4);
        }else if(i==5){
            relativeLayout5 = (RelativeLayout) inflater.inflate(idLayout, null, false);
            layout.addView(relativeLayout5);
        }

        /*
        TextView textView = (TextView) relativeLayout.findViewById(R.id.textViewDate);
        textView.setText(String.valueOf(System.currentTimeMillis()));
         */
    }

    private void removeChild(int i) {
        Log.e("indicador(-)", String.valueOf(i));
        if (i == 5) {
            layout.removeView(relativeLayout5);
        } else if (i == 4) {
            layout.removeView(relativeLayout4);

        } else if (i == 3) {
            layout.removeView(relativeLayout3);

        } else if (i == 2) {
            layout.removeView(relativeLayout2);

        } else if (i == 1) {
            layout.removeView(relativeLayout1);
        }
    }
}
