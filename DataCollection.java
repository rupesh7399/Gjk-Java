import java.sql.*;
import java.io.*;
class DataCollaction{
static final String DB_URL = "jdbc:mysql://localhost/test";
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		String sql;

		
		conn = DriverManager.getConnection(DB_URL,"root","");
		stmt = conn.prepareStatement();
		//ResultSet rs = stmt.executeQuery("Select *From Student");
		PrepardStatement rs = stmt.prepareStatement("SELECT year( birthdate ) AS syear, sum( grade_point ) AS gp FROM `student`GROUP BY year( birthdate )");
			PrepardStatement rt = stmt.prepareStatement("insert into datacollact(year,data)values(?,?)");
		
		/*while(rs.next()){
		System.out.print(rs.getInt("reg_no")+"     ");
		System.out.print(rs.getString("name")+"     ");
		System.out.print(rs.getString("bloud_group")+"     ");
		System.out.print(rs.getString("birthdate")+"     ");
		System.out.println(rs.getString("grade_point")+"     ");
		}*/
		ResultSet rt = stmt.executeQuery("insert into datacollect(year,data)values("''"+year",''"+data);
		while(rs.next()){
		stmp.setInt()
		
		rt.executeUpdate();
		}
	}
}