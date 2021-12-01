package com.example.trabajo_n2_jaime;

public class Lugar {

        public String IDAutor;
        public String NombreLugar;
        public String DireccionLugar;

        public Lugar() {
            this.IDAutor = "";
            this.NombreLugar = "";
            this.DireccionLugar = "";

        }

        public Lugar(String IDAutor, String nombreLugar, String direccionLugar) {
            this.IDAutor = IDAutor;
            NombreLugar = nombreLugar;
            DireccionLugar = direccionLugar;
        }

        public String getIDAutor() {
            return IDAutor;
        }

        public void setIDAutor(String IDAutor) {
            this.IDAutor = IDAutor;
        }

        public String getNombreLugar() {
            return NombreLugar;
        }

        public void setNombreLugar(String nombreLugar) {
            NombreLugar = nombreLugar;
        }

        public String getDireccionLugar() {
            return DireccionLugar;
        }

        public void setDireccionLugar(String direccionLugar) {
            DireccionLugar = direccionLugar;
        }

        @Override
        public String toString() {
            return "Lugar{" +
                    "IDAutor='" + IDAutor + '\'' +
                    ", NombreLugar='" + NombreLugar + '\'' +
                    ", DireccionLugar='" + DireccionLugar + '\'' +
                    '}';
        }
    }



