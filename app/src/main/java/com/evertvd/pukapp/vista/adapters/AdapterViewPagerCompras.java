package com.evertvd.pukapp.vista.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.evertvd.pukapp.vista.fragments.main.CompraBoleta;
import com.evertvd.pukapp.vista.fragments.main.CompraFactura;
import com.evertvd.pukapp.vista.fragments.main.CompraOtro;

/**
 * Created by evertvd on 31/10/2017.
 */

public class AdapterViewPagerCompras extends FragmentPagerAdapter {

        public AdapterViewPagerCompras(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0)
            {
                fragment = new CompraFactura();
            }
            else if (position == 1)
            {
                fragment = new CompraBoleta();
            }
            else if (position == 2)
            {
                fragment = new CompraOtro();
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

