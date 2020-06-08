/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.chart;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author bruno
 */
public class GraficoAreaXY extends javax.swing.JPanel {
    private String tituloGrafico;
    private XYDataset datasetAreaXY;
    private JFreeChart graficoAreaXY;

    public GraficoAreaXY(String tituloGrafico, XYDataset datasetAreaXY) {
        this.tituloGrafico = tituloGrafico;
        this.datasetAreaXY = datasetAreaXY;
        this.criarGrafico();
    }
    
    private void criarGrafico(){
        this.graficoAreaXY = ChartFactory.createXYAreaChart(tituloGrafico, "", "", this.datasetAreaXY, PlotOrientation.VERTICAL, false, false, false);
    }
    
    public void exibirGraficoEmFrame(int largura, int altura){
        JPanel panel = new JPanel();
        ChartPanel painelDoGrafico = new ChartPanel(this.graficoAreaXY);
        panel.add(painelDoGrafico);
        panel.setVisible(true);
        
    }
}
