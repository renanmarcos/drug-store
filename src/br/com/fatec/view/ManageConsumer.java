package br.com.fatec.view;

import br.com.fatec.DAO.ConsumerDAO;
import br.com.fatec.model.Consumer;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageConsumer extends javax.swing.JFrame {
    Consumer consumer;
    ConsumerDAO consumerDAO = new ConsumerDAO();
    int cod;
    DefaultTableModel TabelModel;
    /**
     * Creates new form RegisterConsumer
     */
    public ManageConsumer() throws ParseException {
        initComponents();
        tableFill();
        this.setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BirthText = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            BirthText = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel4 = new javax.swing.JLabel();
        CPFText = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("###.###.###-##");
            CPFText = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        RGText = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##.###.###-#");
            RGText = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PhoneText = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("(##) ####-####");
            PhoneText = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel7 = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        btEdit = new rojeru_san.RSButton();
        btBack = new rojeru_san.RSButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClient = new javax.swing.JTable();
        btDelete = new rojeru_san.RSButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Cliente Especial");
        setMaximumSize(new java.awt.Dimension(851, 600));
        setMinimumSize(new java.awt.Dimension(851, 600));
        setResizable(false);
        setSize(getMinimumSize());
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Nome");

        NameText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameText.setBorder(null);
        NameText.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText(" Nascimento");

        BirthText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BirthText.setBorder(null);
        BirthText.setEnabled(false);
        BirthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthTextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("CPF");

        CPFText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CPFText.setBorder(null);
        CPFText.setEnabled(false);

        RGText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RGText.setBorder(null);
        RGText.setEnabled(false);
        RGText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGTextActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("RG");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Telefone");

        PhoneText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PhoneText.setBorder(null);
        PhoneText.setEnabled(false);
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Email");

        EmailText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EmailText.setBorder(null);
        EmailText.setEnabled(false);
        EmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTextActionPerformed(evt);
            }
        });

        btEdit.setBackground(new java.awt.Color(1, 198, 83));
        btEdit.setText("Editar");
        btEdit.setColorHover(new java.awt.Color(0, 102, 51));
        btEdit.setEnabled(false);
        btEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btBack.setBackground(new java.awt.Color(1, 198, 83));
        btBack.setText("Voltar");
        btBack.setColorHover(new java.awt.Color(0, 102, 51));
        btBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 198, 83));
        jLabel8.setText("Gerenciamento de Cliente Especial");

        tbClient.setBackground(new java.awt.Color(204, 204, 204));
        tbClient.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbClient.setToolTipText("");
        tbClient.setGridColor(new java.awt.Color(255, 255, 255));
        tbClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClient);

        btDelete.setBackground(new java.awt.Color(1, 198, 83));
        btDelete.setText("Excluir");
        btDelete.setColorHover(new java.awt.Color(0, 102, 51));
        btDelete.setEnabled(false);
        btDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CPFText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RGText, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BirthText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(BirthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(CPFText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RGText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(PhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(112, 0, 750, 570);

        jPanel3.setBackground(new java.awt.Color(1, 198, 83));
        jPanel3.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 110, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTextActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new ConsumerOptions().setVisible(true);
        dispose();  
    }//GEN-LAST:event_btBackActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        String Phone = PhoneText.getText().replace("(", "");
        Phone = Phone.replace(") ", "");
        Phone = Phone.replace("-", "");
        
        consumer = new Consumer();
        consumer.setName(NameText.getText());
        consumer.setCpf(CPFText.getText());
        consumer.setEmail(EmailText.getText());
        consumer.setFone(Phone);
        consumer.setDate(convertDateToDatabase(BirthText.getText()));
        consumer.setRg(RGText.getText()); 
        consumer.setIdConsumer(cod);
        try {
            if(consumerDAO.edit(consumer)) {
                JOptionPane.showMessageDialog(this,
                        "Cadastro Alterado com Sucesso!",
                        "Mensagem ao Usuário",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "Erro ao Alterar",
                        "Mensagem ao Usuário",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                        "Erro SQL " + ex.getMessage(),
                        "Mensagem ao Usuário",
                        JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                        "Erro Class " + ex.getMessage(),
                        "Mensagem ao Usuário",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void RGTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RGTextActionPerformed

    private void tbClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientMouseClicked
        int line = tbClient.getSelectedRow();
        cod = (Integer)tbClient.getValueAt(line, 0);
        
        try {
            Consumer c = new Consumer();
            c.setIdConsumer(cod);
            c = consumerDAO.search(c);
            
            String RG = c.getRg().replace(".", "");
            RG.replace("-", "");
            String CPF = c.getCpf().replace(".", "");
            CPF.replace("-", "");
            if(c != null) {
                //jogar dados para a tela
                NameText.setText(c.getName());
                RGText.setText(RG);
                CPFText.setText(CPF);
                EmailText.setText(c.getEmail());
                PhoneText.setText(c.getFone());
                BirthText.setText(convertDateToString(c.getDate()));
                Enable();
            }
            else {
                JOptionPane.showMessageDialog(this, 
                        "Cliente não Encontrado",
                        "Mensagem ao Usuário",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tbClientMouseClicked

    private void BirthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BirthTextActionPerformed

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int resp;
        resp = JOptionPane.showConfirmDialog(this,"Deseja realmente excluir?", "Mensagem ao Usuário", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(resp == JOptionPane.YES_OPTION){
            consumer = new Consumer();
            consumer.setIdConsumer(cod);
            try {
                if(consumerDAO.delete(consumer)) {
                    JOptionPane.showMessageDialog(this, "Cliente excluido com sucesso", "Mensagem ao Usuário", JOptionPane.INFORMATION_MESSAGE);
                    Clear();
                    tableFill();
                    Disable();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Erro ao Excluir","Mensagem ao Usuário", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro SQL " + ex.getMessage(), "Mensagem ao Usuário", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Erro Class " + ex.getMessage(), "Mensagem ao Usuário", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ManageConsumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageConsumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageConsumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageConsumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageConsumer().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BirthText;
    private javax.swing.JTextField CPFText;
    private javax.swing.JTextField EmailText;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JTextField RGText;
    private rojeru_san.RSButton btBack;
    private rojeru_san.RSButton btDelete;
    private rojeru_san.RSButton btEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbClient;
    // End of variables declaration//GEN-END:variables
    private void Clear() {
        RGText.setText("");
        NameText.setText("");
        CPFText.setText("");
        BirthText.setText("");
        PhoneText.setText("");  
        EmailText.setText("");
    }    
    private void Enable() {
        RGText.setEnabled(true);
        NameText.setEnabled(true);
        CPFText.setEnabled(true);
        BirthText.setEnabled(true);
        PhoneText.setEnabled(true);
        EmailText.setEnabled(true);
        btDelete.setEnabled(true);
        btEdit.setEnabled(true);
    }
    private void Disable() {
        RGText.setEnabled(false);
        NameText.setEnabled(false);
        CPFText.setEnabled(false);
        BirthText.setEnabled(false);
        PhoneText.setEnabled(false);
        EmailText.setEnabled(false);
        btDelete.setEnabled(false);
        btEdit.setEnabled(false);
    }
    
    public String convertDateToDatabase(String date) {
        java.util.Date FormatDate;
        String DatabaseDate = "";
        try {
            FormatDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            DatabaseDate = new SimpleDateFormat("yyyy-MM-dd").format(FormatDate);
        } catch (ParseException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatabaseDate;
    }
    public String convertDateToString(String date) {
        java.util.Date FormatDate;
        String DatabaseDate = "";
        try {
            FormatDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            DatabaseDate = new SimpleDateFormat("ddMMyyyy").format(FormatDate);
        } catch (ParseException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatabaseDate;
    }
    private void tableFill() {
        try {
            List<Consumer> data = consumerDAO.list("");

            Vector<String> header = new Vector<>(3);
            header.add("Código");
            header.add("Nome");
            header.add("CPF");
            
            Vector lines = new Vector();
            Vector record = new Vector();
            
            for(Consumer c : data) {
                record = new Vector(3);
                record.add(c.getIdConsumer());
                record.add(c.getName());
                record.add(c.getCpf());
                lines.add(record);                
            }
            
            //coloca os vetores no modelo da tabela
            TabelModel = new DefaultTableModel(lines, header);
            
            //jogar o modelo dentro do jtable
            tbClient.setModel(TabelModel);
            
            //ajustar tamanhos das colunas
            tbClient.getColumnModel().getColumn(0)
                    .setPreferredWidth(70);
            tbClient.getColumnModel().getColumn(1)
                    .setPreferredWidth(350);
            tbClient.getColumnModel().getColumn(2)
                    .setPreferredWidth(100);
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}