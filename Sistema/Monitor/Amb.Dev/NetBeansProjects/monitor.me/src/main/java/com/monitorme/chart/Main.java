/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.chart;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author bruno
 */
public class Main {
    public static void main(String[] args) {
        
        XYSeries pontosDoGrafico = new XYSeries("");
        pontosDoGrafico.add(1995, 100);
        pontosDoGrafico.add(2000, 90);
        pontosDoGrafico.add(2005, 50);
        pontosDoGrafico.add(2010, 80);
        pontosDoGrafico.add(2020, 90);
        
        XYDataset datasetAreaXY = new XYSeriesCollection(pontosDoGrafico);
        
        GraficoAreaXY graficoAreaXY = new GraficoAreaXY("", datasetAreaXY);
        graficoAreaXY.exibirGraficoEmFrame(800, 640);
    }
}
