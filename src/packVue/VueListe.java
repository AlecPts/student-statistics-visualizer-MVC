package packVue;

import packControleur.ControlSupprListe;
import packModele.Etudiant;
import packModele.Promotion;
import packObserver.Observer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class VueListe extends AbstractVue implements Observer {

    private final JList liste;
    private final JButton btSuppr = new JButton("Supprimer");
    private final ArrayList<Etudiant> listStudent = Promotion.getListStudent();


    public VueListe() {
        // Add VueListe to Observers
        Promotion.addObserver(this);

        liste = new JList();
        //liste.setLayoutOrientation(JList.VERTICAL);
        //     liste.setVisibleRowCount(getHeight());
        JScrollPane scrollPane = new JScrollPane(liste);
        liste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
        liste.setVisibleRowCount(this.getHeight() / 8);
        this.pack();

        // Action
        btSuppr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // List of student's numero to remove
                ArrayList<String> listStudentToRemove = new ArrayList<>();

                for (int index : liste.getSelectedIndices()) {
                    Etudiant studentToRemove = listStudent.get(index);
                    listStudentToRemove.add(studentToRemove.getNumero());
                }

                // Call the controller
                ControlSupprListe controlRemoveList = new ControlSupprListe();
                controlRemoveList.control(listStudentToRemove);
            }
        });

        liste.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Promotion.setStudentToModify(listStudent.get(liste.getSelectedIndex()));
                }
            }
        });
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

    @Override
    public void update() {
        remplissageListe();
    }
}
