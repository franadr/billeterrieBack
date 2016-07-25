package lu.intech.Billetterie.repository;




import lu.intech.Billetterie.Entities.LogEntity;
import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VORtEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;
import lu.intech.Billetterie.api.Vente;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Pair<VendeursEntity,VORtEntity>> getDisponibility2(int idOffre ) {
        Query query = em.createQuery("Select e,v from VendeursEntity e left join VORtEntity v where v.offre.idOffre = :idOffre");
        query.setParameter("idOffre",idOffre);

        List<Object[]> disp = query.getResultList();

        return disp.stream().map( objects -> new ImmutablePair<>( (VendeursEntity)objects[0], (VORtEntity)objects[1]))
                .collect(Collectors.toList());

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
    Query query = em.createQuery("UPDATE OffreEntity v set v.commande = :commande, v.imgUrl=:imgurl, v.link=:link, v.prixCfl=:prixCfl, v.prixPublic=:prixPublic, v.titre=:titre where v.idOffre=:idOffre");
        query.setParameter("commande",o.getCommande());
        query.setParameter("imgurl",o.getImgUrl());
        query.setParameter("link",o.getLink());
        query.setParameter("prixCfl",o.getPrixCfl());
        query.setParameter("prixPublic",o.getPrixPublic());
        query.setParameter("idOffre",o.getIdOffre());
        query.setParameter("titre",o.getTitre());

        query.executeUpdate();
        System.out.println("modifOffre executed");


    }

    @Override
    public void delOffre(int idOffre) {


        Query query = em.createQuery("delete from VORtEntity v where v.offre.idOffre = :idOffre");
        query.setParameter("idOffre",idOffre);
        Query query1=em.createQuery("delete from OffreEntity o where o.idOffre = :idOffre");
        query1.setParameter("idOffre",idOffre);
        query.executeUpdate();
        query1.executeUpdate();
    }

    @Override
    public void executeVente(Vente v) {
        LogEntity l = new LogEntity();
        Date currentdate = new Date();
        Query query =em.createQuery("UPDATE VORtEntity v set v.quantite = v.quantite - :quantite where v.offre.idOffre=:idOffre and v.vendeur.idVendeur=:idVendeur");
        query.setParameter("quantite",v.getQuantite());
        query.setParameter("idOffre",v.getOffre().getIdOffre());
        query.setParameter("idVendeur",v.getVendeur().getIdVendeur());
        query.executeUpdate();

        Query query2 = em.createQuery("UPDATE VendeursEntity v set v.solde=v.solde + :solde where v.idVendeur=:idVendeur");
        int solde = v.getQuantite()*v.getPrixCfl();
        query2.setParameter("solde",solde);
        query2.setParameter("idVendeur",v.getVendeur().getIdVendeur());
        query2.executeUpdate();

        l.setDate(currentdate);
        l.setOperation(v.getTrigramme()+ " a acheté "+v.getQuantite()+" "+v.getOffre().getTitre()+" à "+v.getVendeur().getPrenom()+" "+v.getVendeur().getNom()+" ("+v.getVendeur().getLocation()+")");

        em.persist(l);
    }

    @Override
    public List<LogEntity> getHistorique() {
        TypedQuery<LogEntity> query = em.createQuery("SELECT h from LogEntity h",LogEntity.class);
        List<LogEntity> historique= query.getResultList();

        return historique;
    }

}
