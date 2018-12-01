import java.sql.*; 
public class JDBCDemo2 { 
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
// Create Database Meta Data 
DatabaseMetaData dbmd=conn.getMetaData();  
System.out.println("Driver Name: "+dbmd.getDriverName());   
System.out.println("Driver Version:"+dbmd.getDriverVersion());   
System.out.println("UserName: "+ dbmd.getUserName());   
     System.out.println("Database Product Name:"+dbmd.getDatabaseProductName());   
System.out.println("Database Product Version:"+dbmd.getDatabaseProductVersion());   
conn.close();   
     } catch (Exception e) { 
         e.printStackTrace(); 
}  
   } 
} 