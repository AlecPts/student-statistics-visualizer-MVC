package packControleur;

import packModele.Promotion;

import javax.swing.*;
import java.util.ArrayList;

public class ControlSupprFormulaire extends AbstractControleur {

    @Override
    public void control(ArrayList<String> list) {
        try {
            if (!list.getFirst().matches("[0-9]+")) {
                throw new Exception("The numero must contain only digits");
            }

            Promotion.removeStudent(Promotion.getStudent(list.getFirst()));

        } catch (Exception e) {
            System.err.println("ERROR : " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
