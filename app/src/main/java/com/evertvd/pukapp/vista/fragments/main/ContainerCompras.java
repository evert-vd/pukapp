package com.evertvd.pukapp.vista.fragments.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evertvd.pukapp.R;
import com.evertvd.pukapp.vista.adapters.AdapterViewPagerCompras;
import com.evertvd.pukapp.vista.adapters.AdapterViewPagerVentas;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContainerCompras extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;


    public ContainerCompras() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Documentos de Compra");
        view=inflater.inflate(R.layout.fragment_container_compras, container, false);

        tabLayout=(TabLayout)getActivity().findViewById(R.id.tabs);
        tabLayout.setVisibility(View.VISIBLE);
        //tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdapterViewPagerCompras(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}
