package packControleur;

import packModele.Etudiant;
import packModele.Promotion;

import java.util.ArrayList;

public class ControlAjoutFormulaire extends AbstractControleur {

    @Override
    public void control(ArrayList<String> list) {

        Promotion.addStudent(new Etudiant(
                list.get(0),
                list.get(1),
                list.get(2),
                list.get(3),
                list.get(4)
        ));

    }
}
