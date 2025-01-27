package week7;

import java.util.Scanner;

class Person {
private int personID;
private String name;
private int age;
private String gender;
private String address;
private String contactDetails;

public Person() {}

public void viewPersonalDetails() {
   System.out.println("ID: " + personID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender);
   System.out.println("Address: " + address + ", Contact: " + contactDetails);
}

public void setPersonID(int personID) { this.personID = personID; }
public void setName(String name) { this.name = name; }
public void setAge(int age) { this.age = age; }
public void setGender(String gender) { this.gender = gender; }
public void setAddress(String address) { this.address = address; }
public void setContactDetails(String contactDetails) { this.contactDetails = contactDetails; }
}

//Child Class: Patient
class Patient extends Person {
private int patientID;

public Patient() {}

public void bookAppointment() {
   System.out.println("Appointment booked for Patient ID: " + patientID);
}

// Setter
public void setPatientID(int patientID) { this.patientID = patientID; }
}

//Child Class: Doctor
class Doctor extends Person {
private int doctorID;
private String department;

public Doctor() {}

public void seePatientDetails() {
   System.out.println("Doctor is reviewing patient details.");
}

public void prescribeTreatment() {
   System.out.println("Doctor ID: " + doctorID + " is prescribing treatment.");
}

// Setters
public void setDoctorID(int doctorID) { this.doctorID = doctorID; }
public void setDepartment(String department) { this.department = department; }
}

//Class: Appointment
class Appointment {
private int appointmentID;
private String appointmentDate;
private String appointmentTime;

public Appointment() {}

public void rescheduleAppointment(String newDate, String newTime) {
   this.appointmentDate = newDate;
   this.appointmentTime = newTime;
   System.out.println("Appointment rescheduled to: " + newDate + " " + newTime);
}

public void cancelAppointment() {
   System.out.println("Appointment ID: " + appointmentID + " has been cancelled.");
}

public void viewAppointmentDetails() {
   System.out.println("Appointment ID: " + appointmentID + ", Date: " + appointmentDate + ", Time: " + appointmentTime);
}

// Setters
public void setAppointmentID(int appointmentID) { this.appointmentID = appointmentID; }
public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }
public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }
}

//Class: Treatment
class Treatment {
private int treatmentID;
private String type;
private String description;

public Treatment() {}

public void updateDescription(String newDescription) {
   this.description = newDescription;
   System.out.println("Treatment description updated to: " + description);
}

public void viewTreatmentDetails() {
   System.out.println("Treatment ID: " + treatmentID + ", Type: " + type + ", Description: " + description);
}

// Setters
public void setTreatmentID(int treatmentID) { this.treatmentID = treatmentID; }
public void setType(String type) { this.type = type; }
public void setDescription(String description) { this.description = description; }
}

//Main class for demonstration
public class Main {
public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);

   Patient patient = new Patient();
   System.out.println("Enter Patient ID:");
   patient.setPatientID(scanner.nextInt());
   scanner.nextLine(); // Consume newline
   System.out.println("Enter Patient Name:");
   patient.setName(scanner.nextLine());
   System.out.println("Enter Patient Age:");
   patient.setAge(scanner.nextInt());
   scanner.nextLine(); // Consume newline
   System.out.println("Enter Patient Gender:");
   patient.setGender(scanner.nextLine());
   patient.bookAppointment();

   Doctor doctor = new Doctor();
   System.out.println("Enter Doctor ID:");
   doctor.setDoctorID(scanner.nextInt());
   scanner.nextLine(); // Consume newline
   System.out.println("Enter Doctor Name:");
   doctor.setName(scanner.nextLine());
   System.out.println("Enter Doctor Department:");
   doctor.setDepartment(scanner.nextLine());
   doctor.seePatientDetails();
   doctor.prescribeTreatment();

   Appointment appointment = new Appointment();
   System.out.println("Enter Appointment ID:");
   appointment.setAppointmentID(scanner.nextInt());
   scanner.nextLine(); // Consume newline
   System.out.println("Enter Appointment Date:");
   appointment.setAppointmentDate(scanner.nextLine());
   System.out.println("Enter Appointment Time:");
   appointment.setAppointmentTime(scanner.nextLine());
   appointment.viewAppointmentDetails();

   Treatment treatment = new Treatment();
   System.out.println("Enter Treatment ID:");
   treatment.setTreatmentID(scanner.nextInt());
   scanner.nextLine(); // Consume newline
   System.out.println("Enter Treatment Type:");
   treatment.setType(scanner.nextLine());
   System.out.println("Enter Treatment Description:");
   treatment.setDescription(scanner.nextLine());
   treatment.viewTreatmentDetails();

   scanner.close();

}
}
