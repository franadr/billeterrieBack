package lu.intech.Billetterie.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Adriano on 11/07/16.
 */

@XmlRootElement(name="dispVendeur")
public class DispoVendeur {

    private int idVendeur;
    private int idOffre;
    private String Nom;
    private String Prenom;
    private String Location;
    private int Quantite;

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }

    public int getIdVendeur() { return idVendeur; }

    public void setIdVendeur(int idVendeur) {this.idVendeur = idVendeur;}

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }
}
