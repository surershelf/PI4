package controller;

import entity.Agendamento;
import entity.Quadra;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.AgendamentoService;

import java.util.List;

@Path("/agendamento")
public class AgendamentoController {

    @Inject
    AgendamentoService agendamentoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAgendamento() {
        List<Agendamento> agendamentos= agendamentoService.getAllAgendamentos();
        return Response.ok(agendamentos).build();
    }

    @POST
    @Path("/marcarjogo")
    public Response marcarJogo(Agendamento agendamento) {
        agendamentoService.MarcarJogo(agendamento);
        return Response.ok("Jogo marcado com sucesso!").build();
    }

}
