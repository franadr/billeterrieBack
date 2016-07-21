package lu.intech.Billetterie.api;

import lu.intech.Billetterie.Entities.OffreEntity;
import lu.intech.Billetterie.Entities.VORtEntity;
import lu.intech.Billetterie.Entities.VendeursEntity;
import lu.intech.Billetterie.repository.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Adriano on 11/07/16.
 */

@Path("/offres")
@Produces("application/json")
public class OffresREST {
    Message message = new Message();

    @Inject
    Repository repository;


    @GET
    public Response getListOffres(){
        List<OffreEntity> loffers = repository.getAllOffers();
        List<Offre> offres = loffers.stream().map( Converters::offreToEntity ).collect(Collectors.toList());
        GenericEntity<List<Offre>> list = new GenericEntity<List<Offre>>(offres) {};



        return Response.ok(list, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    public Response postOffer(Offre e){
        OffreEntity ofr = new OffreEntity();
        ofr.setIdOffre(e.getIdOffre());
        ofr.setCommande(e.getCommande());
        ofr.setLink(e.getLink());
        ofr.setPrixCfl(e.getPrixCfl());
        ofr.setPrixPublic(e.getPrixPublic());
        ofr.setTitre(e.getTitre());
        ofr.setImgUrl(e.getImgUrl());
        ofr.setDescription(e.getDescription());


        repository.postOffer(ofr);


        return Response.ok(ofr).build();
    }
    @Path("/{id}")
    @GET
    public Response getDisp(@PathParam("id") int idoffre){
        List  <VORtEntity> disp = repository.getDisponibility(idoffre);
        List <DispoVendeur> disps = disp.stream().map(Converters::VORtoEntity).collect(Collectors.toList());


        GenericEntity<List<DispoVendeur>> list = new GenericEntity<List<DispoVendeur>>(disps) {};
        return Response.ok(list).build();
    }
    @Path("/{id}")
    @DELETE
    public Response delOffer(@PathParam("id") int idoffre){
            repository.delOffre(idoffre);

        this.message.setMessage("Offre supprimé");
        return Response.ok(message).build();
    }

    @Path("/vendeurs")
    @GET
    public Response getVendeurs(){
        List <VendeursEntity> vendeurs = repository.getAllVendeurs();
        List <Vendeurs> vendeurses = vendeurs.stream().map(Converters::vendeursToEntity).collect(Collectors.toList());



        GenericEntity<List<Vendeurs>> list = new GenericEntity<List<Vendeurs>>(vendeurses) {};
        return Response.ok(list).build();

    }

    //not used
    @Path("/allDisp")
    @GET
    public Response getAllDisp(){
        List  <VORtEntity> disp = repository.getAllDisponibility();
        List <DispoVendeur> disps = disp.stream().map(Converters::VORtoEntity).collect(Collectors.toList());


        GenericEntity<List<DispoVendeur>> list = new GenericEntity<List<DispoVendeur>>(disps) {};
        return Response.ok(list).build();
    }

    @Path("/modifDisp")
    @POST
    public Response modifDisp(DispoVendeur d){
        int idOffre,idVendeur,quantite;
        idOffre = d.getIdOffre();
        idVendeur = d.getIdVendeur();
        quantite = d.getQuantite();
        repository.modifDisp(idOffre,idVendeur,quantite);
        this.message.setMessage("Offre modifié");
        return Response.ok(message).build();
    }

    @Path("/editOffre")
    @POST
    public Response editOffre(Offre e){
        OffreEntity ofr = new OffreEntity();
        ofr.setIdOffre(e.getIdOffre());
        ofr.setCommande(e.getCommande());
        ofr.setLink(e.getLink());
        ofr.setPrixCfl(e.getPrixCfl());
        ofr.setPrixPublic(e.getPrixPublic());
        ofr.setTitre(e.getTitre());
        ofr.setImgUrl(e.getImgUrl());
        ofr.setDescription(e.getDescription());

        repository.modifOffre(ofr);

        return Response.ok("Offre modifié").build();
    }

}
