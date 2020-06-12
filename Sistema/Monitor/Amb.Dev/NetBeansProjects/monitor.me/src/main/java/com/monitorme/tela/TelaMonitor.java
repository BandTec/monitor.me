package com.monitorme.tela;

import com.monitorme.chart.ChartTeste;
import com.monitorme.chart.DTSCTest;
import com.monitorme.jsensor.DadosGpu;
import com.monitorme.oshi.Memoria;
import com.monitorme.telegram.TelegramBot;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jfree.ui.RefineryUtilities;

public class TelaMonitor extends javax.swing.JFrame {

    public Timer timerColeta = new Timer();

    public TelaMonitor() {
        initComponents();

        final long time = 3000;

        TimerTask timeTask = new TimerTask() {
            DadosGpu DGpu = new DadosGpu();
            Memoria MRam = new Memoria();
//            Processos Proc = new Processos();
//            CPU cpu = new CPU();         
//            TelegramBot mensagem = new TelegramBot();
            DecimalFormat df = new DecimalFormat();
            
            public void run() {

                try {
                    lblUtil.setText(String.valueOf(df.format(MRam.memoriaRamPorcentagem())));

                    // <! -------------------------------------------------------------->
                    if (MRam.memoriaRamPorcentagem() > 0) {
                        System.out.println("Ram alta: " + MRam.memoriaRamPorcentagem());
                        //Se cair no alerta acima mande a mensagem abaixo: 
//                            TelegramBot.mensagem("");
                    }
                    // <! -------------------------------------------------------------->
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        timerColeta.scheduleAtFixedRate(timeTask, 0, time);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCpu = new javax.swing.JPanel();
        painelMemo = new javax.swing.JPanel();
        painelDisc = new javax.swing.JPanel();
        painelCentral = new javax.swing.JPanel();
        lblTextUtil = new javax.swing.JLabel();
        lblTextVel = new javax.swing.JLabel();
        lblTextProcesso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btCPU = new javax.swing.JButton();
        btnMemo = new javax.swing.JButton();
        btnDisc = new javax.swing.JButton();
        lblUtil = new javax.swing.JLabel();
        lblVelocidade = new javax.swing.JLabel();
        lblProcesso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTeste = new javax.swing.JLabel();
        lblCpuUtilizacao = new javax.swing.JLabel();
        lblCpuVelocidade = new javax.swing.JLabel();
        lblMemoriaUso = new javax.swing.JLabel();
        lblDiscoTempo = new javax.swing.JLabel();
        painelGpu = new javax.swing.JPanel();
        btnGpu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setResizable(false);

        painelCpu.setBackground(new java.awt.Color(255, 255, 255));
        painelCpu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        javax.swing.GroupLayout painelCpuLayout = new javax.swing.GroupLayout(painelCpu);
        painelCpu.setLayout(painelCpuLayout);
        painelCpuLayout.setHorizontalGroup(
            painelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelCpuLayout.setVerticalGroup(
            painelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        painelMemo.setBackground(new java.awt.Color(255, 255, 255));
        painelMemo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51)));

        javax.swing.GroupLayout painelMemoLayout = new javax.swing.GroupLayout(painelMemo);
        painelMemo.setLayout(painelMemoLayout);
        painelMemoLayout.setHorizontalGroup(
            painelMemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelMemoLayout.setVerticalGroup(
            painelMemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        painelDisc.setBackground(new java.awt.Color(255, 255, 255));
        painelDisc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelDiscLayout = new javax.swing.GroupLayout(painelDisc);
        painelDisc.setLayout(painelDiscLayout);
        painelDiscLayout.setHorizontalGroup(
            painelDiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );
        painelDiscLayout.setVerticalGroup(
            painelDiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        painelCentral.setBackground(new java.awt.Color(255, 255, 255));
        painelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelCentralLayout = new javax.swing.GroupLayout(painelCentral);
        painelCentral.setLayout(painelCentralLayout);
        painelCentralLayout.setHorizontalGroup(
            painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        painelCentralLayout.setVerticalGroup(
            painelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        lblTextUtil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTextUtil.setText("Utilização:");

        lblTextVel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTextVel.setText("Velocidade:");

        lblTextProcesso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTextProcesso.setText("Processo:");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setText("CPU");

        btCPU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCPU.setText("CPU");
        btCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCPUActionPerformed(evt);
            }
        });

        btnMemo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMemo.setText("MEMÓRIA");
        btnMemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemoActionPerformed(evt);
            }
        });

        btnDisc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDisc.setText("DISCO");
        btnDisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscActionPerformed(evt);
            }
        });

        lblUtil.setText("-------");

        lblVelocidade.setText("--------");

        lblProcesso.setText("-------");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MonitorMe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblTeste.setText("Teste");

        lblCpuUtilizacao.setText("Utilização");

        lblCpuVelocidade.setText("velocidade");

        lblMemoriaUso.setText("Em uso");

        lblDiscoTempo.setText("Tempo de uso");

        painelGpu.setBackground(new java.awt.Color(255, 255, 255));
        painelGpu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        javax.swing.GroupLayout painelGpuLayout = new javax.swing.GroupLayout(painelGpu);
        painelGpu.setLayout(painelGpuLayout);
        painelGpuLayout.setHorizontalGroup(
            painelGpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelGpuLayout.setVerticalGroup(
            painelGpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        btnGpu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGpu.setText("GPU");
        btnGpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGpuActionPerformed(evt);
            }
        });

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Propriedades");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("Help");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Exit");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelMemo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelGpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCpuUtilizacao)
                        .addGap(18, 18, 18)
                        .addComponent(lblCpuVelocidade))
                    .addComponent(lblMemoriaUso)
                    .addComponent(lblDiscoTempo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGpu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMemo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDisc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTextProcesso)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblProcesso))
                    .addComponent(painelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTextUtil)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblUtil)))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTextVel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblVelocidade)
                                .addGap(12, 12, 12)))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTeste)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTeste)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(painelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTextUtil)
                            .addComponent(lblTextVel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMemo)
                                .addGap(18, 18, 18)
                                .addComponent(lblMemoriaUso))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painelMemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDisc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblDiscoTempo))
                                    .addComponent(painelDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCPU)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCpuUtilizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpuVelocidade))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(painelGpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUtil)
                            .addComponent(lblVelocidade))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblTextProcesso))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnGpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProcesso)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCPUActionPerformed

