package Entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento")
    private Event evento;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Event evento, StatoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona.nome() + persona.cognome() +
                ", evento=" + evento.titolo() + " " + evento.data_evento() + " " + evento.eventType() + " " + evento.descrizione() +
                ", stato=" + stato +
                '}';
    }
}
