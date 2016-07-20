package lu.intech.Billetterie.repository;




import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VORtEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Adriano on 11/07/16.
 */
@Transactional
public class JPARespository implements Repository {
    @PersistenceContext
    EntityManager em ;


    @Override
    public List<OffreEntity> getAllOffers() {
        TypedQuery<OffreEntity> query = em.createQuery("SELECT o from OffreEntity o",OffreEntity.class);
        List<OffreEntity> ofr = query.getResultList();

        return ofr;
    }

    @Override
    public List<VORtEntity> getDisponibility(int idOffre ) {
        TypedQuery<VORtEntity> query = em.createQuery("Select v from VORtEntity v where v.offre.idOffre= :idOffre",VORtEntity.class);
        query.setParameter("idOffre",idOffre);
        List<VORtEntity> disp =query.getResultList();


        return disp;
    }

    @Override
    public void postOffer(OffreEntity o)  {

        em.persist(o);

    }

    @Override
    public List<VendeursEntity> getAllVendeurs() {
        TypedQuery<VendeursEntity> query = em.createQuery("Select v from VendeursEntity v",VendeursEntity.class);
        List<VendeursEntity> vendeurs= query.getResultList();

        return vendeurs;
    }

    @Override
    public List<VORtEntity> getAllDisponibility() {
        TypedQuery<VORtEntity> query = em.createQuery("Select v from VORtEntity v ",VORtEntity.class);

        List<VORtEntity> disp =query.getResultList();


        return disp;
    }

    @Override
    public void modifDisp(int idOffre, int idVendeur, int quantite) {
        Query query = em.createQuery("UPDATE VORtEntity v set v.quantite = :quantite where v.offre.idOffre=:idOffre and v.vendeur.idVendeur=:idVendeur");
        query.setParameter("quantite",quantite);
        query.setParameter("idOffre",idOffre);
        query.setParameter("idVendeur",idVendeur);
        query.executeUpdate();
    }

    @Override
    public void modifOffre(OffreEntity o) {
    Query query = em.createQuery("UPDATE OffreEntity v set v.commande = :commande, v.imgUrl=:imgurl, v.link=:link, v.prixCfl=:prixCfl, v.prixPublic=:prixPublic where v.idOffre=:idOffre");
        query.setParameter("commande",o.getCommande());
        query.setParameter("imgurl",o.getImgUrl());
        query.setParameter("link",o.getLink());
        query.setParameter("prixCfl",o.getPrixCfl());
        query.setParameter("prixPublic",o.getPrixPublic());
        query.setParameter("idOffre",o.getIdOffre());

        query.executeUpdate();
        System.out.println("modifOffre executed");


    }


}
