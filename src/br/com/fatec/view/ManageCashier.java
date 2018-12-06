package br.com.fatec.view;

import br.com.fatec.DAO.CashierDAO;
import br.com.fatec.DAO.DrugDAO;
import br.com.fatec.model.Cashier;
import br.com.fatec.model.CashierLog;
import br.com.fatec.model.Drug;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageCashier extends javax.swing.JFrame {
    private DefaultTableModel cashierTableModel;
    private CashierDAO cashierDAO = new CashierDAO();
    private Cashier cashier;
    
    public ManageCashier() {
        initComponents();
        updateTable();
        btView.setEnabled(false);
        btOpenClose.setEnabled(false);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btBack1 = new rojeru_san.RSButton();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        RGText = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##.###.###-#");
            RGText = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        btView = new rojeru_san.RSButton();
        btBack = new rojeru_san.RSButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCashier = new javax.swing.JTable();
        btBack2 = new rojeru_san.RSButton();
        btOpenClose = new rojeru_san.RSButton();
        btCreate1 = new rojeru_san.RSButton();
        jPanel3 = new javax.swing.JPanel();

        btBack1.setBackground(new java.awt.Color(1, 198, 83));
        btBack1.setText("Voltar");
        btBack1.setColorHover(new java.awt.Color(0, 102, 51));
        btBack1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBack1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Caixa");
        setMaximumSize(new java.awt.Dimension(842, 470));
        setMinimumSize(new java.awt.Dimension(842, 470));
        setResizable(false);
        setSize(getMinimumSize());
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        RGText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RGText.setBorder(null);
        RGText.setEnabled(false);
        RGText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGTextActionPerformed(evt);
            }
        });

        btView.setBackground(new java.awt.Color(255, 102, 0));
        btView.setText("Visualizar");
        btView.setColorHover(new java.awt.Color(204, 51, 0));
        btView.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewActionPerformed(evt);
            }
        });

        btBack.setBackground(new java.awt.Color(255, 51, 51));
        btBack.setText("Voltar");
        btBack.setColorHover(new java.awt.Color(153, 0, 0));
        btBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Gerenciamento de Caixas");

        tbCashier.setBackground(new java.awt.Color(204, 204, 204));
        tbCashier.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbCashier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCashier.setToolTipText("");
        tbCashier.setGridColor(new java.awt.Color(255, 255, 255));
        tbCashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCashierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCashier);

        btBack2.setBackground(new java.awt.Color(255, 102, 0));
        btBack2.setText("Voltar");
        btBack2.setColorHover(new java.awt.Color(204, 51, 0));
        btBack2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBack2ActionPerformed(evt);
            }
        });

        btOpenClose.setBackground(new java.awt.Color(255, 102, 0));
        btOpenClose.setText("Abrir Caixa");
        btOpenClose.setColorHover(new java.awt.Color(204, 51, 0));
        btOpenClose.setEnabled(false);
        btOpenClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btOpenClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenCloseActionPerformed(evt);
            }
        });

        btCreate1.setBackground(new java.awt.Color(255, 102, 0));
        btCreate1.setText("Criar Caixa");
        btCreate1.setColorHover(new java.awt.Color(204, 51, 0));
        btCreate1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btView, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btOpenClose, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(448, 448, 448)
                                .addComponent(RGText, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(459, 459, 459)
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(RGText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btView, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btOpenClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 57, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(112, 0, 730, 440);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 110, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed

    }//GEN-LAST:event_btBackActionPerformed

    private void btViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewActionPerformed
        new ManageCashier2(cashier).setVisible(true);
        dispose();
    }//GEN-LAST:event_btViewActionPerformed

    private void RGTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RGTextActionPerformed

    private void tbCashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCashierMouseClicked
        int line = tbCashier.getSelectedRow();
        int cod = (Integer)tbCashier.getValueAt(line, 0);
        try {
            cashier = null;
            cashier = new Cashier();
            cashier.setNumber(cod);
            cashier = cashierDAO.search(cashier);
            btView.setEnabled(true);
            String text = cashier.getCurrentStatus().equals("closed") ? "Abrir Caixa" : "Fechar Caixa";
            btOpenClose.setText(text);
            btOpenClose.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(ListOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbCashierMouseClicked

    private void btBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBack1ActionPerformed
    }//GEN-LAST:event_btBack1ActionPerformed

    private void btBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBack2ActionPerformed
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btBack2ActionPerformed

    private void btOpenCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenCloseActionPerformed
        try {
            String text = cashier.getCurrentStatus().equals("closed") ? "open" : "closed";
            cashier.setCurrentStatus(text);
            cashierDAO.edit(cashier);
            text = cashier.getCurrentStatus().equals("closed") ? "Abrir Caixa" : "Fechar Caixa";
            btOpenClose.setText(text);
            CashierLog log = new CashierLog();
            log.setDateRecorded(LocalDate.now());
            log.setTimeRecorded(LocalTime.now());
            log.setStatus(cashier.getCurrentStatus());
            cashierDAO.insert(log, cashier.getNumber());
            updateTable();
        } catch (SQLException ex) {
            Logger.getLogger(ManageCashier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btOpenCloseActionPerformed

    private void btCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreate1ActionPerformed
        try {
            cashierDAO.insert(null);
            updateTable();
        } catch (SQLException ex) {
            Logger.getLogger(ManageCashier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCreate1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RGText;
    private rojeru_san.RSButton btBack;
    private rojeru_san.RSButton btBack1;
    private rojeru_san.RSButton btBack2;
    private rojeru_san.RSButton btCreate1;
    private rojeru_san.RSButton btOpenClose;
    private rojeru_san.RSButton btView;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCashier;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
       try {
            List<Cashier> data = cashierDAO.list("");

            Vector<String> header = new Vector<>(1);
            header.add("Número do caixa");
            
            Vector lines = new Vector();
            Vector record = new Vector();
            
            for(Cashier cashier : data) {
                record = new Vector(1);
                record.add(cashier.getNumber());
                lines.add(record);                
            }
            cashierTableModel = new DefaultTableModel(lines, header);
            tbCashier.setModel(cashierTableModel);
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(ListOrders.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ListOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}