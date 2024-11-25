package packModele;

import packObserver.Observable;
import packObserver.Observer;
import packVue.VueFormulaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Promotion implements Observable {

    private static ArrayList<Etudiant> listStudent = new ArrayList<>();
    private static ArrayList<Observer> listObservers = new ArrayList<>();
    private static Etudiant studentToModify;


    // Load CSV file with student data
    public static void loadFileCSV() {
        try {
            File file = new File("data/promoBUT.csv");
            Scanner scan = new Scanner(file);

            // Recovery data of the line
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] data = line.split(";");

                // Format departement
                if (Integer.parseInt(data[3]) < 10) {
                    data[3] = "0" + data[3];
                }

                // Add student with his data to listStudent
                listStudent.add(new Etudiant(data[0], data[1], data[2], data[3], data[4]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR :" + e.getMessage());
        }
    }


    // Add student to stat list
    public static void addStudent(Etudiant student) {
        listStudent.add(student);
        notifyObservers();
    }

    // Remove student from stat list
    public static void removeStudent(Etudiant student) {
        listStudent.remove(student);
        notifyObservers();
    }

    public static void modifyStudent(Etudiant student) {
        listStudent.set(listStudent.indexOf(studentToModify), student);
        notifyObservers();
    }

    // Search student in the list
    public static Etudiant getStudent(String num) {
        for (Etudiant student : listStudent) {
            if (student.getNumero().equals(num)) {
                return student;
            }
        }
        return null;
    }

    // Get list of student
    public static ArrayList<Etudiant> getListStudent() {
        return listStudent;
    }

    // get student to modify data
    public static Etudiant getStudentToModify() {
        return studentToModify;
    }

    public static void setStudentToModify(Etudiant student) {
        studentToModify = student;
        notifyObservers();
    }


    // Manage observers
    public static void addObserver(Observer observer) {
        if (!listObservers.contains(observer)) {
            listObservers.add(observer);
        }
    }

    public static void removeObserver(Observer observer) {
        listObservers.remove(observer);
    }

    public static void notifyObservers() {
        for (Observer obs : listObservers) {
            obs.update();
        }
    }
}

