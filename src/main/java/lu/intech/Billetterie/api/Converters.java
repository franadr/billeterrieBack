package lu.intech.Billetterie.api;


import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VORtEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;


/**
 * Created by Adriano on 11/07/16.
 */
public class Converters {

    public static Offre offreToEntity(OffreEntity e) {

        Offre ofr = new Offre();
        ofr.setIdOffre(e.getIdOffre());
        ofr.setCommande(e.getCommande());
        ofr.setLink(e.getLink());
        ofr.setPrixCfl(e.getPrixCfl());
        ofr.setPrixPublic(e.getPrixPublic());
        ofr.setTitre(e.getTitre());
        ofr.setImgUrl(e.getImgUrl());
        ofr.setDescription(e.getDescription());

        return ofr;

    }

    public static DispoVendeur VORtoEntity(VORtEntity e) {
        DispoVendeur disp = new DispoVendeur();
        disp.setNom(e.getVendeur().getNom());
        disp.setLocation(e.getVendeur().getLocation());
        disp.setPrenom(e.getVendeur().getPrenom());
        disp.setQuantite(e.getQuantite());

        return disp;
    }

    public static Vendeurs vendeursToEntity(VendeursEntity e){
        Vendeurs v = new Vendeurs();
        v.setNom(e.getNom());
        v.setIdVendeur(e.getIdVendeur());
        v.setLocation(e.getLocation());
        v.setPrenom(e.getPrenom());

        return v;
    }


}