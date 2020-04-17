package com.monitorme.tela;

import com.monitorme.monitorMain.Monitoracao;
import java.util.Random;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TelaMonitor extends javax.swing.JFrame {
    
    Monitoracao monitor = new Monitoracao();
//    Monitoracao run = new Monitoracao();
    
    public TelaMonitor() {
        initComponents();
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
        jLabel4 = new javax.swing.JLabel();
        lblTeste = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Monitor.me");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTeste.setText("Teste");

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Propriedades");

        jMenu3.setText("teste");
        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Help");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Sobre");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem1);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTeste))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painelCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painelMemo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painelDisc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCPU)
                            .addComponent(btnMemo)
                            .addComponent(btnDisc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
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
                                        .addGap(12, 12, 12)))))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTeste)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painelCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMemo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(painelMemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDisc)
                                            .addComponent(painelDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btCPU))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(painelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTextUtil)
                            .addComponent(lblTextVel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUtil)
                            .addComponent(lblVelocidade))
                        .addGap(18, 18, 18)))
                .addComponent(lblTextProcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProcesso)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCPUActionPerformed
        Random aleatorio = new Random();
        Integer cpu = aleatorio.nextInt(101);
        Random aleatorio2 = new Random();
        Integer processo = aleatorio2.nextInt(301);

        Double ghz = (3.2 * cpu) / 100;

        lblUtil.setText(String.format("%d%%", cpu));
        lblVelocidade.setText(String.format("%.2f/3,2GHz", ghz));
        lblProcesso.setText(String.format("%d", processo));
        lblTextUtil.setText(String.format("Utilização:"));
        lblTextVel.setText(String.format("Velocidade:"));
        lblTextProcesso.setText(String.format("Processo:"));
        lblTitulo.setText(String.format("CPU"));
        // TODO add your handling code here:
    }//GEN-LAST:event_btCPUActionPerformed

    private void btnMemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemoActionPerformed
        Random aleatorioM = new Random();
        Integer memoria = aleatorioM.nextInt(200);
        Random aleaCache = new Random();
        Double memoDisp = (200.0 / memoria);
        Double cache = aleaCache.nextDouble();

        //Exemplo de Chamada usando Get e Set
//        monitor.getUsoMemor();
//        monitor.setUsoMemor(memoDisp);
//        System.out.println(monitor.getUsoMemor());
//        lblTeste.setText(monitor.getUsoMemor().toString());
        // 

        lblUtil.setText(String.format("%d  GB", memoria));
        lblVelocidade.setText(String.format("%.2f GB", memoDisp));
        lblProcesso.setText(String.format("%.2f GB", cache));
        lblTextUtil.setText(String.format("Disponivel:"));
        lblTextVel.setText(String.format("Em uso:"));
        lblTextProcesso.setText(String.format("Cache:"));
        lblTitulo.setText(String.format("MEMÓRIA"));
    }//GEN-LAST:event_btnMemoActionPerformed

    private void btnDiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscActionPerformed
        Random aleatorioDisc = new Random();
        Integer disco = aleatorioDisc.nextInt(201);
        Random aleatorioTemp = new Random();
        Double tempDis = (200.0 / disco);
        Double velocDisc = aleatorioTemp.nextDouble();

        lblUtil.setText(String.format("%d%%", disco));
        lblVelocidade.setText(String.format("%.2f/ms", tempDis));
        lblProcesso.setText(String.format("%.2f KB/s", velocDisc));
        lblTextUtil.setText(String.format("Tempo de atividade:"));
        lblTextVel.setText(String.format("Valocidade de leitura:"));
        lblTextProcesso.setText(String.format("Tempo de resposta:"));
        lblTitulo.setText(String.format("DISCO"));

        
    }//GEN-LAST:event_btnDiscActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        // o Try Abaixo muda o Estilo da Tela, deve ser Salvo no MAIN
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf"); //Flat Darcula
//            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf"); // Darcula
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows
        } catch (Exception ex) {
            System.err.println( "Failed to initialize LaF" + ex );
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
    private javax.swing.JButton btnMemo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
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
    private javax.swing.JPanel painelMemo;
    // End of variables declaration//GEN-END:variables
}
