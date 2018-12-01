import java.sql.*;
import java.io.*;
class JdbcDemo{
static final String DB_URL = "jdbc:mysql://localhost/test";
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		String sql;

		
		conn = DriverManager.getConnection(DB_URL,"root","");
		stmt = conn.createStatement();
		//ResultSet rs = stmt.executeQuery("Select *From Student");
		ResultSet rs = stmt.executeQuery("SELECT year( birthdate ) AS syear, sum( grade_point ) AS gp FROM `student`GROUP BY year( birthdate )");

		/*while(rs.next()){
		System.out.print(rs.getInt("reg_no")+"     ");
		System.out.print(rs.getString("name")+"     ");
		System.out.print(rs.getString("bloud_group")+"     ");
		System.out.print(rs.getString("birthdate")+"     ");
		System.out.println(rs.getString("grade_point")+"     ");
		}*/
		
		while(rs.next()){
		System.out.print(rs.getString("syear")+"    ");
		System.out.println(rs.getString("gp")+"    ");
		}
	}
}