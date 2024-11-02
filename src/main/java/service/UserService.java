package service;

import entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {
    @Transactional
    public void addUser(List<User> users) {
        for (User user : users) {
            user.persist();
        }
    }
    public List<User> getAllUsers() {
        // Exemplo de retorno de usuários. Modifique para buscar do banco de dados, se necessário.
        return User.listAll();  // Se estiver usando PanacheEntity ou PanacheRepository
    }
    @Transactional
    public boolean deleteUser(int idUser) {
        User user = User.findById(idUser);  // Procura o usuário pelo ID
        if (user != null) {
            user.delete();  // Deleta o usuário se encontrado
            return true;
        }
        return false;
    }
    @Transactional
    public boolean updateUser(int idUser, User user) {
        User existingUser = User.findById(idUser);  // Procura o usuário pelo ID
        if (existingUser != null) {
            existingUser.login = user.login;  // Atualiza o login
            existingUser.password = user.password;  // Atualiza a senha
            existingUser.persist();  // Persiste as mudanças
            return true;
        }
        return false;
    }
}

