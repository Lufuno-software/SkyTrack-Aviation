/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skytrackaviation;

/**
 *
 * @author nenje
 */
public class CPLStudent extends Student implements ProgressTracker {
    public CPLStudent(String name, int age, String contactNumber, double flightHours, double theoryScore){
        super(name, age, contactNumber, flightHours, theoryScore);
    }
    @Override
    public double getRequiredHours() {
        return 200;
    }
    @Override
    public double calculateCRI() {
        double flightComponent = (getFlightHours() / getRequiredHours()) * 50;
        double theoryComponent = (getTheoryScore() / 100) * 50;
        
        return flightComponent + theoryComponent;
    }
    @Override 
    public String getReadinessStatus() {
        double cri = calculateCRI();
        if (cri < 40){
            return "Not Ready";
        }else if (cri <75){
            return "In Progress";
        }else{
            return "Exam Ready";
        }
    }
}
