package com.evertvd.pukapp.vista.fragments.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evertvd.pukapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Clientes extends Fragment {

    private TabLayout tabLayout;
    private View view;

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

        return view;
    }

}
