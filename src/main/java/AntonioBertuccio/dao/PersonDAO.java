package AntonioBertuccio.dao;

import AntonioBertuccio.entities.Event;
import AntonioBertuccio.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class PersonDAO {
  private final EntityManager em;

  public PersonDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Person person) {
    EntityTransaction transaction = em.getTransaction();
    System.out.println("⚪ Initialising transaction.");
    transaction.begin();
    System.out.println("⚪ Adding new object to Persistence Context.");
    em.persist(person);
    System.out.println("⚪ Writing on database.");
    transaction.commit();
    System.out.println("🟢 New data added.");
  }

  public Person findById(UUID id) {
    return em.find(Person.class, id);
  }

  public void findByIdAndDelete(UUID id) {
    Person found = em.find(Person.class, id);
    System.out.println("⚪ Searching object by id 🔎.");
    if (found != null) {
      EntityTransaction transaction = em.getTransaction();
      System.out.println("⚪ Initialising transaction 🔀.");
      transaction.begin();
      System.out.println("⚪ Adding new object to Persistence Context.");
      em.remove(found);
      System.out.println("⚪ Deleting object from database.");
      transaction.commit();
      System.out.println("🟢 Object deleted ❌.");
    } else {
      System.out.println("🔴 L'oggetto con uuid" + id + "non é stato trovato.");
    }
  }
}
