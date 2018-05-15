package icanwalk.ordonez.roger.icanwalk;

import java.util.Date;
import java.util.List;

public class Event {




    /*
            Nom event		[string]
            Nom direcció		[String]
            Usuari creador		[Usuari ID]
            Posició (lat/long)	[Double,Double]
            Data			[dd, mm, yyyy, hh, mm, ss]
            Llista usuaris registrats	[Usuari IDs]
            preu			[Float]
            limit usuaris		[Int]
            Informació d’interes	[String] --> descripccioCurta, descripcio LLarga
            */
    private String nom;
    private String direccio;
    private String creador;
    private Latlon posicio;
    private Date data;
    private List<String> usuarisRegistrats;
    private double preu;
    private double limitUsuaris;
    private String descripcioCurta;
    private String descripcioLlarga;
    private Latlon geolocalitzacio;

    public Event(){}
    public Event(String nom, String direccio, String creador, Latlon posicio, Date data, List<String> usuarisRegistrats, double preu, double limitUsuaris, String descripcioCurta, String descripcioLlarga, Latlon geolocalitzacio) {
        this.nom = nom;
        this.direccio = direccio;
        this.creador = creador;
        this.posicio = posicio;
        this.data = data;
        this.usuarisRegistrats = usuarisRegistrats;
        this.preu = preu;
        this.limitUsuaris = limitUsuaris;
        this.descripcioCurta = descripcioCurta;
        this.descripcioLlarga = descripcioLlarga;
        this.geolocalitzacio = geolocalitzacio;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public Latlon getPosicio() {
        return posicio;
    }

    public void setPosicio(Latlon posicio) {
        this.posicio = posicio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<String> getUsuarisRegistrats() {
        return usuarisRegistrats;
    }

    public void setUsuarisRegistrats(List<String> usuarisRegistrats) {
        this.usuarisRegistrats = usuarisRegistrats;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public double getLimitUsuaris() {
        return limitUsuaris;
    }

    public void setLimitUsuaris(double limitUsuaris) {
        this.limitUsuaris = limitUsuaris;
    }

    public String getDescripcioCurta() {
        return descripcioCurta;
    }

    public void setDescripcioCurta(String descripcioCurta) {
        this.descripcioCurta = descripcioCurta;
    }

    public String getDescripcioLlarga() {
        return descripcioLlarga;
    }

    public void setDescripcioLlarga(String descripcioLlarga) {
        this.descripcioLlarga = descripcioLlarga;
    }

    public Latlon getGeolocalitzacio() {
        return geolocalitzacio;
    }

    public void setGeolocalitzacio(Latlon geolocalitzacio) {
        this.geolocalitzacio = geolocalitzacio;
    }
}
