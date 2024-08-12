/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bean_GRN;
import model.Bean_Paysheet;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pc
 */
public class Pay_Sheets extends javax.swing.JFrame {

    /**
     * Creates new form Pay_Sheets
     */
    public Pay_Sheets() {
        initComponents();
        loadUserType();
        loadMonthlySalary();
        loadSalary();
    }

    public void loadUsers(String text) {

        try {
            ResultSet rs = MySQL.search("SELECT `user`.`id` ,`user`.`name` , `user`.`username` ,`user`.`password` , `user`.`contact_number` ,`user_status`.`name` AS `status_name`, `user_type`.`name` AS `user_type` ,`city`.`name` AS `city_name` FROM `user`  INNER JOIN `city`ON `user`.city_id = `city`.id\n"
                    + " INNER JOIN `user_type`ON `user`.user_type_id =`user_type`.id INNER JOIN `user_status`ON `user`.user_status_id=`user_status`.id WHERE `user`.contact_number LIKE '" + text + "%' ORDER BY `user`.`id` ASC" + ";");

            if (rs.next()) {
                String name = rs.getString("user.name");
                String uid = rs.getString("id");
                String con = rs.getString("contact_number");

                jLabel6.setText(name);
                jLabel12.setText(uid);
                jLabel20.setText(con);

            } else {
                jLabel6.setText("None");
                jLabel20.setText("None");
                jLabel20.setText("None");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadUserType() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM `user_type`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMonthlySalary() {
        try {
            ResultSet rs = MySQL.search("SELECT user_type_of_payment.id ,user_type_of_payment.one_day_payment,user_type.name FROM  user_type_of_payment INNER JOIN user_type ON user_type.id = user_type_of_payment.user_type_id");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("one_day_payment"));
                v.add(rs.getString("name"));

                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSalary() {
        try {
            ResultSet rs = MySQL.search("SELECT salary.id, salary.date ,user_type_of_payment.one_day_payment,user.name FROM salary INNER JOIN user ON user.id=salary.user_id INNER JOIN user_type_of_payment ON \n"
                    + "user_type_of_payment.id=salary.user_type_of_payment_id");
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("date"));
                v.add(rs.getString("one_day_payment"));

                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("User Type");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setText("User Type");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel1.setText("User Type of Payment");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Payment");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton1.setText("Add  Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton2.setText("Update Monthly Payment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Monthly Payment", "User Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("User Type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, 309, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel4.setText("Search User By Phone Number");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("User Name");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("None");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("None");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setText("None");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setText("None");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel20.setText("None");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setText("Monthly Salary");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setText("Salary id");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setText("User ID");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setText("User Type");

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton3.setText("Print Salary Slip");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "User Name", "Date", "Monthly Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setText("User Contact Name");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setText("None");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        String text = jTextField2.getText();
        if (text.length() == 10) {
            jTextField2.setForeground(Color.blue);

        }
        loadUsers(text);

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        String price = jTextField1.getText();
        String text = price + evt.getKeyChar();

        if (!Pattern.compile("(0|0[.]|0[.][0-9]*)|[1-9]|[1-9][0-9]*|[1-9][0-9]*[.]|[1-9][0-9]*[.][0-9]*").matcher(text).matches()) {
            evt.consume();

        }

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String type = jComboBox1.getSelectedItem().toString();
        String prices = jTextField1.getText();
        if (jButton1.getText().equals("Add  Payment")) {
            if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select User Type", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!Pattern.compile("([1-9][0-9]*)|([0][.]([0]+[1-9]+)|([0-9]+))|([1-9][0-9]*[.][0-9]+)").matcher(prices).matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Price  ", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    ResultSet rs1 = MySQL.search("SELECT * FROM `user_type` WHERE `name`='" + type + "' ");
                    rs1.next();
                    String type_id = rs1.getString("id");

                    MySQL.iud("INSERT INTO `user_type_of_payment`(`one_day_payment`,`user_type_id`) VALUES ('" + prices + "','" + type_id + "')");

                    jTextField1.setText("");
                    jComboBox1.setSelectedIndex(0);
                    loadMonthlySalary();

                    JOptionPane.showMessageDialog(this, "Added New Monthly Payment", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } else {
            MySQL.iud("UPDATE `user_type_of_payment` SET `one_day_payment`='" + prices + "'  WHERE `id` = '" + salaryId + "'");
            loadMonthlySalary();
            jTextField1.setText("");
            jButton1.setText("Add  User Type Of  Payment");
            jButton2.setEnabled(true);

            JOptionPane.showMessageDialog(this, " Monthly Payment Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    String salaryId;

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a Row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            salaryId = jTable1.getValueAt(selectedRow, 0).toString();
            String price = jTable1.getValueAt(selectedRow, 1).toString();
            jTextField1.setText(price);

            jButton2.setEnabled(false);
            jButton1.setText("Update Monthly Salary");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Monthly salary Added TextField .Please Update Salary", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (jLabel12.getText().equals("None")) {
            JOptionPane.showMessageDialog(this, "Please Search user", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (evt.getClickCount() == 1) {
                int r = jTable1.getSelectedRow();
                if (r == -1) {

                } else {
                    int option = JOptionPane.showConfirmDialog(this, "If The Monthly Income You Have Chosen Correct ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        String salaryno = jTable1.getValueAt(r, 0).toString();
                        String salary = jTable1.getValueAt(r, 1).toString();
                        String utype = jTable1.getValueAt(r, 2).toString();

                        jLabel11.setText(salary);
                        jLabel8.setText(salaryno);
                        jLabel10.setText(utype);

                        JOptionPane.showMessageDialog(this, "Success.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String uid = jLabel12.getText();

        String salary_id = jLabel8.getText();

        if (salary_id.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please Select Salary", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dNow = sdf.format(new Date());

                InputStream stream = getClass().getResourceAsStream("/reports/Paysheets.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(stream);
                HashMap parameters = new HashMap();
                Date d = new Date();
                SimpleDateFormat sd_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

                String Empolyeeid = jLabel12.getText();
                String Empolyeename = jLabel6.getText();
                String contactnumber = jLabel20.getText();
                String Designat = jLabel10.getText();
                String MonthSalary = jLabel11.getText();

                parameters.put("Parameter8", Empolyeename);
                parameters.put("Parameter9", Designat);
                parameters.put("Parameter10", contactnumber);
                parameters.put("Parameter11", sd_time.format(d));

                Vector vec = new Vector();

                vec.add(new Bean_Paysheet(Empolyeeid, Empolyeename, Designat, MonthSalary));
                JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(vec);
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
                JasperPrintManager.printReport(jp, true);

                MySQL.iud("INSERT INTO `salary`(`user_id`,`date`,`user_type_of_payment_id`) VALUES ('" + uid + "','" + dNow + "','" + salary_id + "')");
                loadSalary();
                jLabel6.setText("None");
                jLabel20.setText("None");
                jLabel11.setText("None");
                jLabel8.setText("None");
                jLabel10.setText("None");
                jTextField1.setText("");

                JOptionPane.showMessageDialog(this, "Pay sheet Created", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Pay_Sheets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay_Sheets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay_Sheets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay_Sheets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay_Sheets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
