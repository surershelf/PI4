package service;

import entity.Quadra;
import entity.Time;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class QuadraService {

    @Transactional
    public void addQuadra(List<Quadra> quadras) {
        for (Quadra quadra : quadras) {
            quadra.persist();
        }
    }

    public List<Quadra> getAllQuadras() {
        return Quadra.listAll();
    }

    @Transactional
    public boolean deleteQuadra(int idQuadra) {
        Quadra quadra = Quadra.findById(idQuadra);
        if (quadra != null) {
            quadra.delete();  // Deleta o usuário se encontrado
            return true;
        }
        return false;
    }
}
