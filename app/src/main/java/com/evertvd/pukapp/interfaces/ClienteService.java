package com.evertvd.pukapp.interfaces;
import com.evertvd.pukapp.modelo.Cliente;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;


/**
 * Created by evertvd on 03/11/2017.
 */

public interface ClienteService {
    //@GET("api/cliente")
    //Call<List<Cliente>> getCliente ;
    @GET("api/clientes")
    Call<List<Cliente>> getCliente();
    //void getClientes(Callback<List<Cliente>> callback);

}
