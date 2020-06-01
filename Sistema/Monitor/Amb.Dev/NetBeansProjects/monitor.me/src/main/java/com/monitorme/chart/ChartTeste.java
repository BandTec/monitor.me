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
 
        setSize(351, 295);
        
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
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series3 = new XYSeries("Object 1");

        series3.add(1, 30.0);
        series3.add(2, 40.4);
        series3.add(3, 50.6);
        series3.add(4, 62);
        series3.add(5, 75.4);
        
        XYSeries series2 = new XYSeries("Object 2");

        series2.add(6, 30.0);
        series2.add(7, 40.4);
        series2.add(8, 50.6);
        series2.add(9, 62);
        
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }
}