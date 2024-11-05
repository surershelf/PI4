package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Quadra extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idQuadra;
    @Enumerated(EnumType.STRING)
    public Quadras quadra;

    public enum Quadras {
        Quadra_1, Quadra_2;
    }

    public Quadras getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadras quadra) {
        this.quadra = quadra;
    }

    public int getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(int idQuadra) {
        this.idQuadra = idQuadra;
    }
}

