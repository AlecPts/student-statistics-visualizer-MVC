package packVue;

import packControleur.ControlSupprListe;
import packControleur.ControlSupprTable;
import packModele.Etudiant;
import packModele.Promotion;
import packObserver.Observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueTable extends AbstractVue implements Observer {

    private final JTable table;
    private final DefaultTableModel model;
    private final JButton btSuppr = new JButton("Supprimer");
    private final JButton btModif = new JButton("Modifier");
    private final ArrayList<Etudiant> listStudent = Promotion.getListStudent();

    public VueTable() {
        // Add VueListe to Observers
        Promotion.addObserver(this);

        model = new DefaultTableModel(new Object[] {"Numero", "Prénom", "Nom", "Bac", "Dpt"}, 0);
        table = new JTable(model);
        //table.setLayoutOrientation(JList.VERTICAL);
        //     liste.setVisibleRowCount(getHeight());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension (400,400));
        //table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(scrollPane, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(btSuppr, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        this.add(btModif, gc);

        remplissageTable();
        this.pack();
        //table.setVisible(true);
        //table.setVisibleRowCount(this.getHeight() / 8);
        //this.pack();

        // Action
        btSuppr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // List of student's numero to remove
                ArrayList<String> listStudentToRemove = new ArrayList<>();

                for (int index : table.getSelectedRows()) {
                    Etudiant studentToRemove = listStudent.get(index);
                    listStudentToRemove.add(studentToRemove.getNumero());
                }

                // Call the controller
                ControlSupprTable controlRemoveTable = new ControlSupprTable();
                controlRemoveTable.control(listStudentToRemove);
            }
        });
    }

    private void remplissageTable() {
        model.setRowCount(0);

        for (Etudiant student : listStudent) {
            model.addRow(new Object[] {
                    student.getNumero(),
                    student.getLastName(),
                    student.getFirstName(),
                    student.getBac(),
                    student.getDepartement()
            });
        }

//        this.pack();
    }

    @Override
    public void update() {
        remplissageTable();
    }
}
