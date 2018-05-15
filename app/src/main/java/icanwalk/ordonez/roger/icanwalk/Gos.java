package icanwalk.ordonez.roger.icanwalk;

public class Gos {


    /*
        Nom			[String]
        Usuari amo 		[Usuari ID]
        informació d'interés	[String]
        */
    private String nom;
    private String amo;
    private String bio;

    public Gos(){}
    public Gos(String nom, String amo, String bio) {
        this.nom = nom;
        this.amo = amo;
        this.bio = bio;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAmo() {
        return amo;
    }

    public void setAmo(String amo) {
        this.amo = amo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
