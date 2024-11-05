package controller;

import entity.Quadra;
import entity.Time;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.QuadraService;
import service.TeamService;

import java.util.List;

@Path("/quadras")
public class QuadraController {
    @Inject
    public QuadraService service; // como vai chamar o team service

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuadras() {
        List<Quadra> quadra= service.getAllQuadras();
        return Response.ok(quadra).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addQuadra(List<Quadra> quadras) {
        service.addQuadra(quadras);
        return Response.ok("Quadra added sucessfully").build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteQuadra(@PathParam("id") int idQuadra) {
        boolean deleted = service.deleteQuadra(idQuadra);
        if (deleted) {
            return Response.ok("Team deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Team not found")
                    .build();
        }
    }
}
