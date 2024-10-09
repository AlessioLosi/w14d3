package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "sesso")
    @Enumerated(EnumType.STRING)
    private PersonaTipo sesso;

    @Column(name = "data_di_nascita", nullable = true)
    private LocalDate data_di_nascita;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listaPartecipazioni;

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, PersonaTipo sesso, LocalDate data_di_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.sesso = sesso;
        this.data_di_nascita = data_di_nascita;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String cognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonaTipo sesso() {
        return sesso;
    }

    public void setSesso(PersonaTipo sesso) {
        this.sesso = sesso;
    }

    public LocalDate data_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", sesso=" + sesso +
                ", data_di_nascita=" + data_di_nascita +
                '}';
    }
}
