package packVue;

import java.awt.Dimension;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import packModele.Etudiant;
import packModele.Promotion;
import packObserver.Observer;

public class VueCamembertChart extends AbstractVue implements Observer {

    private Camembert camemb;

    public VueCamembertChart() {
        // Add VueListe to Observers
        Promotion.addObserver(this);

        camemb = new Camembert();
        this.setContentPane(camemb);
        this.pack();
    }

    @Override
    public void update() {
        new Camembert();
    }

    // internal class
    public class Camembert extends ChartPanel {

        public Camembert() {
            super(null);
            this.setPreferredSize(new Dimension(450, 350));
            final PieDataset dataset = createSampleDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart);
            setContentPane(chartPanel);
            this.setChart(chart);
        }

        private PieDataset createSampleDataset() {
            final DefaultPieDataset result = new DefaultPieDataset();

            // Get list of student
            ArrayList<Etudiant> listStudent = Promotion.getListStudent();

            for (Etudiant stu : listStudent) {
                // Test if value already exist
                if (result.getKeys().contains(stu.getDepartement())) {

                    // Increment value if data already exist
                    int currentValue = result.getValue(stu.getDepartement()).intValue();
                    result.setValue(stu.getDepartement(), currentValue + 1);

                } else {
                    result.setValue(stu.getDepartement(), 1);
                }
            }

            return result;
        }

        private JFreeChart createChart(final PieDataset dataset) {
            final JFreeChart chart = ChartFactory.createPieChart3D(
                    "Répartition Géographique", // chart title
                    dataset, // data
                    true, // include legend
                    true,
                    false
            );
            final PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(290);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            plot.setNoDataMessage("No data to display");
            return chart;
        }
    }
}
