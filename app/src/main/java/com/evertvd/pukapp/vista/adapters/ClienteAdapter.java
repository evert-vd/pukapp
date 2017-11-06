package com.evertvd.pukapp.vista.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evertvd.pukapp.R;
import com.evertvd.pukapp.interfaces.ItemClickListener;
import com.evertvd.pukapp.modelo.Cliente;

import java.util.List;

/**
 * Created by Evertvd on 5/11/2017.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> implements ItemClickListener{

    private Context context;
    private List<Cliente> clienteList;

    public ClienteAdapter(List<Cliente>clienteList, Context context){
        this.context=context;
        this.clienteList=clienteList;
    }


    @Override
    public ClienteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar el view (list_item_cliente)
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_cliente,parent,false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //se setea los datos al adapter
        try {

            //holder.txtRuc.setText(clienteList.get(position).getRuc());
            //holder.txtRazon.setText(clienteList.get(position).getRazon());

        }catch (Exception e){
            Log.e("ERROR", "Error al cargar el adapter clientes");
        }


    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }

    @Override
    public void onItemClick(View view, int position) {
        //direcciona la ruta al hacer click
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //se referencia a los datos del xml
        public ItemClickListener listener;

        TextView txtRuc, txtRazon;


        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);


            this.listener=listener;
            this.txtRuc=(TextView)itemView.findViewById(R.id.txtRuc);
            this.txtRazon=(TextView)itemView.findViewById(R.id.txtRazon);

            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getAdapterPosition());
        }
    }
}
