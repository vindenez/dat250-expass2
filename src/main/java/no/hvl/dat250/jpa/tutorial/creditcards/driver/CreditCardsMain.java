package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.*;


public class CreditCardsMain {

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

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    CreditCard creditCard1 = new CreditCard();
    CreditCard creditCard2 = new CreditCard();

    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setCustomers(List.of(customer));


    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setCustomers(List.of(customer));

    ArrayList<CreditCard> creditCards = new ArrayList<>(List.of(creditCard1,creditCard2));

    customer.setCreditCards(List.of(creditCard1,creditCard2));

    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(customer);

    creditCard1.setPincode(pincode);
    creditCard2.setPincode(pincode);

    em.persist(pincode);

    creditCard1.setBank(bank);
    creditCard2.setBank(bank);
    bank.setOwnedCards(creditCards);

    em.persist(bank);

  }
}