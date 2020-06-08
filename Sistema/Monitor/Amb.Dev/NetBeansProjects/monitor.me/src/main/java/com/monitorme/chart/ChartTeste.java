/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.chart;

/**
 *
 * @author bruno
 */
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author bruno
 */
public class ChartTeste extends javax.swing.JPanel {

    public ChartTeste() {
 
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(350, 280);
        
    }
 
    public JPanel createChartPanel() {
        String chartTitle = "";
        String xAxisLabel = "";
        String yAxisLabel = "";

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
        xAxisLabel, yAxisLabel, dataset,
        PlotOrientation.VERTICAL, false, false, false);

        return new ChartPanel(chart);
    }
 
    public XYDataset createDataset() {
        
        XYSeries dados = new XYSeries("");
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        dados.add(1, 30.0);
        dados.add(2, 40.4);
        dados.add(3, 50.6);
        dados.add(4, 62);
        dados.add(5, 75.4);
        
        dataset.addSeries(dados);

        return dataset;
    }
}