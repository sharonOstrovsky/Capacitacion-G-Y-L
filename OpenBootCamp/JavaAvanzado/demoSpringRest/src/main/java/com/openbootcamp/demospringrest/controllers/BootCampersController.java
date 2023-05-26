package com.openbootcamp.demospringrest.controllers;

import com.openbootcamp.demospringrest.models.BootCamper;
import com.openbootcamp.demospringrest.services.BootCamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootCampersController {
    private final BootCamperService bootCamperService;

    public BootCampersController(BootCamperService bootCamperService) {
        this.bootCamperService = bootCamperService;

        this.bootCamperService.add(new BootCamper("uno", Math.random()));
        this.bootCamperService.add(new BootCamper("dos",Math.random()));
        this.bootCamperService.add(new BootCamper("tres",Math.random()));
        this.bootCamperService.add(new BootCamper("cuatro",Math.random()));
        this.bootCamperService.add(new BootCamper("cinco",Math.random()));

    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<BootCamper> ListarTodos(){
        return bootCamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public BootCamper listarUno(@PathParam("nombre") String nombre){
        return bootCamperService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(BootCamper bootcamper){
        bootCamperService.add(bootcamper);

        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getNombre())
        ).build();
    }

}
