package stock;

// Skeleton version of StockData.java that links to a database.
// NOTE: You should not have to make any changes to the other
// Java GUI classes for this to work, if you complete it correctly.
// Indeed these classes shouldn't even need to be recompiled
import java.awt.Image;
import static java.awt.SystemColor.window;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*; // DB handling package
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.derby.drda.NetworkServerControl;

public class StockData { //AND ACCOUTS INFO
//

    public static Connection connection;
    public static Statement stmt;
    EditProduct editProduct = new EditProduct();
    AddProduct addProduct = new AddProduct();
    static ManageAccounts manageAccounts = new ManageAccounts();
    UpdateStock updateStock = new UpdateStock();

    static {
        // standard code to open a connection and statement to an Access database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            //Establish a connection
            String sourceURL = "jdbc:derby://localhost:1527/ShStockDB";

//            NetworkServerControl server = new NetworkServerControl();
//            server.start(null);
            // Load JDBC driver
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Establish a connection
//            String sourceURL = "jdbc:derby://localhost:1527/"
//                    + new File("ShStockDB").getAbsolutePath() + ";";
            connection = DriverManager.getConnection(sourceURL, "derby", "derby");
            stmt = connection.createStatement();
        } // The following exceptions must be caught
        catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // You could make methods getName, getPrice and getQuantity simpler by using an auxiliary
    // private String method getField(String key, int fieldNo) to return the appropriate field as a String
    public static String getName(String key) {

        try {
            int keyInt = 0;
            if (key != null || key != "") {
                keyInt = Integer.parseInt(key);
            }
            // Need single quote marks ' around the key field in SQL. This is easy to get wrong!
            // For instance if key was "11" the SELECT statement would be:
            // SELECT * FROM Stock WHERE stockKey = '11'
            ResultSet res = stmt.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTID = " + keyInt);
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getString("NAME");
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static double getPrice(String key) {
        // Similar to getName. If no result, return -1.0
        try {

            int keyInt = Integer.parseInt(key);
            // Need single quote marks ' around the key field in SQL. This is easy to get wrong!
            // For instance if key was "11" the SELECT statement would be:
            // SELECT * FROM Stock WHERE stockKey = '11'
            ResultSet res = stmt.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTID = " + keyInt);
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getDouble("PRICE");
            } else {
                return 0.0;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0.0;
        }

    }

    public static int getQuantity(String key) {
        // Similar to getName. If no result, return -1
        try {

            int keyInt = Integer.parseInt(key);
            // Need single quote marks ' around the key field in SQL. This is easy to get wrong!
            // For instance if key was "11" the SELECT statement would be:
            // SELECT * FROM Stock WHERE stockKey = '11'
            ResultSet res = stmt.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTID = " + keyInt);
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getInt("QUANTITY");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            // this shouldn't happen
            System.out.println(e);
        }
    }

    //Populated combobox with items
    public static ArrayList<String> GetProducts() {
        try {

            ResultSet res = stmt.executeQuery("SELECT * FROM PRODUCTS WHERE NAME <> ''");
            ArrayList<String> productList = new ArrayList<String>();
            while (res.next()) { // there is a result
                productList.add(res.getString("NAME"));
            }

            return productList;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    //COMMENT THIS: FILLS CMB
    //Dictionary data type is a collection that holds key value pairs 
    public static Map<String, String> GetProductDictionary() {
        Map<String, String> products = new HashMap<String, String>();

        try {

            ResultSet res = stmt.executeQuery("SELECT * FROM PRODUCTS");

            while (res.next()) { // there is a result
                products.put(String.valueOf(res.getInt("PRODUCTID")), res.getString("NAME"));

            }

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return products;
    }

    public void DeleteProduct(String keyStr, String name) {

        try {
            int key = Integer.parseInt(keyStr);
            String deleteSQL = "DELETE FROM PRODUCTS WHERE PRODUCTID = " + key;
            System.out.println(deleteSQL);
            stmt.execute(deleteSQL);
            editProduct.yes(true);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void AddAccount(String name, String userName, String Password, boolean Employee, boolean ManageAcounts, Image image) throws FileNotFoundException, SQLException {

        stmt.execute("INSERT INTO ACCOUNTS(NAME, PASSWORD, EMPLOYEE, MANAGEACCOUNTS, IMAGE, USERNAME) VALUES('" + name + "','" + Password + "'," + Employee + ","
                + ManageAcounts + "," + image + ",'" + userName + "'" + ")");
        ImageIcon icon = new ImageIcon(getClass().getResource("/stock/Resources/tick.png"));
        JOptionPane.showMessageDialog(addProduct.btnAdd,
                userName + " has been created successfully.", "Account Created", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public static void UpdateAccount(boolean Employee, boolean ManageAcounts, String username) {
        try {
            //stmt.execute("UPDATE ACCOUNTS SET EMPLOYEE= '" + Employee + "', MANAGEACCOUNTS= '" + ManageAcounts + "' WHERE USERNAME = '" + username +"'");

            //PREPARE STATEMENT
            String SQL = "UPDATE ACCOUNTS SET EMPLOYEE = ?, MANAGEACCOUNTS = ? WHERE USERNAME = ?";
            //GET CONNECTION OBJECT
            PreparedStatement statement = StockData.connection.prepareStatement(SQL);
            //POPULATE PARAMETERS
            statement.setBoolean(1, Employee);
            statement.setBoolean(2, ManageAcounts);
            statement.setString(3, username);
            //EXECUTE
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StockData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean CheckUsernameSignUP(String userName) throws SQLException {
        boolean usernameTaken = false;

        ResultSet res = stmt.executeQuery("SELECT USERNAME FROM ACCOUNTS");
        while (res.next()) { // there is a result
            String UN = res.getString("USERNAME");
            if (userName.equals(UN)) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a different username", "Username taken", JOptionPane.ERROR_MESSAGE);

                usernameTaken = true;
                break;
            }

        }

        return usernameTaken;

    }

    public boolean CheckCredentials(String userNameEntered, String passwordEntered) throws SQLException {
        boolean check = false;
        ResultSet res = stmt.executeQuery("SELECT PASSWORD FROM ACCOUNTS WHERE USERNAME = '" + userNameEntered + "'");
        if (res.next()) { // there is a result
            String p = res.getString("PASSWORD");
            if (p.equals(passwordEntered)) {
                check = true;
            }
        }
        return check;
    }

    public boolean CheckIfEmployee(String userNameEntered) throws SQLException {
        boolean employee = false;
        ResultSet res = stmt.executeQuery("SELECT EMPLOYEE FROM ACCOUNTS WHERE USERNAME = '" + userNameEntered + "'");
        if (res.next()) { // there is a result
            boolean b = res.getBoolean("EMPLOYEE");
            if (b == true) {
                employee = true;
            }
        }
        return employee;

    }

    public boolean CheckPrivilegesAccess(String userNameEntered) throws SQLException {
        boolean manageAccounts = false;
        ResultSet res = stmt.executeQuery("SELECT MANAGEACCOUNTS FROM ACCOUNTS WHERE USERNAME = '" + userNameEntered + "'");
        if (res.next()) { // there is a result
            boolean b = res.getBoolean("MANAGEACCOUNTS");
            if (b == true) {
                manageAccounts = true;
            }
        }
        return manageAccounts;

    }

    public static void GetImage(String key, JLabel lbl) {

        try {
            int keyInt = 0;
            if (key != null || key != "") {
                keyInt = Integer.parseInt(key);
            }
            ResultSet res = StockData.stmt.executeQuery("SELECT IMAGE FROM PRODUCTS WHERE PRODUCTID = " + keyInt);
            if (res.next()) { // there is a result
                Blob filenameBlob = res.getBlob("IMAGE");
                if (filenameBlob != null) {
                    byte[] content = filenameBlob.getBytes(1L, (int) filenameBlob.length());
                    ImageIcon icon = new ImageIcon(content);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newimg);
                    lbl.setIcon(icon);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void DeleteUser(String username) {
        try {
            String deleteSQL = "DELETE FROM ACCOUNTS WHERE USERNAME = '" + username + "'";
            System.out.println(deleteSQL);
            stmt.execute(deleteSQL);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


}
