
package form;

import bll.UserAccount;
import dao.DatabaseDao;
import dao.DatabaseDaoImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class IntFrmUserAccount extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntFrmUserAccount
     */
    private ArrayList<String> dataList;

    public IntFrmUserAccount() {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        DatabaseDao dd = new DatabaseDaoImpl();

        loadDataToTable();

        try {
            dataList = dd.getDataFromFile("UserLoginDetails.txt");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void loadDataToTable() {

        DatabaseDao dd = new DatabaseDaoImpl();

        DefaultTableModel defaultTableModel = new DefaultTableModel(new String[]{"User Id", "Full Name", "Username", "Password", "Role"}, 0);
        try {
            dataList = dd.getDataFromFile("UserLoginDetails.txt");
            Object[] tableLines;
            tableLines = dataList.toArray();
            for (int i = 0; i < tableLines.length; i++) {

                String lines = tableLines[i].toString();
                String[] row = lines.split(",");
                defaultTableModel.addRow(row);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        jTable1.setModel(defaultTableModel);
    }

    private boolean valid() {
        String filePath = "UserLoginDetails.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String lines = tableLines[i].toString().trim();
                String[] dataRow = lines.split(",");
                if (txtUID.getText().equals(dataRow[0])) {
                    JOptionPane.showMessageDialog(this, "User Id should be unique");
                    return false;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        if (txtFName.getText() == null || txtFName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Full Name is required");
            return false;
        } else if (txtUName.getText() == "" || txtUName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Username is required");
            return false;
        } else if (txtPassword.getText() == "" || txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Password is required");
            return false;
        }
        return true;
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtUID = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(800, 575));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 55));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("User Account Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 525));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel2.setText("Full Name");

        txtFName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtFName.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel3.setText("Username");

        txtUName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUName.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel5.setText("Role");

        cmbRole.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Delivery Staff" }));
        cmbRole.setPreferredSize(new java.awt.Dimension(200, 25));
        cmbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 51, 51));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(200, 25));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel6.setText("User Id");

        txtUID.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUID.setPreferredSize(new java.awt.Dimension(200, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtUName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel4))
                                    .addComponent(txtUID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnAdd)
                        .addGap(50, 50, 50)
                        .addComponent(btnUpdate)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addGap(119, 119, 119))))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DatabaseDao dd = new DatabaseDaoImpl();
        try {
            dataList = dd.getDataFromFile("UserLoginDetails.txt");

        } catch (Exception ex) {

        }
        UserAccount ul = new UserAccount();
        if (valid()) {
            ul.setUid(txtUID.getText());
            ul.setFullname(txtFName.getText());
            ul.setUsername(txtUName.getText());
            ul.setPassword(txtPassword.getText());
            ul.setRole(cmbRole.getSelectedItem().toString());

            ArrayList<String> list = dataList;

            list.add(ul.getUid()+ "," + ul.getFullname() + "," + ul.getUsername() + "," + ul.getPassword() + "," + ul.getRole());

            dd.writeToFile("UserLoginDetails.txt", list);

            JOptionPane.showMessageDialog(rootPane, "Sucess");

            loadDataToTable();
            txtUID.setText("");
            txtFName.setText("");
            txtUName.setText("");
            txtPassword.setText("");
            cmbRole.setSelectedIndex(0);

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean found = false;

        UserAccount ul = new UserAccount();

        DatabaseDao dd = new DatabaseDaoImpl();

        if (txtFName.getText() == null || txtFName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select from the table to update record");
        } else {

            ul.setFullname(txtFName.getText());
            ul.setUsername(txtUName.getText());
            ul.setPassword(txtPassword.getText());
            ul.setRole(cmbRole.getSelectedItem().toString());

            for (int i = 0; i < dataList.size(); i++) {

                String[] storedData;
                ArrayList<String> list = dataList;
                storedData = list.get(i).split(",");
                if (txtFName.getText().equals(storedData[0])) {

                    list.set(i, ul.getFullname() + "," + ul.getUsername() + "," + ul.getPassword() + "," + ul.getRole());

                    dd.writeToFile("UserLoginDetails.txt", list);

                    found = true;
                    break;
                }
            }
            if (found) {

                JOptionPane.showMessageDialog(this, "Updated Sucessfully");

                loadDataToTable();
                txtUID.setText("");
                txtFName.setText("");
                txtUName.setText("");
                txtPassword.setText("");
                cmbRole.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Sorry file not Updated");
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        boolean found = false;
        DatabaseDao dd = new DatabaseDaoImpl();
        try {
            dataList = dd.getDataFromFile("UserLoginDetails.txt");

        } catch (Exception ex) {

        }
        for (int i = 0; i < dataList.size(); i++) {

            String[] storedData;
            ArrayList<String> list = dataList;
            storedData = list.get(i).split(",");
            if (txtUID.getText().equals(storedData[0])) {
                found = true;
                list.remove(i);
                dd.writeToFile("UserLoginDetails.txt", list);
                break;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(this, "Deleted Sucessfully");
            
            loadDataToTable();
            txtUID.setText("");
            txtFName.setText("");
            txtUName.setText("");
            txtPassword.setText("");
            cmbRole.setSelectedIndex(0);
        } else {
             JOptionPane.showMessageDialog(this,txtUID.getText());
//            JOptionPane.showMessageDialog(this, "Sorry file not deleted");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtUID.setText("");
        txtFName.setText("");
        txtUName.setText("");
        txtPassword.setText("");
        cmbRole.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if (row < 0) {

            JOptionPane.showMessageDialog(this, "Sorry No Data Selected");
        } else {

            String id = (jTable1.getModel().getValueAt(row, 0).toString());
            for (int i = 0; i < dataList.size(); i++) {

                String[] storedData = dataList.get(i).split(",");
                if (id.equals(storedData[0])) {
                    txtUID.setText(storedData[0]);
                    txtFName.setText(storedData[1]);
                    txtUName.setText(storedData[2]);
                    txtPassword.setText(storedData[3]);
                    cmbRole.setSelectedItem(storedData[4]);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cmbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRoleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUID;
    private javax.swing.JTextField txtUName;
    // End of variables declaration//GEN-END:variables
}
