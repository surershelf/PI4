package service;

import entity.Agendamento;
import entity.Quadra;
import entity.Time;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.util.List;

@ApplicationScoped
public class AgendamentoService {

    @Transactional
    public void MarcarJogo(Agendamento agendamento) {
        // Verifica se a quadra existe e está disponível
        Quadra quadra = Quadra.findById(agendamento.quadra.idQuadra);
        if (quadra == null) {
            throw new BadRequestException("Quadra não encontrada.");
        }
        if (quadra.usando) {
            throw new BadRequestException("A quadra selecionada já está em uso.");
        }

        // Verifica se os times são diferentes e válidos
        if (agendamento.idTime1 == null || agendamento.idTime2 == null) {
            throw new BadRequestException("Dois times devem ser selecionados.");
        }
        if (agendamento.idTime1.idTime == agendamento.idTime2.idTime) {
            throw new BadRequestException("Os times devem ser diferentes.");
        }

        // Verifica se a data e o horário foram especificados
        if (agendamento.data == null || agendamento.hora == null) {
            throw new BadRequestException("A data e o horário do jogo devem ser informados.");
        }

        // Atualiza o status da quadra para ocupado
        quadra.usando = true;
        quadra.persist();

        // Salva o agendamento no banco de dados
        agendamento.persist();
    }

    public List<Agendamento> getAllAgendamentos() {
        // Exemplo de retorno de usuários. Modifique para buscar do banco de dados, se necessário.
        return Agendamento.listAll();  // Se estiver usando PanacheEntity ou PanacheRepository
    }
}
