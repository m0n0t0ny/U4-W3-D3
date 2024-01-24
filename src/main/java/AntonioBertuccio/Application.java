package AntonioBertuccio;

import AntonioBertuccio.dao.EventDAO;
import AntonioBertuccio.dao.PersonDAO;
import AntonioBertuccio.entities.Person;
import AntonioBertuccio.enums.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3");

  public static void main(String[] args) {
    EntityManager em = emf.createEntityManager();
    EventDAO db = new EventDAO(em);
    PersonDAO pd = new PersonDAO(em);

    try {

//      ---------- Save on DB 💾 ----------
//      Event capodanno = new Event("Capodanno", LocalDate.of(2023, 12, 31), "Festeggiamo insieme l'ultimo giorno del 2023 🎉", EventType.PRIVATE, 255);
//      db.save(capodanno);
        Person chiaraPuleio = new Person("Chiara", "Puleio", "chiara.puleio@gmail.com", LocalDate.of(1994, 10, 29), Gender.FEMALE);
        pd.save((chiaraPuleio));

//      ---------- Search from DB 🔎 ----------
//      UUID id = UUID.fromString("6a5b66fc-3561-4954-adcf-8cdfae0da3e5");
//      Event capodannoFromDB = db.findById(id);
//      if (capodannoFromDB != null) {
//        System.out.println(capodannoFromDB);
//      }
//      else {
//        System.out.println("🔴 L'oggetto con uuid " + id + " non é stato trovato.");
//      }

//      ---------- Find and Delete ❌ ----------
//      db.findByIdAndDelete(UUID.fromString("86644ea7-74dc-427f-b0e7-da55e1f72564"));

    } catch (Exception ex) {
      System.err.println(ex.getMessage());

    } finally {
      System.out.println("🟢 Entity manager (em) closed ❌.");
      em.close();
      emf.close();
      System.out.println("🟢 Entity manager factory (emf) closed ❌.");
      System.out.println("🟢 End of all processes from main.");
    }

  }
}
