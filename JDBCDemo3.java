import java.sql.*; 
public class JDBCDemo3 { 
    public static void main(String[] args) { 
	          Connection conn = null; 
        try { 
//Register jdbc driver 
Class.forName("com.mysql.jdbc.Driver"); 
//Establish connection 
           String dbURL = "jdbc:mysql://localhost:3306/test"; 
           String user = "root"; 
           String pass = ""; 
        conn = DriverManager.getConnection(dbURL, user, pass); 
        System.out.println("Connected."); 
// Create and execute an SQL statement  
           String SQL = "SELECT * from STUDENT";  
           Statement stmt = conn.createStatement();  
           ResultSet rs = stmt.executeQuery(SQL); 
// Create ResultSetMeta object 
ResultSetMetaData rsmd=rs.getMetaData();   
// ResultSetMetaData methods 
System.out.println("Total columns: 
"+rsmd.getColumnCount());   
System.out.println("Column Name of 1st column: 
"+rsmd.getColumnName(1));   
System.out.println("Column Type Name of 1st column: 
"+rsmd.getColumnTypeName(1));   
conn.close();   
        } catch (Exception e) { 
            e.printStackTrace(); 
}  
    } 
} 