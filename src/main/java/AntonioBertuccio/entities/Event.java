package AntonioBertuccio.entities;

import AntonioBertuccio.enums.EventType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue
  private UUID id;
  @Column(name = "title")
  private String title;
  @Column(name = "event_date")
  private LocalDate eventDate;
  @Column(name = "description")
  private String description;
  @Column(name = "event_type")
  private EventType event;
  @Column(name = "max_attendants")
  private int maxAttendants;
  @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
  private List<Attendance> attendanceList;

  public Event() {
  }

  public Event(String title, LocalDate eventDate, String description, EventType event, int maxAttendants) {
    this.title = title;
    this.eventDate = eventDate;
    this.description = description;
    this.event = event;
    this.maxAttendants = maxAttendants;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getEventDate() {
    return eventDate;
  }

  public void setEventDate(LocalDate eventDate) {
    this.eventDate = eventDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EventType getEvent() {
    return event;
  }

  public void setEvent(EventType event) {
    this.event = event;
  }

  public int getMaxAttendants() {
    return maxAttendants;
  }

  public void setMaxAttendants(int maxAttendants) {
    this.maxAttendants = maxAttendants;
  }

  @Override
  public String toString() {
    return "Event{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", eventDate=" + eventDate +
            ", description='" + description + '\'' +
            ", event=" + event +
            ", maxAttendants=" + maxAttendants +
            '}';
  }
}
