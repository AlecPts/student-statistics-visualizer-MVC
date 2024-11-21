package packVue;

import packModele.Etudiant;
import packModele.Promotion;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class VueListe extends AbstractVue {

    private final JList liste;
    private final JButton btSuppr = new JButton("Supprimer");
    private final ArrayList<Etudiant> listStudent = Promotion.getListStudent();


    public VueListe() {
        liste = new JList();
        liste.setLayoutOrientation(JList.VERTICAL);
   //     liste.setVisibleRowCount(getHeight());
        JScrollPane scrollPane = new JScrollPane(liste);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(scrollPane, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(btSuppr, gc);
       // liste.setPreferredSize(new Dimension (150,500));
        remplissageListe();
        this.pack();
        liste.setVisibleRowCount(this.getHeight()/8);
        this.pack();
    }

    private void remplissageListe() {
        ArrayList<String> dataStudent = new ArrayList<>();

        for (Etudiant student : listStudent) {
            dataStudent.add(
                    student.getNumero() + " - " +
                    student.getLastName() + " " +
                    student.getFirstName() + " " +
                    "(" + student.getDepartement() + ")"
            );
        }

        liste.removeAll();
        liste.setListData(dataStudent.toArray());
//        this.pack();
    }
    
}
