package DAO;

import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersoneDAO {
    private final EntityManager entityManager;

    public PersoneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPersona);
        transaction.commit();
        System.out.println("la persona" + newPersona.nome() + " è stato salvato correttamente nel db");
    }

    public Persona findById(long personaId) throws Exception {
        Persona found = entityManager.find(Persona.class, personaId);
        if (found == null) throw new Exception(String.valueOf(personaId));
        return found;
    }
}
