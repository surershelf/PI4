package entity;

import jakarta.persistence.*;

@Entity
public class Quadra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuadra;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;
    @Enumerated(EnumType.STRING)
    private Esporte tipoJogo;
    @Enumerated(EnumType.STRING)
    private Quadras quadra;

    public enum Esporte {
    Futsal, Volei, Basquete;
    }
    public enum Quadras {
        Quadra_1, Quadra_2;
    }
    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Quadras getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadras quadra) {
        this.quadra = quadra;
    }

    public Esporte getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(Esporte tipoJogo) {
        this.tipoJogo = tipoJogo;
    }

    public int getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(int idQuadra) {
        this.idQuadra = idQuadra;
    }
}

