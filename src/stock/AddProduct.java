package stock;

//import com.sun.xml.internal.bind.v2.util.EditDistance;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import static stock.StockData.connection;

public class AddProduct extends javax.swing.JFrame {

    File pic = null;

    public AddProduct() {
        initComponents();
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

        jLabel4 = new javax.swing.JLabel();
        btnAddtoBasket2 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        txtItemName = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrice = new java.awt.TextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new java.awt.TextField();
        btnBrowse = new javax.swing.JButton();
        lblPic = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        btnAddtoBasket2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddtoBasket2.setText("SUBMIT");
        btnAddtoBasket2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddtoBasket2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoBasket2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Product");
        setExtendedState(6);
        setLocationByPlatform(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtItemName.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 220, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("New Product Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 291, -1));

        txtPrice.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 80, 30));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel16.setText("Price");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 68, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Image");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 107, -1));

        txtQuantity.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        txtQuantity.setName(""); // NOI18N
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 80, 30));

        btnBrowse.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBrowse.setBorderPainted(false);
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jPanel1.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 80, 32));

        lblPic.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(lblPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 180, 140));

        btnAdd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAdd.setText("ADD PRODUCT");
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.setBorderPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 110, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Quantity ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 107, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 300, 84, 87);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        AddImage();

    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnAddtoBasket2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoBasket2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddtoBasket2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            int price = Integer.parseInt(txtPrice.getText());
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null,
                        "Please re-eneter you price", "Numbers only", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
           int quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null,
                        "Please re-eneter you quantity", "Numbers only", JOptionPane.ERROR_MESSAGE);
        }

        try {
            AddProduct(txtItemName.getText(), Double.valueOf(txtPrice.getText()), Integer.valueOf(txtQuantity.getText()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduct().setVisible(true);
            }
        });
    }

    public File AddImage() {

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = file.getSelectedFile();
            pic = selectedFile;
            String path = selectedFile.getAbsolutePath();
            lblPic.setIcon(ResizeImage(path));

        }
        return pic;
    }

    public ImageIcon ResizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }

    public void AddProduct(String name, double price, int quantity) throws FileNotFoundException {
        FileInputStream fis;
        if (pic == null) {
            fis = null;
        } else {
            fis = new FileInputStream(pic);
        }

        try {
//            StockData.stmt.execute("INSERT INTO PRODUCTS(NAME, PRICE, QUANTITY, IMAGE) VALUES('" + name + "', " + price + "," + quantity + "," + fis + ")");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUCTS(NAME, PRICE, QUANTITY, IMAGE) VALUES(?,?,?,?)");
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, quantity);
            statement.setBlob(4, fis);
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StockData.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/stock/Resources/tick.png"));
        JOptionPane.showMessageDialog(btnAdd,
                name + " has been added successfully.", "Confirmation", JOptionPane.INFORMATION_MESSAGE, icon);
        txtItemName.setText(null);
        txtPrice.setText(null);
        txtQuantity.setText(null);
        lblPic.setIcon(null);
        EditProduct editProduct = new EditProduct();
        Master.UpdateCombobox(editProduct.cmbItemSelect);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnAddtoBasket2;
    public javax.swing.JButton btnBrowse;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblPic;
    public java.awt.TextField txtItemName;
    public java.awt.TextField txtPrice;
    public java.awt.TextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
