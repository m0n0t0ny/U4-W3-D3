package AntonioBertuccio.entities;

import AntonioBertuccio.enums.Attendancy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "attendances")
public class Attendance {
  @Id
  @Column(name = "id")
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;
  @ManyToOne
  @JoinColumn(name = "event")
  private Event event;
  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private Attendancy attendance;

  public Attendance(){}
}
