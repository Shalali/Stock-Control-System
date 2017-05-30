package stock;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class Master implements ActionListener {

    //CREATE OBJECTS of each form
    static PurchaseItem purchaseItem = new PurchaseItem();
    UpdateStock updateStock = new UpdateStock();
    AddProduct addProduct = new AddProduct();
    static EditProduct editProduct = new EditProduct();
    Login login = new Login();
    LoginTopLevel loginTop = new LoginTopLevel();
    CheckStock checkStock = new CheckStock();
    static MasterFrm masterFrm = new MasterFrm();
    ManageAccounts manageAccounts = new ManageAccounts();
    static LoginMain loginMain = new LoginMain();
    StockData stockData = new StockData();

    public static void main(String[] args) {
        Master master = new Master();
        loginMain.setVisible(true);

    }

    public Master() {
        masterFrm.btnCheckStock.addActionListener(this);
        masterFrm.btnPurchaseItem.addActionListener(this);
        masterFrm.btnUpdateStock.addActionListener(this);
        masterFrm.btnManageAccounts.addActionListener(this);
        purchaseItem.btnAddToBasket.addActionListener(this);
        purchaseItem.btnSearch.addActionListener(this);
        updateStock.btnAddNewProduct.addActionListener(this);
        updateStock.btnEditProduct.addActionListener(this);
        editProduct.btnSearch.addActionListener(this);
        login.btnLogin.addActionListener(this);
        SwingUtilities.getRootPane(login.btnLogin).setDefaultButton(login.btnLogin);
        loginTop.btnLogin.addActionListener(this);
        SwingUtilities.getRootPane(loginTop.btnLogin).setDefaultButton(loginTop.btnLogin);
        checkStock.btnSearch.addActionListener(this);
        manageAccounts.btnAddUser.addActionListener(this);
        addProduct.btnAdd.addActionListener(this);
        loginMain.btnLogin.addActionListener(this);
        SwingUtilities.getRootPane(loginMain.btnLogin).setDefaultButton(loginMain.btnLogin);
        loginMain.btnSignUp.addActionListener(this);
        editProduct.btnUpdate.addActionListener(this);
        //editProduct.btnDeleteProduct.addActionListener(this);

    }
    //global variable so that cmb box in purchase item can receive the latest key 
    String keyName;
    String editProductKey;
    static String w;
    
    public void PurchaseItem() {
        String selectedItemKey = GetSelectedItemKey(purchaseItem.cmbItemSelect);
        purchaseItem.selectedItemKey = selectedItemKey;
        keyName = StockData.getName(selectedItemKey);

        if (keyName == null) {
            JOptionPane.showMessageDialog(purchaseItem.btnSearch,
                    "An invalid key has been entered.", "Error", JOptionPane.ERROR_MESSAGE);//if no match is found
        } else {
            purchaseItem.pnl1.setVisible(true);
            purchaseItem.txtItemName.setText(keyName);

//output Stock 
            int stock = StockData.getQuantity(selectedItemKey);//getQuantity inputs string but returns integer
            purchaseItem.txtStockInitial.setText(String.valueOf(stock));//this must be converted back to string to output

//output PRICE
            double price = StockData.getPrice(selectedItemKey); //obtain price from stock data
            DecimalFormat pounds = new DecimalFormat("£#,##0.00");//pound sign needed
            purchaseItem.txtItemPrice.setText(pounds.format(price));//convert Double to String so it can be output in correct format
//output IMAGE
            purchaseItem.lblPic.setIcon(null);
            stockData.GetImage(selectedItemKey, purchaseItem.lblPic);
            
            purchaseItem.lblIemKey.setText(selectedItemKey);
        }
    }

//COMMENT THIS
    //FOR PI, Edit Item and CheckStock FORM; Refactored code, method is reused many times hence parameter
    public static String GetSelectedItemKey(JComboBox x) {

        String selectedItemStr = x.getSelectedItem().toString(); //user input (key) is stored
        String selectedItemKey = "";
        for (Map.Entry<String, String> e : StockData.GetProductDictionary().entrySet()) {
            String key = e.getKey();
            String value = e.getValue();
            //in case value is null then continue
            if (value != null) {
                if (value.equalsIgnoreCase(selectedItemStr)) {
                    selectedItemKey = key;
                    break;
                }
            }
        }

        return selectedItemKey;
    }

    public static String EditProduct() {
        String selectedItemKey = GetSelectedItemKey(editProduct.cmbItemSelect);
        String keyName = StockData.getName(selectedItemKey);

        if (keyName == null) {
            JOptionPane.showMessageDialog(editProduct.btnSearch,
                    "An invalid key has been entered.", "Error", JOptionPane.ERROR_MESSAGE);//if no match is found
        } else {

            editProduct.pnlEP.setVisible(true);

//output ITEM NAME
            editProduct.txtUpdateName.setText(keyName);

//output QUANTITY 
            int stock = StockData.getQuantity(selectedItemKey);//getQuantity inputs string but returns integer
            editProduct.spnUpdateStock.setValue(stock);//this must be converted back to string to output

//output PRICE
            double price = StockData.getPrice(selectedItemKey); //obtain price from stock data
            //DecimalFormat pounds = new DecimalFormat("£#,##0.00");//pound sign needed
            editProduct.txtUpdatePrice.setText(String.valueOf(price));//convert Double to String so it can be output in correct format

//output IMAGE
            editProduct.lblPic.setIcon(null);
            StockData.GetImage(selectedItemKey, editProduct.lblPic);
        }

        return selectedItemKey;
    }

    public void UpdateProduct(String key) throws FileNotFoundException {
        String quantityStr = editProduct.spnUpdateStock.getValue().toString();
        int quantity = Integer.valueOf(quantityStr);
        String updatedName = editProduct.txtUpdateName.getText();
        String updatedPriceStr = editProduct.txtUpdatePrice.getText();
        double updatedPrice = Double.valueOf(updatedPriceStr);
        editProduct.UpdateProduct(key, updatedName, updatedPrice, quantity);
    }

    public void CheckStock() {
        String selectedItemKey = GetSelectedItemKey(checkStock.cmbItemSelect);
        String keyName = StockData.getName(selectedItemKey);

        if (keyName == null) {
            JOptionPane.showMessageDialog(checkStock.btnSearch,
                    "An invalid key has been entered.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            checkStock.pnl1.setVisible(true);
            checkStock.txtItemName.setText(keyName);
            checkStock.txtItemKey.setText(selectedItemKey);
            int stock = StockData.getQuantity(selectedItemKey);//getQuantity inputs string but returns integer
            checkStock.txtStockInitial.setText(String.valueOf(stock));//this must be converted back to string to output
            double price = StockData.getPrice(selectedItemKey); //obtain price from stock data
            DecimalFormat pounds = new DecimalFormat("£#,##0.00");//pound sign needed
            checkStock.txtItemPrice.setText(pounds.format(price));//

            //output list 
            ArrayList<String> productList = StockData.GetProducts();
            //populating the listbox by filling it with the array list 
            //JList and combo box are inherited from common ancestor/class
            checkStock.lstItemList.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));
            stockData.GetImage(selectedItemKey, checkStock.lblImage);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == masterFrm.btnPurchaseItem) {
//            ArrayList<String> productList = StockData.GetProducts();
//            //populating the combo box by filling it with the array list 
//            purchaseItem.cmbItemSelect.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));
            UpdateCombobox(purchaseItem.cmbItemSelect);
            try {
                StockData.stmt.execute("DELETE FROM BASKET");
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
            purchaseItem.setVisible(true);
        } else if (e.getSource() == masterFrm.btnCheckStock) {
//            ArrayList<String> productList = StockData.GetProducts();
//            //populating the combo box by filling it with the array list 
//            checkStock.cmbItemSelect.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));
            UpdateCombobox(checkStock.cmbItemSelect);
            checkStock.setVisible(true);
        } else if (e.getSource() == masterFrm.btnUpdateStock) {
            login.setVisible(true);

        } else if (e.getSource() == masterFrm.btnManageAccounts) {
            loginTop.setVisible(true);
        }

//hide panel (that way fields are only shown when valid item is selected)
        purchaseItem.pnl1.setVisible(false);
        checkStock.pnl1.setVisible(false);

        if (e.getSource() == purchaseItem.btnSearch) {//when the find button on PI form is clicked
            PurchaseItem();
            ArrayList<String> stockList = new ArrayList<String>();
            String selectedItemKey = GetSelectedItemKey(purchaseItem.cmbItemSelect);
            int stock = StockData.getQuantity(selectedItemKey);
            for (int i = 1; i <= stock; i++) {
                stockList.add(Integer.toString(i));
            }
            //binding the data to be displayed in the combo box
            purchaseItem.cmbQuantity.setModel(new javax.swing.DefaultComboBoxModel<>(stockList.toArray(new String[0])));
            purchaseItem.CalculateBill();
        }

        if (e.getSource() == editProduct.btnSearch) {//when the find butto form is clicked
            editProductKey = EditProduct();//goes to EP method

        }

//        if (e.getSource() == editProduct.btnDeleteProduct) {
//            editProductKey = EditProduct();
//            //keyName = EditProduct();
//            String keyName = StockData.getName(editProductKey);
//            stockData.DeleteProduct(editProductKey, keyName);
//
//        }
        if (e.getSource() == editProduct.btnUpdate) {
            try {
                UpdateProduct(editProductKey);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
//            ArrayList<String> productList = StockData.GetProducts();
//            populating the combo box by filling it with the array list 
//            editProduct.cmbItemSelect.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));
            UpdateCombobox(editProduct.cmbItemSelect);
        }

        if (e.getSource() == updateStock.btnEditProduct) {
//            ArrayList<String> productList = StockData.GetProducts();
//            //populating the combo box by filling it with the array list 
//            editProduct.cmbItemSelect.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));
            UpdateCombobox(editProduct.cmbItemSelect);
            editProduct.setVisible(true);

        }
        if (e.getSource() == updateStock.btnAddNewProduct) {
            addProduct.setVisible(true);

        }
        if (e.getSource() == checkStock.btnSearch) {
            CheckStock();
        }
        if (e.getSource() == loginTop.btnLogin) {

            String enteredID = loginTop.txtUserID.getText();
            w = enteredID;
            char[] enteredPassword = loginTop.txtPassword.getPassword();
            String strEnteredPassword = new String(enteredPassword);
            boolean check = false;
            try {
                check = stockData.CheckCredentials(enteredID, strEnteredPassword); //GET FROM DB
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }

            boolean privileges = false;
            try {
                privileges = stockData.CheckPrivilegesAccess(enteredID);
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check == true && privileges == true) {
                //typecast tells complier the type of the object it is
                //stockData.GetAccounts();
                manageAccounts.setVisible(true);
                loginTop.setVisible(false);
                manageAccounts.txtWelcome.setText(enteredID);
                loginTop.txtUserID.setText("");
                loginTop.txtPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(new JButton(),
                        "Username or password is incorrect", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == login.btnLogin) {

            String enteredID = login.txtUserID.getText();
            char[] enteredPassword = login.txtPassword.getPassword();
            String strEnteredPassword = new String(enteredPassword);
            boolean check = false;
            try {
                check = stockData.CheckCredentials(enteredID, strEnteredPassword); //GET FROM DB
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean employee = false;
            try {
                employee = stockData.CheckIfEmployee(enteredID);
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check == true && employee == true) {
                //typecast tells complier the type of the object it is
                updateStock.setVisible(true);
                login.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(new JButton(),
                        "Username or password is incorrect", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
            }
            login.txtUserID.setText(null);
            login.txtPassword.setText(null);

        }

        if (e.getSource() == loginMain.btnLogin) {

            String enteredID = loginMain.txtUserID.getText();
            char[] enteredPassword = loginMain.txtPassword.getPassword();
            String strEnteredPassword = new String(enteredPassword);
            boolean check = false;
            try {
                check = stockData.CheckCredentials(enteredID, strEnteredPassword);
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check == true) {
                //typecast tells complier the type of the object it is
                masterFrm.setVisible(true);
                loginMain.setVisible(false);
                masterFrm.txtName.setText(enteredID);
            } else {
                JOptionPane.showMessageDialog(new JButton(),
                        "Username or password is incorrect", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == loginMain.btnSignUp) {
            try {
                AddCustomerAccount();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String Welcome() {
        return w;
    }

    public static void UpdateCombobox(JComboBox combobox) {
        ArrayList<String> productList;
        productList = StockData.GetProducts();

        for (int i = 0; i < productList.size(); i++) {
            productList.set(i, productList.get(i).toLowerCase());
        }
        Collections.sort(productList);

        for (int i = 0; i < productList.size(); i++) {
            String x = productList.get(i);
            String cap = x.substring(0, 1).toUpperCase() + x.substring(1);
            productList.set(i, cap);
        }
        //populating the combo box by filling it with the array list 
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(productList.toArray(new String[0])));

    }

    public void AddCustomerAccount() throws FileNotFoundException, SQLException {
        //AddAccount(String name, String Password, boolean Employee, boolean ManageAcounts, Image image) throws FileNotFoundException {
        String name = loginMain.txtName.getText();
        String userName = loginMain.txtUserIDSignUp.getText();
        boolean usernameTaken = stockData.CheckUsernameSignUP(userName);
        //account can only be added if username is unique
        if (usernameTaken == false) {
            char[] pass = loginMain.txtNewPass.getPassword();
            String strPass = new String(pass);
            char[] passReenter = loginMain.txtNewPassAgain.getPassword();
            String passReenterStr = new String(passReenter);

            if (strPass.equals(passReenterStr)) {
                try {
                    //find code to ensure that the the userID has not been taken up already
                    stockData.AddAccount(name, userName, strPass, false, false, null);
                    loginMain.txtName.setText(null);
                    loginMain.txtUserIDSignUp.setText(null);
                    loginMain.txtNewPass.setText(null);
                    loginMain.txtNewPassAgain.setText(null);
                } catch (SQLException ex) {
                    Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(new JButton(),
                        "Please reenter passwords", "Passwords Mismatch", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
