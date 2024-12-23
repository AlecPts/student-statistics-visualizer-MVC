package packVue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

    private final VueFormulaire form;
    private final VueCamembertChart camemb;
    private final VueListe liste;
    private final VueTable table;
    private final VueHistogrammeChart histo;
    
    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JDesktopPane());
        this.setTitle("Statistiques d'une promotion de BUT");
        
        //vue formulaire
        form=new VueFormulaire();
        this.add(form);
        form.setTitle("Saisie d'étudiants");
        form.setVisible(true);
        form.setLocation(0, 0);
        
        //vue camembert
        camemb=new VueCamembertChart();
        this.add(camemb);
        camemb.setTitle("Départements d'origine");
        camemb.setVisible(true);
        camemb.setLocation(0, form.getHeight());
        
        //vue histogramme
        histo=new VueHistogrammeChart();
        this.add(histo);
        histo.setTitle("Bacs d'origine");
        histo.setVisible(true);
        histo.setLocation(camemb.getWidth(), form.getHeight());
        
        //vue liste
        liste=new VueListe();
        this.add(liste);
        liste.setTitle("Liste des étudiants");
        liste.setLocation(camemb.getWidth()+histo.getWidth(), 0);
        liste.setVisible(true);

        //vue table
        table=new VueTable();
        this.add(table);
        table.setTitle("Table des étudiants");
        table.setLocation(camemb.getWidth()+histo.getWidth()+liste.getWidth(), 0);
        table.setVisible(true);

        //taille de la fenetre
        this.pack();
        this.setSize(
                camemb.getWidth()+histo.getWidth()+liste.getWidth()+table.getWidth()+18,
                form.getHeight()+camemb.getHeight()+45
        );
        this.setLocationRelativeTo(null);
        
    }
}   
