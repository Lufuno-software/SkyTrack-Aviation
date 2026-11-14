/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.skytrackaviation;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author nenje
 */
public class SkyTrackAviation {
static Scanner scanner = new Scanner(System.in);
static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
      int choice;
       do {
           displayMenu();
           choice = getInt("Enter your choice: ");
           
           switch(choice) {
               case 1:
                   registerStudent();
               break;
               
               case 2:
                   viewStudentProfile();
                   break;
                
               case 3:
                   logFlightHours();
                   break;
                   
               case 4:
                   updateTheoryScore();
                   break;
                   
               case 5:
                   viewProgressReport();
                   break;
                   
               case 6:
                  viewRemainingFlightHours();
                   break;
                   
               case 7:
                   System.out.println("Thank you for using SkyTrackAviation!");
                   break;
                   
               default:
                   System.out.println("Invalid choice, please try again.");
                   
           }
       } while (choice != 7);
    }
    public static void displayMenu() {

    System.out.println();
    System.out.println("========================================");
    System.out.println("   SKYTRACK AVIATION TRAINING ACADEMY");
    System.out.println("========================================");
    System.out.println("1. Register Student");
    System.out.println("2. View Student Profile");
    System.out.println("3. Log Flight Hours");
    System.out.println("4. Update Theory Score");
    System.out.println("5. View Progress Report");
    System.out.println("6. View Remaining Flight Hours");
    System.out.println("7. Exit");
    System.out.println("========================================");
    }
    
    public static int getInt(String message) {
        while (true) {
        try {
            System.out.print(message);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException error) {
            System.out.println("Please enter a valid number.");
        }
      }
    }
    public static void registerStudent() {
        System.out.println("\n--- Register Student ---");
        
        String name;
        while(true){
            System.out.print("Enter student name: ");
            name = scanner.nextLine().trim();
            
        if (name.matches("[a-zA-Z ]+")){
            break;
        }
        System.out.println("Invalid name. Please use letters and spaces only.");
        }
        int age = getInt("Enter student age: ");
        
        String contactNumber;
        while(true) {
            System.out.print("Enter contact number: ");
            contactNumber = scanner.nextLine();
            if (contactNumber.matches("\\d+")){
                break;
            }System.out.println("Invalid contact number. Please use digits only");
        }         
            String programme = "";
            while (true) {
         
                System.out.println("\nSelect training programme:");
                System.out.println("1. PPL (Private Pilot Licence)");
                System.out.println("2. CPL (Commercial Pilot Licence)");
                
                int programmeChoice = getInt("Enter your choice: ");
                if (programmeChoice == 1){
                    programme = "PPL";
                    break;
                }else if (programmeChoice == 2){
                    programme = "CPL";
                    break;
                }else {
                    System.out.println("Invalid choice. Please choose between 1 and 2.");
                }
            }
        double flightHours;
        while (true){
            flightHours = getDouble("Enter flight hours completed: ");
            if (flightHours >= 0){
                break;
            }
            System.out.println("Flight hours cannot be negative.");
        }
        
        double theoryScore;
        while (true){
            theoryScore = getDouble("Enter theory examination score(0-100): ");
            if (theoryScore >= 0 && theoryScore <= 100){
                break;
            }
            System.out.println("Theory score must be between 0 and 100.");
        }
        
        Student student;
        if (programme.equals("PPL")){
            student = new PPLStudent(name, age, contactNumber, flightHours, theoryScore);
        }else{
            student = new CPLStudent(name, age, contactNumber, flightHours, theoryScore);
        }
        students.add(student);
        System.out.println("\nStudent registered successfully!");
      }
    
    
    public static double getDouble(String message){
       while (true){
           try{
               System.out.print(message);
               return Double.parseDouble(scanner.nextLine());
           }catch (NumberFormatException error){
               System.out.println("Please enter a valid number.");
           }
       }
    }
    
    public static Student findStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        for (Student student : students){
            if (student.getName().equalsIgnoreCase(name)){
                return student;
            }
        }
        System.out.println("Student not found.");
                return null;
    }
    
    public static void viewStudentProfile() {

    System.out.println("\n--- View Student Profile ---");

    Student student = findStudent();

    if (student == null) {
        return;
    }

    System.out.println("\nStudent Name: " + student.getName());
    System.out.println("Age: " + student.getAge());
    System.out.println("Contact Number: " + student.getContactNumber());

    if (student instanceof PPLStudent) {
        System.out.println("Training Programme: PPL");
    } else {
        System.out.println("Training Programme: CPL");
    }

    System.out.println("Flight Hours Logged: " + student.getFlightHours());

    System.out.println("Required Flight Hours: " + student.getRequiredHours());

    System.out.println("Theory Examination Score: " + student.getTheoryScore() + "%");

    System.out.println("Certification Readiness Index (CRI): "
        + String.format("%.2f", student.calculateCRI()));

    System.out.println("Readiness Status: " + student.getReadinessStatus());
    }
    
    public static void logFlightHours() {

    System.out.println("\n--- Log Flight Hours ---");

    Student student = findStudent();
    if (student == null) {
        return;
    }
    double additionalHours;
    while (true) {
        additionalHours = getDouble("Enter additional flight hours: ");

        if (additionalHours >= 0) {
            break;
        }
        System.out.println("Flight hours cannot be negative.");
    }
    student.setFlightHours(student.getFlightHours() + additionalHours);
      
    System.out.println("Flight hours updated successfully!");
    System.out.println("New total flight hours: "+ student.getFlightHours());
        
    }
    public static void updateTheoryScore() {

    System.out.println("\n--- Update Theory Score ---");

    Student student = findStudent();
    if (student == null) {
        return;
    }
    double newScore;

    while (true) {

        newScore = getDouble("Enter new theory examination score (0-100): ");
            
        if (newScore >= 0 && newScore <= 100) {
            break;
        }
        System.out.println("Theory score must be between 0 and 100.");
    }

    student.setTheoryScore(newScore);

    System.out.println("Theory score updated successfully!");

    System.out.println("New theory score: "+ student.getTheoryScore() + "%");
    }
    
    public static void viewProgressReport() {

    System.out.println("\n--- View Progress Report ---");

    Student student = findStudent();
    if (student == null) {
        return;
    }
    double cri = student.calculateCRI();
    String status = student.getReadinessStatus();

    System.out.println("\nCertification Readiness Index (CRI): "+ String.format("%.2f", cri));

    System.out.println("Readiness Status: " + status);

    if (status.equals("Not Ready")) {

        System.out.println("Focus on accumulating flight hours and revising theory.");

    } else if (status.equals("In Progress")) {

        System.out.println("Good progress. Continue practising and preparing "
                + "for your certification.");

    } else if (status.equals("Exam Ready")) {

        System.out.println("Congratulations! You are ready to book your "
                + "certification examination.");
    }
  }
    public static void viewRemainingFlightHours() {

    System.out.println("\n--- View Remaining Flight Hours ---");

    Student student = findStudent();
    if (student == null) {
        return;
    }
    double remainingHours =student.getRequiredHours() - student.getFlightHours();

    if (remainingHours > 0) {

        System.out.println("Flight hours still required: "+ remainingHours);
                
    } else {

        System.out.println("You have completed the minimum required flight hours.");
    }
  }
} 




