package com.evertvd.pukapp.modelo;

/**
 * Created by evertvd on 03/11/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cliente {

    @SerializedName("idcliente_proveedor")
    @Expose
    private String idclienteProveedor;
    @SerializedName("ruc")
    @Expose
    private String ruc;
    @SerializedName("razon")
    @Expose
    private String razon;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("estado")
    @Expose
    private String estado;

    public String getIdclienteProveedor() {
        return idclienteProveedor;
    }

    public void setIdclienteProveedor(String idclienteProveedor) {
        this.idclienteProveedor = idclienteProveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}