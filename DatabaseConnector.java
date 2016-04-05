import java.sql.*;

/**
    Briley Marchetti
**/

public class DatabaseConnector{

    public static void connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e1){
            System.out.println("Connection error.");
            e1.printStackTrace();
        }
    }


    public static Connection ConnectionToMySql(){
        connection();
        String host = "jdbc:mysql://localhost:8889/order_processor"; //FOR MAC
        //String host = "jdbc:mysql://localhost/*Database_Name*"; //FOR WINDOWS PC
        String Username = "order_processor";
        String Password = "dev";

        try {
            Connection connect = DriverManager.getConnection(host, Username, Password);
            System.out.println("Connection Successful");
            return connect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void ShowTable(String id, String firstName, String lastName) throws SQLException
    {
        Connection conn = ConnectionToMySql();
        Statement stmt = conn.createStatement();    //creates a statement using a specific connection
        ResultSet rs = stmt.executeQuery("SELECT * from customer"); //returns a ResultSet based on the statement query
        while(rs.next()){
            String id = rs.getString("Customer_ID");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            System.out.println("Id: "+ id + ", First Name: " + firstName + ", Last Name: " + lastName);
        }
        conn.close();
    }

    public static void updateTable(){
        Connection connect = ConnectionToMySql();
        Statement
    }

    public static void main(String[] args) throws SQLException{
        ShowTable();
    }
}
