package com.astec.rest;

import com.astec.model.Component;
import com.astec.service.ComponentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/components")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComponentResource {

    @Inject
    private ComponentService service;

    @POST
    public Response addComponent(Component component) {
        service.save(component);
        return Response.status(Response.Status.CREATED).entity(component).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteComponent(@PathParam("id") Long id) {
        service.delete(id);
        return Response.ok().build();
    }

    @GET
    public List<Component> listComponents() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getComponentById(@PathParam("id") Long id) {
        Component component = service.findById(id);
        if (component != null) {
            return Response.ok(component).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
