package DAO;

import Entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioniDAO {
    private final EntityManager entityManager;

    public PartecipazioniDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPartecipazione);
        transaction.commit();
        System.out.println("la partecipazione con id:" + newPartecipazione.getId() + " è stata salvata correttamente nel db");
    }

    public Partecipazione findById(String partecipazioneId) throws Exception {
        Partecipazione found = entityManager.find(Partecipazione.class, UUID.fromString(partecipazioneId));
        if (found == null) throw new Exception(String.valueOf(partecipazioneId));
        return found;
    }
}
