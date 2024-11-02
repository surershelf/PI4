package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Time extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTime;
    @OneToOne
    @JoinColumn(name = "idUser")
    public User user;
    public String nomeAtlet;
    public String nomeCurso;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeAtlet() {
        return nomeAtlet;
    }

    public void setNomeAtlet(String nomeAtlet) {
        this.nomeAtlet = nomeAtlet;
    }

}
