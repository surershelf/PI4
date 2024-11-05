package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Agendamento extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idAgendamento;
    @ManyToOne
    @JoinColumn(name = "idUser")
    public User user;
    @ManyToOne
    @JoinColumn(name = "idQuadra")
    public Quadra quadra;
    @OneToOne
    @JoinColumn(name = "Time1")
    public Time idTime1;
    @OneToOne
    @JoinColumn(name = "Time2")
    public Time idTime2;
    @Enumerated(EnumType.STRING)
    public Esporte tipoJogo;
    public String descricao;
    public Date data;
    @Enumerated(EnumType.STRING)
    public HoraAgend hora;

    public enum HoraAgend {
        primeiroJogo("19:00 - 20:30"),
        segundoJogo("21:00 - 22:30");

        private final String desc;

        HoraAgend(String desc) {
            this.desc = desc;
        }
    }
    public enum Esporte {
        Futsal, Volei, Basquete;
    }
    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public HoraAgend getHora() {
        return hora;
    }
    public Time getIdTime2() {
        return idTime2;
    }

    public void setIdTime2(Time idTime2) {
        this.idTime2 = idTime2;
    }

    public Time getIdTime1() {
        return idTime1;
    }

    public void setIdTime1(Time idTime1) {
        this.idTime1 = idTime1;
    }


    public Esporte getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(Esporte tipoJogo) {
        this.tipoJogo = tipoJogo;
    }


}
