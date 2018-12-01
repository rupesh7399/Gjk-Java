import java.io.*;
import java.util.ArrayList;

public class FreqItem{
	public static ArrayList<String>item = new ArrayList<String>();
	public static ArrayList<String>freqitem = new ArrayList<String>();
	public static ArrayList<Integer>support = new ArrayList<Integer>();
		public static void main(String args[] )throws Exception{
			String line,data[];
			int idx,minsup=3;
			FileReader in = new FileReader("data2.txt");
			BufferedReader br = new BufferedReader(in);
			while((line = br.readLine())!=null)
			{
				data=line.split(",");
				for(int i=0;i<data.length;i++)
				{
					
					idx=item.indexOf(data[i]);
					if(idx>=0)
					{
						
						support.set(idx,support.get(idx)+1);
					}
					else
					{
						item.add(data[i]);
						support.add(1);
						
					}
				}
				
				
			}
			
			for(int i=0;i<item.size();i++)
			{
				System.out.println(item.get(i)+"==="+support.get(i));
				if(support.get(i)>=minsup)
				{
					freqitem.add(item.get(i));
				}
			}
			System.out.println("Frequent Item");
			for(int i=0;i<freqitem.size();i++)
			{
				System.out.println(freqitem.get(i));
			}
				in.close();
		}
		
}
