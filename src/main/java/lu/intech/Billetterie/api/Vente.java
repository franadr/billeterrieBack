package lu.intech.Billetterie.api;

/**
 * Created by Adriano on 25/07/16.
 */
public class Vente {
    Vendeurs vendeur;
    Offre offre;
    int quantite;
    int prixCfl;

    public Vendeurs getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeurs vendeur) {
        this.vendeur = vendeur;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrixCfl() {
        return prixCfl;
    }

    public void setPrixCfl(int prixCfl) {
        this.prixCfl = prixCfl;
    }

    public String getTrigramme() {
        return trigramme;
    }

    public void setTrigramme(String trigramme) {
        this.trigramme = trigramme;
    }

    String trigramme;
}
