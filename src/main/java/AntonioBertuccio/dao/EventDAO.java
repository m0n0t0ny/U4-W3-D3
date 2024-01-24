package AntonioBertuccio.dao;

import AntonioBertuccio.entities.Event;
import AntonioBertuccio.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class EventDAO {
  private final EntityManager em;

  public EventDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Person event) {
    EntityTransaction transaction = em.getTransaction();
    System.out.println("⚪ Initialising transaction.");
    transaction.begin();
    System.out.println("⚪ Adding new object to Persistence Context.");
    em.persist(event);
    System.out.println("⚪ Writing on database.");
    transaction.commit();
    System.out.println("🟢 New data added.");
  }

  public Event findById(UUID id) {
    return em.find(Event.class, id);
  }

  public void findByIdAndDelete(UUID id) {
    Event found = em.find(Event.class, id);
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
