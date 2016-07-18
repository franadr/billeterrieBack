package lu.intech.Billetterie.api;

/**
 * Created by Adriano on 11/07/16.
 */
public class Offre {
    private int idOffre;
    private String titre;
    private Integer prixPublic;
    private Integer prixCfl;
    private String link;
    private Integer commande;
    private String imgUrl;
    private String description;

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getPrixPublic() {
        return prixPublic;
    }

    public void setPrixPublic(Integer prixPublic) {
        this.prixPublic = prixPublic;
    }

    public Integer getPrixCfl() {
        return prixCfl;
    }

    public void setPrixCfl(Integer prixCfl) {
        this.prixCfl = prixCfl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getCommande() {
        return commande;
    }

    public void setCommande(Integer commande) {
        this.commande = commande;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
