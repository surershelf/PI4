package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idQuadra")
    private Quadra quadra;
    private String descricao;
    private Date data;
    @Enumerated(EnumType.STRING)
    private HoraAgend hora;

    public enum HoraAgend {
        primeiroJogo("19:00 - 20:30"),
        segundoJogo("21:00 - 22:30");

        private final String desc;

        HoraAgend(String desc) {
            this.desc = desc;
        }
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


}
