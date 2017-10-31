package com.evertvd.pukapp.vista.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.evertvd.pukapp.vista.fragments.main.VentaBoleta;
import com.evertvd.pukapp.vista.fragments.main.VentaFactura;
import com.evertvd.pukapp.vista.fragments.main.VentaOtro;

/**
 * Created by evertvd on 31/10/2017.
 */

public class AdapterViewPagerVentas extends FragmentPagerAdapter {

        public AdapterViewPagerVentas(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0)
            {
                fragment = new VentaFactura();
            }
            else if (position == 1)
            {
                fragment = new VentaBoleta();
            }
            else if (position == 2)
            {
                fragment = new VentaOtro();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if (position == 0)
            {
                title = "Factura";
            }
            else if (position == 1)
            {
                title = "Boleta";
            }
            else if (position == 2)
            {
                title = "Otro";
            }
            return title;
        }
    }

