package lu.intech.Billetterie.Entities;

import javax.persistence.*;

/**
 * Created by Adriano on 11/07/16.
 */
@Entity
@Table(name = "Offre")
public class OffreEntity {

    private int idOffre;


    private String titre;
    private Integer prixPublic;
    private Integer prixCfl;
    private String link;
    private Integer commande;
    private String imgUrl;
    private String description;


    @Id
    @Column(name = "idOffre", nullable = false)
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Basic
    @Column(name = "Titre", nullable = true, length = 45)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "PrixPublic", nullable = false)
    public Integer getPrixPublic() {
        return prixPublic;
    }

    public void setPrixPublic(Integer prixPublic) {
        this.prixPublic = prixPublic;
    }

    @Basic
    @Column(name = "PrixCFL", nullable = false)
    public Integer getPrixCfl() {
        return prixCfl;
    }

    public void setPrixCfl(Integer prixCfl) {
        this.prixCfl = prixCfl;
    }

    @Basic
    @Column(name = "Link", nullable = true, length = 245)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "commande", nullable = true, columnDefinition = "INTEGER DEFAULT 0 ")
    public Integer getCommande() {
        return commande;
    }

    public void setCommande(Integer commande) {
        this.commande = commande;
    }

    @Basic
    @Column(name = "imgUrl", nullable = true, length = 245,columnDefinition = "VARCHAR(245) DEFAULT 'https://cdn1.iconfinder.com/data/icons/school-supplies-3/64/folder_denied_stop_not_found_deleted_error-128.png'")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 105)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffreEntity that = (OffreEntity) o;

        if (idOffre != that.idOffre) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (prixPublic != null ? !prixPublic.equals(that.prixPublic) : that.prixPublic != null) return false;
        if (prixCfl != null ? !prixCfl.equals(that.prixCfl) : that.prixCfl != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (commande != null ? !commande.equals(that.commande) : that.commande != null) return false;
        if (imgUrl != null ? !imgUrl.equals(that.imgUrl) : that.imgUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOffre;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + (prixPublic != null ? prixPublic.hashCode() : 0);
        result = 31 * result + (prixCfl != null ? prixCfl.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (commande != null ? commande.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}
