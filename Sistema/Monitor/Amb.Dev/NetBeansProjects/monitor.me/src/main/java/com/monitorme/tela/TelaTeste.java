package com.monitorme.tela;

import com.monitorme.jsensor.DadosGpu;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;

public class TelaTeste extends javax.swing.JFrame {

    DadosGpu dGpu = new DadosGpu();

    public TelaTeste() {
        initComponents();

        lblTempMediaGpu.setText(dGpu.getMediaTemperatura().toString());
        System.out.println(dGpu.toString());
        long TEMPO = (5000 * 1);
        
        Timer timer = null;

        if (timer == null) {
            timer = new Timer();

            TimerTask tarefa = new TimerTask() {
                public void run() {
                    // o código que precisa ser repetido deve ser inserido aqui
                    lblTempMediaGpu.setText(dGpu.getMediaTemperatura().toString());
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTempMediaGpu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Temperatura Média da Gpu: ");

        lblTempMediaGpu.setText("º");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblTempMediaGpu)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTempMediaGpu))
                .addGap(305, 305, 305))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        // o Try Abaixo muda o Estilo da Tela, deve ser Salvo no MAIN
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf"); //Flat Darcula
//            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf"); // Darcula
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF" + ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTempMediaGpu;
    // End of variables declaration//GEN-END:variables
}
