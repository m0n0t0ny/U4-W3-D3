package AntonioBertuccio.entities;

import AntonioBertuccio.enums.Attendancy;
import AntonioBertuccio.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue
  private UUID id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "email")
  private String email;
  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;
  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Attendance> attendances;
  @Column(name = "attendance_status")
  @Enumerated
  private Attendancy attendanceStatus;

  public Person() {
  }

  public Person(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.attendanceStatus = Attendancy.PENDING;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public List<Attendance> getAttendances() {
    return attendances;
  }

  public void setAttendances(List<Attendance> attendances) {
    this.attendances = attendances;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", gender=" + gender +
            ", attendances=" + attendances +
            '}';
  }
}