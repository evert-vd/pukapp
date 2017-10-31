package com.evertvd.pukapp.vista.fragments.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evertvd.pukapp.R;
import com.evertvd.pukapp.vista.adapters.AdapterViewPagerVentas;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContainerVentas extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;


    public ContainerVentas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Documentos de Venta");
        view=inflater.inflate(R.layout.fragment_container_ventas, container, false);

        tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);//acceder al tablayout del activity, xq solo tiene al viewpaager
        tabLayout.setVisibility(View.VISIBLE);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdapterViewPagerVentas(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}
