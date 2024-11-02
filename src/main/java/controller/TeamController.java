package controller;

import entity.Time;
import entity.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.TeamService;
import service.UserService;

import java.util.List;

@Path("/teams")
public class TeamController {
    @Inject
    public TeamService service; // como vai chamar o team service

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<Time> time= service.getAllTeams();
        return Response.ok(time).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTeams(List<Time> teams) {
        service.addTeams(teams);
        return Response.ok("Teams added sucessfully").build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") int idTime) {
        boolean deleted = service.deleteTeam(idTime);
        if (deleted) {
            return Response.ok("Team deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Team not found")
                    .build();
        }
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTeam(@PathParam("id") int idTime, Time team) {
        boolean updated = service.updateTeam(idTime, team);
        if (updated) {
            return Response.ok("Team updated successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Team not found")
                    .build();
        }
    }

}
