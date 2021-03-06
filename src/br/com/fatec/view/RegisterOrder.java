package br.com.fatec.view;

import br.com.fatec.DAO.ConsumerDAO;
import br.com.fatec.DAO.DrugDAO;
import br.com.fatec.DAO.OrderDAO;
import br.com.fatec.model.Consumer;
import br.com.fatec.model.Drug;
import br.com.fatec.model.Order;
import br.com.fatec.services.StringTools;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegisterOrder extends javax.swing.JFrame {
    private Order order = new Order();
    private DefaultComboBoxModel<Drug> drugBoxModel;
    private DefaultComboBoxModel<Consumer> consumerBoxModel;
    private DefaultTableModel drugTableModel;
    private DrugDAO drugDAO = new DrugDAO();
    private ConsumerDAO consumerDAO = new ConsumerDAO();
    /**
     * Creates new form RegisterConsumer
     */
    public RegisterOrder() {
        initComponents();        
        this.setLocationRelativeTo(null);
        fillComboBoxes();
        updateDrugTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSave = new rojeru_san.RSButton();
        btBack = new rojeru_san.RSButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDrugs = new javax.swing.JTable();
        lblMedicamentos = new javax.swing.JLabel();
        btnInsertDrug = new rojeru_san.RSButton();
        btnRemoveDrug = new rojeru_san.RSButton();
        cmbDrugs = new javax.swing.JComboBox<>();
        lblMedicamentos1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblMedicamentos2 = new javax.swing.JLabel();
        lblMedicamentos3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbConsumers = new javax.swing.JComboBox<>();
        lblMedicamentos4 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtFreight = new javax.swing.JFormattedTextField();
        txtDiscount = new javax.swing.JFormattedTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtQuantity = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Cliente Especial");
        setMinimumSize(new java.awt.Dimension(853, 515));
        setResizable(false);
        setSize(getMinimumSize());
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnSave.setBackground(new java.awt.Color(0, 153, 204));
        btnSave.setText("Cadastrar");
        btnSave.setColorHover(new java.awt.Color(51, 153, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btBack.setBackground(new java.awt.Color(0, 153, 204));
        btBack.setText("Voltar");
        btBack.setColorHover(new java.awt.Color(51, 153, 255));
        btBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Registrar nova venda");

        tbDrugs.setBackground(new java.awt.Color(204, 204, 204));
        tbDrugs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbDrugs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbDrugs.setToolTipText("");
        tbDrugs.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbDrugs);

        lblMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedicamentos.setForeground(new java.awt.Color(204, 204, 204));
        lblMedicamentos.setText("Medicamentos");

        btnInsertDrug.setBackground(new java.awt.Color(0, 153, 204));
        btnInsertDrug.setText("Inserir");
        btnInsertDrug.setColorHover(new java.awt.Color(51, 153, 255));
        btnInsertDrug.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInsertDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDrugActionPerformed(evt);
            }
        });

        btnRemoveDrug.setBackground(new java.awt.Color(0, 153, 204));
        btnRemoveDrug.setText("Remover");
        btnRemoveDrug.setColorHover(new java.awt.Color(51, 153, 255));
        btnRemoveDrug.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemoveDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDrugActionPerformed(evt);
            }
        });

        lblMedicamentos1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedicamentos1.setForeground(new java.awt.Color(204, 204, 204));
        lblMedicamentos1.setText("Preço do frete:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("R$");

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));

        lblMedicamentos2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedicamentos2.setForeground(new java.awt.Color(204, 204, 204));
        lblMedicamentos2.setText("Desconto:");

        lblMedicamentos3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedicamentos3.setForeground(new java.awt.Color(204, 204, 204));
        lblMedicamentos3.setText("Cliente Especial:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("R$");

        lblMedicamentos4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedicamentos4.setForeground(new java.awt.Color(204, 204, 204));
        lblMedicamentos4.setText("Quantidade:");

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));

        txtFreight.setBorder(null);
        txtFreight.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtFreight.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDiscount.setBorder(null);
        txtDiscount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtDiscount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));

        txtQuantity.setBorder(null);
        txtQuantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedicamentos)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMedicamentos1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFreight, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblMedicamentos2))
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMedicamentos3)
                                    .addComponent(cmbConsumers, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cmbDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblMedicamentos4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                        .addComponent(txtQuantity))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnInsertDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnRemoveDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(lblMedicamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMedicamentos4)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMedicamentos1)
                                .addComponent(lblMedicamentos2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtFreight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblMedicamentos3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbConsumers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(112, 0, 740, 486);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 110, 485);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDrugActionPerformed
        if (!txtQuantity.getText().isEmpty()) {
            Drug drug = (Drug) cmbDrugs.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText());
            order.removeDrug(drug, quantity);
            updateDrugTable();
        }
    }//GEN-LAST:event_btnRemoveDrugActionPerformed

    private void btnInsertDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDrugActionPerformed
        if (!txtQuantity.getText().isEmpty()) {
            Drug drug = (Drug) cmbDrugs.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText());
            order.addDrug(drug, quantity);  
            updateDrugTable();
        }
    }//GEN-LAST:event_btnInsertDrugActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new OrderOptions().setVisible(true);
        dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (fieldsIsFilled()) {
            OrderDAO orderDAO = new OrderDAO();
            String discount = txtDiscount.getText().replace(".", "").replace(",", ".");
            order.setDiscount(Float.parseFloat(discount));
            String freight = txtDiscount.getText().replace(".", "").replace(",", ".");
            order.setFreight(Float.parseFloat(freight));
            Consumer consumer = (Consumer) cmbConsumers.getModel().getSelectedItem();
            order.setSpecialClient(consumer);
            order.setTimeOrdered(LocalTime.now());
            order.setDateOrdered(LocalDate.now());
            
            try {
                if (orderDAO.insert(order)) {
                    JOptionPane.showMessageDialog(this,
                            "Medicamento cadastrado com Sucesso!",
                            "Mensagem ao Usuário",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Erro ao Cadastrar",
                            "Mensagem ao Usuário",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                            "Erro ao inserir no Banco de Dados",
                            "Mensagem ao Usuário",
                            JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,
                            "Erro Class ",
                            "Mensagem ao Usuário",
                            JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Os campos precisam estar preenchidos corretamente",
                "Mensagem ao Usuário",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btBack;
    private rojeru_san.RSButton btnInsertDrug;
    private rojeru_san.RSButton btnRemoveDrug;
    private rojeru_san.RSButton btnSave;
    private javax.swing.JComboBox<Consumer> cmbConsumers;
    private javax.swing.JComboBox<Drug> cmbDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblMedicamentos;
    private javax.swing.JLabel lblMedicamentos1;
    private javax.swing.JLabel lblMedicamentos2;
    private javax.swing.JLabel lblMedicamentos3;
    private javax.swing.JLabel lblMedicamentos4;
    private javax.swing.JTable tbDrugs;
    private javax.swing.JFormattedTextField txtDiscount;
    private javax.swing.JFormattedTextField txtFreight;
    private javax.swing.JFormattedTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
    public String ConvertDateToDatabase(String date) {
        java.util.Date formatDate;
        String databaseDate = "";
        try {
            formatDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            databaseDate = new SimpleDateFormat("yyyy-MM-dd").format(formatDate);
        } catch (ParseException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return databaseDate;
    }

    private void fillComboBoxes() {  
        try {
            Vector<Drug> drugsData = new Vector<>(drugDAO.list(""));
            drugBoxModel = new DefaultComboBoxModel<>(drugsData);
            cmbDrugs.setModel(drugBoxModel);
            
            Vector<Consumer> consumersData = new Vector<>(consumerDAO.list(""));
            Consumer c = new Consumer();
            c.setIdConsumer(-1);
            consumersData.add(0, c);
            consumerBoxModel = new DefaultComboBoxModel<>(consumersData);
            cmbConsumers.setModel(consumerBoxModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Erro de SQL: " + ex.getMessage(),
                    "Mensagem ao Usuario",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Erro de Classe " + ex.getMessage(),
                    "Mensagem ao Usuario",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDrugTable() {
        Vector<String> header = new Vector<>(2);
        header.add("Nome do medicamento");
        header.add("Quantidade");
        Vector rows = new Vector();
        
        for(Map.Entry<Drug, Integer> entry : order.getEntrySet()) {
            if (entry.getValue() > 0) {
                Vector data = new Vector(2);
                data.add(entry.getKey().getComname());
                data.add(entry.getValue());
                rows.add(data);
            }               
        }
        
        drugTableModel = new DefaultTableModel(rows, header);
        tbDrugs.setModel(drugTableModel);
    }
    
    private boolean fieldsIsFilled() {
        if (order.getEntrySet().isEmpty()) return false;
        for (Map.Entry<Drug, Integer> entry : order.getEntrySet()) {
            if (entry.getValue() <= 0) return false;
        }
        String freight = txtFreight.getText().replaceAll("[.,]", "").trim();
        String discount = txtDiscount.getText().replaceAll("[.,]", "").trim();
        
        return StringTools.isNotEmpty(discount, freight);
    }
}