package packControleur;

import packModele.Etudiant;
import packModele.Promotion;

import javax.swing.*;
import java.util.ArrayList;

public class ControlSupprListe extends AbstractControleur {

    @Override
    public void control(ArrayList<String> list) {
        try {
            for (String num : list) {
                Etudiant studentToRemove = Promotion.getStudent(num);

                // Test if the student exist in the promotion
                if (studentToRemove == null) {
                    throw new Exception("This student doesn't exist in this promotion");
                }

                Promotion.removeStudent(studentToRemove);
            }

        } catch (Exception e) {
            System.err.println("ERROR :" + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
