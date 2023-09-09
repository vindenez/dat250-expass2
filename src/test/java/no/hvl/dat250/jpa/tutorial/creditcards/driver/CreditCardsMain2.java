package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.*;


public class CreditCardsMain2 {

    static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

    public static void main(String[] args) {
        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
            em.getTransaction().begin();
            createObjects(em);
            em.getTransaction().commit();
        }

    }

    private static void createObjects(EntityManager em) {
        // TODO: Create object world as shown in the README.md.
        Customer customer = new Customer();
        customer.setName("Max Mustermann");
        em.persist(customer);

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);


        List<Customer> ownersList = new ArrayList<>(Set.of(customer));

        address.setOwners(ownersList);

        customer.setAddresses(List.of(address));
        em.persist(address);
        em.persist(customer);


        System.out.println("Gå gjennom domain model engang til og pass på bidirectional og unidirectional");





    }
}