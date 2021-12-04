package com.example.trabajo_n2_jaime.Clases;

public class Lugar {

    private String idAutor;
    private String eTDireccion;
    private String eTNombre;

    public Lugar()
    {
        this.idAutor="";
        this.eTNombre="";
        this.eTDireccion="";
    }

    public Lugar( String idAutor, String eTNombre, String eTDireccion )
    {
        this.idAutor=idAutor;
        this.eTNombre=eTNombre;
        this.eTDireccion=eTDireccion;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String geteTNombre() {
        return eTNombre;
    }

    public void seteTNombre(String eTNombre) {
        this.eTNombre = eTNombre;
    }

    public String geteTDireccion() {
        return eTDireccion;
    }

    public void seteTDireccion(String eTDireccion) {
        this.eTDireccion = eTDireccion;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor='" + idAutor + '\'' +
                ", eTNombre='" + eTNombre + '\'' +
                ", eTDireccion='" + eTDireccion + '\'' +
                '}';
    }
}

