package service;

import entity.Time;
import entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped // Esta classe estará disponível e será usada durante toda a execução da aplicação
public class TeamService {

    @Transactional
    public void addTeams(List<Time> teams) {
        for (Time time : teams) {
            time.persist();
        }
    }
    public List<Time> getAllTeams() {
        // Exemplo de retorno de usuários. Modifique para buscar do banco de dados, se necessário.
        return Time.listAll();  // Se estiver usando PanacheEntity ou PanacheRepository
    }
    @Transactional
    public boolean deleteTeam(int idTime) {
        Time team = Time.findById(idTime);  // Procura o usuário pelo ID
        if (team != null) {
            team.delete();  // Deleta o usuário se encontrado
            return true;
        }
        return false;
    }
    @Transactional
    public boolean updateTeam(int idTime, Time team) {
        Time existingTeam = Time.findById(idTime);  // Procura o usuário pelo ID
        if (existingTeam != null) {
            existingTeam.user = team.user;  // Atualiza o login
            existingTeam.nomeAtlet = team.nomeAtlet;  // Atualiza o login
            existingTeam.nomeCurso = team.nomeCurso;  // Atualiza a senha
            existingTeam.persist();  // Persiste as mudanças
            return true;
        }
        return false;
    }
}
