/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author st8511x
 */
public class CheckStock extends javax.swing.JFrame {

    /**
     * Creates new form CheckStock2
     */
    public CheckStock() {
        initComponents();
        cmbItemSelect.setEditable(true);

//        ArrayList<String> productList = StockData.GetProducts();
//        //populating the combo box by filling it with the array list 
//        cmbItemSelect.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        txtItemPrice = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtItemName = new java.awt.TextField();
        txtStockInitial = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtItemKey = new java.awt.TextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstItemList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        cmbItemSelect = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Check Stock ");
        setExtendedState(6);
        setLocationByPlatform(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl1.setBackground(new java.awt.Color(204, 204, 255));
        pnl1.setDoubleBuffered(false);
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtItemPrice.setEditable(false);
        txtItemPrice.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        pnl1.add(txtItemPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 91, 35));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Price");
        pnl1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 20));

        txtItemName.setEditable(false);
        txtItemName.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        pnl1.add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, 35));

        txtStockInitial.setEditable(false);
        txtStockInitial.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        txtStockInitial.setName(""); // NOI18N
        pnl1.add(txtStockInitial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 71, 35));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Stock");
        pnl1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 20));

        txtItemKey.setEditable(false);
        txtItemKey.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        txtItemKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemKeyActionPerformed(evt);
            }
        });
        pnl1.add(txtItemKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 91, 30));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel15.setText("Key");
        pnl1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 40, 30));

        jLabel7.setText("jLabel7");
        pnl1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -40, -1, -1));

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl1.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 230, 170));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel16.setText("Name");
        pnl1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 50));

        jPanel1.add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 310, 400));

        lstItemList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(lstItemList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 160, 380));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 50, 40));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stock/Resources/magnifier12.png"))); // NOI18N
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.setBorderPainted(false);
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 70, 70));

        cmbItemSelect.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        cmbItemSelect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        cmbItemSelect.setEditable(true);
        cmbItemSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbItemSelectActionPerformed(evt);
            }
        });
        jPanel1.add(cmbItemSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 220, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setText("Item Search");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 184, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 150, 0, 319);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void cmbItemSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbItemSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbItemSelectActionPerformed

    private void txtItemKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemKeyActionPerformed

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
            java.util.logging.Logger.getLogger(CheckStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSearch;
    public javax.swing.JComboBox cmbItemSelect;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblImage;
    public javax.swing.JList lstItemList;
    public javax.swing.JPanel pnl1;
    public java.awt.TextField txtItemKey;
    public java.awt.TextField txtItemName;
    public java.awt.TextField txtItemPrice;
    public java.awt.TextField txtStockInitial;
    // End of variables declaration//GEN-END:variables
}