import java.sql.*;
import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class DatabaseConnector{

    private Connection connect;
    private Statement statement;

    public DatabaseConnector() throws SQLException{
        this.connect = ConnectionToMySql();
        this.statement = connect.createStatement();
    }

    public static void connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e1){
            System.out.println("Connection error.");
            e1.printStackTrace();
        }
    }

    //Connect to personal database
    public static Connection ConnectionToMySql(){
        connection();
        String host = "jdbc:mysql://localhost:8889/order_processor";
        String username = "order_processor";
        String password = "dev";

        try {
            Connection connect = DriverManager.getConnection(host, username, password);
            //System.out.println("Connection Successful");
            return connect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // INVENTORY ITEM INFORMATION -- Fill ArrayList and Update Items
    //Populates the itemList to store in memory
    public static ArrayList<InventoryItem> populateItemArrayList() throws SQLException{
        Connection connect = ConnectionToMySql();
        Statement stmt = connect.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from INVENTORY_ITEM"); //returns a ResultSet based on the statement query

        ArrayList<InventoryItem> itemList = new ArrayList<InventoryItem>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("Inventory_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            String itemName = rs.getString("ItemName"); //Same thing...different column
            int itemQuantity = rs.getInt("ItemQuantity");
            String productDescription = rs.getString("ProductDescription");
            Double unitCost = rs.getDouble("UnitCost");
            Double itemPrice = rs.getDouble("ItemPrice");

            InventoryItem i1 = new InventoryItem(id, itemName, itemQuantity, productDescription, unitCost, itemPrice);
            itemList.add(i1);
        }
        connect.close();
        System.out.println("Inventory Items added to arraylist.");
        return itemList;
    }

    //Updates inventoryItem in database...called from within Order and return
    public  void updateInventoryItem(int id, int quantity) throws SQLException{
        String updateStatement = "UPDATE INVENTORY_ITEM SET ITEMQUANTITY = " + quantity + " WHERE Inventory_ID = " + id +";";
        //System.out.println(updateStatement);
        statement.executeUpdate(updateStatement);
        connect.close();
    }


    // CUSTOMER INFORMATION -- Fill ArrayList from DB
    public static ArrayList<Customer> populateCustomerArrayList() throws SQLException{
        Connection connect = ConnectionToMySql();
        Statement stmt = connect.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from CUSTOMER"); //returns a ResultSet based on the statement query

        ArrayList<Customer> customerList = new ArrayList<Customer>();

        //Reads column by column extracting data
        while(rs.next()){
            int id = rs.getInt("CUSTOMER_ID"); //ResultSet gets the string from the 'Customer_ID' column from the table
            String firstName = rs.getString("FirstName"); //Same thing...different column
            String lastName = rs.getString("LastName");

            Customer c1 = new Customer(id, firstName, lastName);
            customerList.add(c1);
        }
        connect.close();
        //System.out.println("Customers added to arraylist.");
        return customerList;
    }

    // For testing purposes...
    // public static void main(String[] args) throws SQLException{
    // //    ShowTable();
    //     updateInventoryItem(2, 10995);
    // }
}
