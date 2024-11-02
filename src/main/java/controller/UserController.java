package controller;

import entity.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.UserService;

import java.util.List;
@Path("/users")
public class UserController {
    @Inject
    public UserService userService;

    // Metodo GET para listar todos os usuários
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> users = userService.getAllUsers();
        return Response.ok(users).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(List<User> users){
        userService.addUser(users);
        return Response.ok("User added sucessfully").build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int idUser) {
        boolean deleted = userService.deleteUser(idUser);
        if (deleted) {
            return Response.ok("User deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .build();
        }
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int idUser, User user) {
        boolean updated = userService.updateUser(idUser, user);
        if (updated) {
            return Response.ok("User updated successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .build();
        }
    }
}


