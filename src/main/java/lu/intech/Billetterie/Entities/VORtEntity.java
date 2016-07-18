package lu.intech.Billetterie.Entities;

import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;

import javax.persistence.*;

/**
 * Created by Adriano on 12/07/16.
 */
@Entity
@Table(name = "V_O_RT")
public class VORtEntity {

    @Id
    private Integer idVORtEntity;


    @ManyToOne
    private VendeursEntity vendeur;

    @ManyToOne
    private OffreEntity offre;



    @Basic
    @Column(name = "Quantite", columnDefinition = "0",nullable = true)
    private Integer quantite;



    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }





    public Integer getIdVORtEntity() {
        return idVORtEntity;
    }

    public void setIdVORtEntity(Integer idVORtEntity) {
        this.idVORtEntity = idVORtEntity;
    }

    public OffreEntity getOffre() {
        return offre;
    }

    public void setOffre(OffreEntity offre) {
        this.offre = offre;
    }

    public VendeursEntity getVendeur() {
        return vendeur;
    }

    public void setVendeur(VendeursEntity vendeur) {
        this.vendeur = vendeur;
    }
}
