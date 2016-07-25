package lu.intech.Billetterie.repository;


import lu.intech.Billetterie.Entities.LogEntity;
import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VORtEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;
import lu.intech.Billetterie.api.Vente;
import org.apache.commons.lang3.tuple.Pair;

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
    void modifOffre(OffreEntity o);
    void delOffre(int idOffre);
    List<Pair<VendeursEntity,VORtEntity>> getDisponibility2(int idOffre );
    void executeVente(Vente v);
    List<LogEntity> getHistorique();

}
