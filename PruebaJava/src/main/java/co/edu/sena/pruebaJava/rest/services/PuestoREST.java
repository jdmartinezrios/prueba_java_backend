/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.pruebaJava.rest.services;

import co.edu.sena.pruebaJava.jpa.sessions.PuestoFacade;
import co.edu.sena.pruebajava.jpa.entities.Puesto;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("puestos")
public class PuestoREST {
    
    @EJB
    private PuestoFacade puestoEJB;
    
    @GET 
    public List<Puesto> findAll(){
        return puestoEJB.findAll();
    }
    
    @GET 
    @Path("{id}")
    public Puesto findBYId(@PathParam("id") Integer id){
        return puestoEJB.find(id);
    }
    
    @POST
    public void create(Puesto puesto) {
        puestoEJB.create(puesto);
    }
  
    @PUT
    public void edit(@QueryParam("id") Integer id, Puesto puesto) {
        puesto.setId(id);
        puesto.setAutomovil(puesto.getAutomovil());
        puesto.setParqueadero(puesto.getParqueadero());
        puestoEJB.edit(puesto);
    }
}