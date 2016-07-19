package lu.intech.Billetterie.repository;


import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VORtEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;

import java.util.List;

/**
 * Created by Adriano on 11/07/16.
 */
public interface Repository {

    List<OffreEntity> getAllOffers();
    List<VORtEntity> getDisponibility(int x);
    void postOffer(OffreEntity o);
    List<VendeursEntity> getAllVendeurs();
    List<VORtEntity> getAllDisponibility();
    void modifDisp(int idOffre,int idVendeur, int quantite);

}
