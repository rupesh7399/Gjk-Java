import java.sql.*;
import java.io.*;
import java.util.*;
class DataInsert{
	public static void main(String args[]) throws Exception
	{
		FileReader fr = new FileReader("data.txt");
		BufferedReader br= new BufferedReader(fr);
		ArrayList<Integer> year=new ArrayList<Integer>();
		ArrayList<Integer> value=new ArrayList<Integer>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		Statement st1= conn.createStatement();
		st1.executeUpdate("delete from datacollact;");
		PreparedStatement st2=conn.prepareStatement("INSERT INTO `test`.`datacollact` (`year` ,`data`) values(?,?);");  
		int records=0;
		String str,val[];
		while((str=br.readLine())!=null)
		{
			val=str.split(",");
			year.add(Integer.parseInt(val[0]));
			value.add(Integer.parseInt(val[1]));
		}
		for(int i=0;i<year.size();i++)
		{
			if(value.get(i)==0)
			{
				st2.setInt(1,year.get(i));
				st2.setInt(2,Collections.max(value));
			}
			else
			{
				st2.setInt(1,year.get(i));
				st2.setInt(2,value.get(i));
			}
			records=records+st2.executeUpdate();
		}
		
		System.out.println(records +" inserted.");
	}
}