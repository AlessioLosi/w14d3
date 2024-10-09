package org.example;

import DAO.EventsDAO;
import DAO.LocationDAO;
import DAO.PartecipazioniDAO;
import DAO.PersoneDAO;
import Entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w14d3");

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");


        EntityManager em = emf.createEntityManager();
        EventsDAO ed = new EventsDAO(em);
        Event concerto = new Event("Olivia Rodrigo", LocalDate.now().minusDays(12), "evento musicale", 932432, EventType.PRIVATO);
        // ed.save(concerto);
        Event festa = new Event("TS", LocalDate.now().minusDays(2), "evento musicale", 12, EventType.PRIVATO);
        //ed.save(festa);
        PersoneDAO ped = new PersoneDAO(em);
        Persona persona1 = new Persona("Taylor", "Swift", "TaySWift.com", PersonaTipo.FEMMINA, LocalDate.now().minusYears(35).plusDays(4).plusMonths(2));
        //ped.save(persona1);
        Persona persona2 = new Persona("Olivia", "Rodrigo", "OLIROD:com", PersonaTipo.FEMMINA, LocalDate.now().minusYears(21).plusDays(3).plusMonths(5));
        //ped.save(persona2);

        LocationDAO ld = new LocationDAO(em);
        Location Villa = new Location("villa", "Roma");
        //ld.save(Villa);
        Location Villa2 = new Location("villa2", "Milano");
        //ld.save(Villa2);

        PartecipazioniDAO pd = new PartecipazioniDAO(em);
        Partecipazione partecipazione1 = new Partecipazione(persona1, concerto, StatoPartecipazione.CONFERMATA);
        //pd.save(partecipazione1);
        Partecipazione partecipazione2 = new Partecipazione(persona2, festa, StatoPartecipazione.DA_CONFERMARE);
        //pd.save(partecipazione2);
        Partecipazione concertofromDb = pd.findById("b06ba21f-6ac8-45ee-956a-d8f428c9d129");
        System.out.println(concertofromDb.getPersona());

        em.close();
        emf.close();
    }
}
