import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Created on 2017.5.15
@author: leiyang
*/

public class Server2 {
	public static List<String> hashList2 = new ArrayList<String>();
	public static int sum2 = 0;
	public static int hashCount2=0;
	public static boolean doDedup(String mdHash)
	{
        try {
	        if (hashList2.contains(mdHash)){  
	            System.out.println("It has existed!");
	            sum2 = sum2 +1;
	        }else {
	        	hashList2.add(mdHash);
				System.out.println("not exist!!!");
				sum2 = sum2 +1;
			}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}
	
	public static void doPrint()
	{
    	System.out.println("In the node Server2:");
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + sum2 + " all hashes!!!");
    	File file2 = new File("C:\\Users\\nwpu-nana\\Desktop\\fileDedup\\hash2.txt");
    	WriteToTxt wtt2 = new WriteToTxt();
    	hashCount2 = wtt2.Write(hashList2,file2);
    	System.out.println("The ratio is " + (1-(double)hashCount2/sum2));
	}
}
