package com.cognizant.mvc;

public class MVCTest {

    public static void main(String[] args) {

        // Create Model
        Student student = new Student("Meghana", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Show initial data
        controller.updateView();

        System.out.println("\nAfter Update:\n");

        // Update data using controller
        controller.setStudentName("Ananya");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}