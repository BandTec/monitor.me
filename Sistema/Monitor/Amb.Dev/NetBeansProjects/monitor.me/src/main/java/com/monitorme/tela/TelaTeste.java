package com.monitorme.tela;

import com.monitorme.jsensor.MonitorCPU;
import com.monitorme.jsensor.MonitorGPU;
import com.monitorme.jsensor.MonitorHDISK;
import com.monitorme.jsensor.MonitorMOBO;
import com.monitorme.monitorMain.Monitoracao;
import com.monitorme.oshi.OshiGPU;
import com.monitorme.oshi.OshiOS;
import com.monitorme.oshi.SystemInfoTest;
import javax.swing.UIManager;


public class TelaTeste extends javax.swing.JFrame {
    //Jsensor
    MonitorCPU sensorCPU = new MonitorCPU();
    MonitorGPU sensorGPU = new MonitorGPU();
    MonitorHDISK sensorHDISK = new MonitorHDISK();
    MonitorMOBO sensorMOBO = new MonitorMOBO();
    //Oshi
    OshiOS oshiOs = new OshiOS();
    OshiGPU oshiGpu = new OshiGPU();
    
    SystemInfoTest oshi = new SystemInfoTest();
    
    //MonitorMain
    Monitoracao monitorMain = new Monitoracao();
    
     
    //MainMonitorMe
    
    public TelaTeste() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTeste = new javax.swing.JButton();
        lblTesteCpu = new javax.swing.JLabel();
        lblTesteMobo = new javax.swing.JLabel();
        lblTesteGPU = new javax.swing.JLabel();
        lblTesteHDisk = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTesteOshiHD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCPU = new javax.swing.JList<>();
        lblTesteOshiOs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Tela Apenas Para Teste de Classes");

        jLabel2.setText("CPU JSENSOR");

        jLabel3.setText("GPU JSENSOR");

        jLabel4.setText("MOBO JSENSOR");

        jLabel5.setText("HDISK JSENSOR");

        btnTeste.setText("ACTION");
        btnTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesteActionPerformed(evt);
            }
        });

        lblTesteCpu.setText("RESULTADO CPU");

        lblTesteMobo.setText("RESULTADO MOBO");

        lblTesteGPU.setText("RESULTADO GPU");

        lblTesteHDisk.setText("RESULTADO HDISK");

        jLabel6.setText("OSHI - API");

        lblTesteOshiHD.setText("lblTesteOshiHD");

        lstCPU.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstCPU);

        lblTesteOshiOs.setText("lblTesteOshiOs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(350, 350, 350)
                                .addComponent(btnTeste))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(63, 63, 63)))
                                    .addComponent(lblTesteCpu))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblTesteGPU))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(lblTesteHDisk))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(lblTesteMobo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTesteOshiOs)
                            .addComponent(lblTesteOshiHD))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnTeste))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTesteCpu)
                    .addComponent(lblTesteMobo)
                    .addComponent(lblTesteGPU)
                    .addComponent(lblTesteHDisk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(22, 22, 22)
                .addComponent(lblTesteOshiOs)
                .addGap(18, 18, 18)
                .addComponent(lblTesteOshiHD)
                .addGap(124, 124, 124))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTesteActionPerformed
//        oshiGpu.printGPU();
        sensorGPU.showGPU();
        System.out.println(sensorGPU.toString());
    }//GEN-LAST:event_btnTesteActionPerformed

    public static void main(String args[]) {
        // o Try Abaixo muda o Estilo da Tela, deve ser Salvo no MAIN
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf"); //Flat Darcula
//            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf"); // Darcula
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows
        } catch (Exception ex) {
            System.err.println( "Failed to initialize LaF" + ex );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTeste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTesteCpu;
    private javax.swing.JLabel lblTesteGPU;
    private javax.swing.JLabel lblTesteHDisk;
    private javax.swing.JLabel lblTesteMobo;
    private javax.swing.JLabel lblTesteOshiHD;
    private javax.swing.JLabel lblTesteOshiOs;
    private javax.swing.JList<String> lstCPU;
    // End of variables declaration//GEN-END:variables
}
