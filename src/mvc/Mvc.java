package mvc;

import javax.swing.SwingUtilities;
import static javax.swing.SwingUtilities.updateComponentTreeUI;
import javax.swing.UIManager;

import packModele.Promotion;
import packVue.MainWindow;

/**
 * @authors brice.effantin & Eric Duchene
 * @modifed by L Buathier & A. Peytavie
 */
public class Mvc {

    public static void main(String[] args) {
        // Load student data
        Promotion.loadFileCSV();

        // Load window
        MainWindow fen=new MainWindow(); 
/*       try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(fen);
            updateComponentTreeUI(fen);
        } catch (Exception ex) {
                       System.out.println(ex.getMessage());
        } 
  */
        fen.setVisible(true);
    }
    
}