//        lblUtil.setText(String.format("%d%%", aleatorio.getCpu()));
//        lblVelocidade.setText(String.format("%.2f/3,2GHz", aleatorio.getGhz()));
//        lblProcesso.setText(String.format("%d", aleatorio.getProcesso()));
//        lblTextUtil.setText(String.format("Utilização:"));
//        lblTextVel.setText(String.format("Velocidade:"));
//        lblTextProcesso.setText(String.format("Processo:"));
//        lblTitulo.setText(String.format("CPU"));
        // TODO add your handling code here:
        DTSCTest demo = new DTSCTest("");

        demo.setVisible(true);
        demo.start();
        painelCentral.add(demo);
    }//GEN-LAST:event_btCPUActionPerformed

    private void btnMemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemoActionPerformed

//        lblUtil.setText(String.format("%d  GB", aleatorio.getMemoria()));
//        lblVelocidade.setText(String.format("%.2f GB", aleatorio.getMemoDisp()));
//        lblProcesso.setText(String.format("%.2f GB", aleatorio.getCache()));
        lblTextUtil.setText(String.format("Disponivel:"));
        lblTextVel.setText(String.format("Em uso:"));
        lblTextProcesso.setText(String.format("Cache:"));
        lblTitulo.setText(String.format("MEMÓRIA"));
    }//GEN-LAST:event_btnMemoActionPerformed

    private void btnDiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscActionPerformed

//        lblUtil.setText(String.format("%d%%", aleatorio.getDisco()));
//        lblVelocidade.setText(String.format("%.2f/ms", aleatorio.getTempDis()));
//        lblProcesso.setText(String.format("%.2f KB/s", aleatorio.getVelocDisc()));
        lblTextUtil.setText(String.format("Tempo de atividade:"));
        lblTextVel.setText(String.format("VRam da GPU:"));
        lblTextProcesso.setText(String.format("Core da GPU:"));
        lblTitulo.setText(String.format("GPU"));


    }//GEN-LAST:event_btnDiscActionPerformed

    private void btnGpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGpuActionPerformed
        lblTextUtil.setText(String.format("Temperatura da GPU:"));
        lblTextVel.setText(String.format("Valocidade de leitura:"));
        lblTextProcesso.setText(String.format("Tempo de resposta:"));
        lblTitulo.setText(String.format("DISCO"));
    }//GEN-LAST:event_btnGpuActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf"); //Flat Darcula
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF" + ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMonitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCPU;
    private javax.swing.JButton btnDisc;
    private javax.swing.JButton btnGpu;
    private javax.swing.JButton btnMemo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCpuUtilizacao;
    private javax.swing.JLabel lblCpuVelocidade;
    private javax.swing.JLabel lblDiscoTempo;
    private javax.swing.JLabel lblMemoriaUso;
    private javax.swing.JLabel lblProcesso;
    private javax.swing.JLabel lblTeste;
    private javax.swing.JLabel lblTextProcesso;
    private javax.swing.JLabel lblTextUtil;
    private javax.swing.JLabel lblTextVel;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUtil;
    private javax.swing.JLabel lblVelocidade;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JPanel painelCpu;
    private javax.swing.JPanel painelDisc;
    private javax.swing.JPanel painelGpu;
    private javax.swing.JPanel painelMemo;
    // End of variables declaration//GEN-END:variables
}
