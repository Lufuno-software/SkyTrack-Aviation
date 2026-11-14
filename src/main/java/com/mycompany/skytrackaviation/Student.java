/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skytrackaviation;

/**
 *
 * @author nenje
 */
public abstract class Student implements ProgressTracker{
    private String name;
    private int age;
    private String contactNumber;
    private double flightHours;
    private double theoryScore;
    
    public Student(String name, int age, String contactNumber, double flightHours, double theoryScore){
        setName(name);
        setAge(age);
        setContactNumber(contactNumber);
        setFlightHours(flightHours);
        setTheoryScore(theoryScore);
    }
    
    public abstract double getRequiredHours();
    @Override
    public abstract double calculateCRI();

    @Override
    public abstract String getReadinessStatus();
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        if (name != null && name.matches("[a-zA-Z ]+")){
            this.name = name;
        } else {
            throw new IllegalArgumentException(
            "Name must contain letters and spaces only.");
        }
    }
     
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException(
            "Age must be greater than 0.");
        }
    }
     public String getContactNumber(){
         return contactNumber;
     }
     
     public void setContactNumber(String contactNumber) {
         if(contactNumber != null && contactNumber.matches("\\d+")){
             this.contactNumber = contactNumber;
         } else {
             throw new IllegalArgumentException(
             "Cell number must contain digits only.");
         }
     }
     
     public double getFlightHours(){
         return flightHours;
     }
     
     public void setFlightHours(double flightHours) {
         if (flightHours >= 0) {
             this.flightHours = flightHours;
         } else {
             throw new IllegalArgumentException(
             "Flight hours cannot be negative.");
         }
     }
     
     public double getTheoryScore(){
         return theoryScore;
     }
      public void setTheoryScore(double theoryScore){
          if (theoryScore >= 0 && theoryScore <= 100) {
              this.theoryScore = theoryScore;
          } else {
              throw new IllegalArgumentException(
              "Theory score must be between 0 and 100.");
          }
      }
      public void displayProgress() {

          System.out.println("CRI: " + String.format("%.2f", calculateCRI()));
          System.out.println("Readiness Status: " + getReadinessStatus());
    }
      
      public void displayProgress(boolean detailedProgress) {
         if (detailedProgress) {

          System.out.println("Flight Hours: " + getFlightHours());
          System.out.println("Required Flight Hours: " + getRequiredHours());
          System.out.println("Theory Score: " + getTheoryScore() + "%");
          System.out.println("CRI: " + String.format("%.2f", calculateCRI()));
          System.out.println("Readiness Status: " + getReadinessStatus());

    } else {
        displayProgress();
    }
 }
     
}
