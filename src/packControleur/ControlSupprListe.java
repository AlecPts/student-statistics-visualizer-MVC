package packControleur;

import packModele.Etudiant;
import packModele.Promotion;

import java.util.ArrayList;

public class ControlSupprListe extends AbstractControleur {

    @Override
    public void control(ArrayList<String> list) {

        Promotion.removeStudent(Promotion.getStudent(list.getFirst()));
    }
}
