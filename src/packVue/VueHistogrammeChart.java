package packVue;

import java.awt.Dimension;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import packModele.Etudiant;
import packModele.Promotion;
import packObserver.Observer;

public class VueHistogrammeChart extends AbstractVue implements Observer {

    private final Histogramme histo;

    public VueHistogrammeChart() {
        // Add VueListe to Observers
        Promotion.addObserver(this);

        histo = new Histogramme();
        this.setContentPane(histo);
        this.pack();
    }

    @Override
    public void update() {
        new Histogramme();
    }

    // internal class
    public class Histogramme extends ChartPanel {

        public Histogramme() {
            super(null);
            this.setPreferredSize(new Dimension(285, 350));
            CategoryDataset dataset = createDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart);
            setContentPane(chartPanel);
            this.setChart(chart);
        }

        private CategoryDataset createDataset() {
            // Get list of student
            ArrayList<Etudiant> listStudent = Promotion.getListStudent();

            // Create double-entry table
            final double[][] data = new double[4][1];

            for (Etudiant stu : listStudent) {
                // Test type of bac
                switch (stu.getBac()) {
                    case "G":
                        data[0][0]++;
                        break;

                    case "T":
                        data[1][0]++;
                        break;

                    case "Pro":
                        data[2][0]++;
                        break;

                    default:
                        data[3][0]++;
                        break;
                }
            }

            // Create a dataset with specific categories as row keys
            final String[] rowKeys = {"General", "Techno", "Pro", "Autre"};
            final String[] columnKeys = {""};
            return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        }

        private JFreeChart createChart(final CategoryDataset dataset) {
            final JFreeChart chart = ChartFactory.createBarChart3D(
                    "Séries de bac", // chart title
                    "Bacs", // domain axis label
                    "Nombre", // range axis label
                    dataset, // data
                    PlotOrientation.VERTICAL, // orientation
                    true, // include legend
                    true, // tooltips
                    false // urls
            );

            final CategoryPlot plot = chart.getCategoryPlot();
            final CategoryAxis axis = plot.getDomainAxis();
            axis.setCategoryLabelPositions(
                    CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
            );
            final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
            renderer.setDrawBarOutline(false);

            return chart;

        }

    }

}
