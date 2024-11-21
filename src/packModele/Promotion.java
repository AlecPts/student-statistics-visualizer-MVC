package packModele;

import packVue.VueFormulaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Promotion {
    // List to store student data
    private static ArrayList<Etudiant> listStudent = new ArrayList<>();

    // Load CSV file with student data
    public static void loadFileCSV() {
        try {
            File file = new File("data/promoBUT.csv");
            Scanner scan = new Scanner(file);

            // Recovery data of the line
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] data = line.split(";");

                // Add student with his data to listStudent
                listStudent.add(new Etudiant(data[0], data[1], data[2], data[3], data[4]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erreur:" + e.getMessage());
        }
    }

    public static void addStudent() {
        new Etudiant(
                VueFormulaire.getTxtNumeroAdd().getText(),
                VueFormulaire.getTxtLastName().getText(),
                VueFormulaire.getTxtFirstName().getText(),
                VueFormulaire.getBoxDpt().getSelectedItem().toString(),
                VueFormulaire.getBoxBac().getSelectedItem().toString()
        );
    }

    public static void removeStudent() {

    }


    // Get list of student
    public static ArrayList<Etudiant> getListStudent() {
        return listStudent;
    }

}

