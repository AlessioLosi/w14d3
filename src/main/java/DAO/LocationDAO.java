package DAO;

import Entities.Event;
import Entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLocation);
        transaction.commit();
        System.out.println("la location" + newLocation.nome() + " è stata salvata correttamente nel db");
    }

    public Event findById(long locationId) throws Exception {
        Event found = entityManager.find(Event.class, locationId);
        if (found == null) throw new Exception(String.valueOf(locationId));
        return found;
    }
}
