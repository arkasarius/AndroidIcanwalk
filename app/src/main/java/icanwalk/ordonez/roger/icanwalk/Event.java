package icanwalk.ordonez.roger.icanwalk;

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
    Informació d’interes	[String]
    */
    private String nom;
    private String direccio;
    private String creador;
    private Latlon posicio;
}
