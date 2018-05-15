package icanwalk.ordonez.roger.icanwalk;

import java.util.List;

public class User {


    /*
        Identificador 		[ID]
        Nom 			[String]
        Cognoms 		[String,String] --> cognom1 cognom2
        Correo electrónic 	[ID] [String]
        Contrasenya		[String]
        Llista d’events registrats [Event IDs]
        Llista de gossos 		[Gos IDs]
        Llista de contactes 	[Usuaris IDs]
        Usuari / empresa 	[Bool]
        Bio			[String]
    */


    private String nom;
    private String cognom1;
    private String cognom2;
    private String correo;
    private String contrasenya;
    private List<Event> events;
    private List<Gos> gossos;
    private List<Contacts> contactes;
    private boolean empresa;
    private String bio;

    //Constructor
    public User(){}
    public User(String nom, String cognom1, String cognom2, String correo, String contrasenya, List<Event> events, List<Gos> gossos, List<Contacts> contactes, boolean empresa, String bio) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.events = events;
        this.gossos = gossos;
        this.contactes = contactes;
        this.empresa = empresa;
        this.bio = bio;
    }

    //methods

    public String getCorreoForId(){
        return this.correo.replaceAll("\\.", "%2E");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Gos> getGossos() {
        return gossos;
    }

    public void setGossos(List<Gos> gossos) {
        this.gossos = gossos;
    }

    public List<Contacts> getContactes() {
        return contactes;
    }

    public void setContactes(List<Contacts> contactes) {
        this.contactes = contactes;
    }

    public boolean isEmpresa() {
        return empresa;
    }

    public void setEmpresa(boolean empresa) {
        this.empresa = empresa;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}
