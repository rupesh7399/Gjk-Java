import java.io.*;
import java.util.ArrayList;

public class FreqItem2{

	public static ArrayList<String>item = new ArrayList<String>();
	public static ArrayList<String>freqitem = new ArrayList<String>();
	public static ArrayList<Integer>support = new ArrayList<Integer>();
	
		public static void main(String args[]) throws Exception{
			String line,data[];
			int idx,mus=3,cnt;
			
			item.add("I1,I2,I3"); support.add(0);
			item.add("I1,I2,I5"); support.add(0);
			item.add("I1,I3,I5"); support.add(0);
			item.add("I1,I3,I7"); support.add(0);
			
			FileReader in = new FileReader("data2.txt");
			BufferedReader br = new BufferedReader(in);
			
				while((line = br.readLine())!=null)
				{
					line = ","+line+",";
					for(int k=0;k<item.size();k++)
					{	
						data = item.get(k).split(",");
						cnt=0;
							
						for(int i=0;i<data.length;i++){	
							idx = line.indexOf(data[i]);
							if(idx>=0)
							{
								cnt++;
							}
						}
						if(cnt==3){
							support.set(k,support.get(k)+1);
						}
					}	
				}
				
				for(int i=0;i<item.size();i++){
					System.out.println(item.get(i)+"=="+support.get(i));
					if(support.get(i)>=mus)
					{
						freqitem.add(item.get(i));
					}
					
				}
				
				System.out.println("Frequent Items");
				for(int i=0;i<freqitem.size();i++)
				{
					System.out.println(freqitem.get(i));
				}
				
			in.close();
			
		}
}