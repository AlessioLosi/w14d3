package DAO;

import Entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;


public class EventsDAO {
    private final EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvent);
        transaction.commit();
        System.out.println("l'evento " + newEvent.titolo() + " è stato salvato correttamente nel db");
    }

    public Event findById(UUID eventId) throws Exception {
        Event found = entityManager.find(Event.class, eventId);
        if (found == null) throw new Exception(String.valueOf(eventId));
        return found;
    }
}