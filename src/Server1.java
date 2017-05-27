import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Created on 2017.5.15
@author: leiyang
*/

public class Server1 {
	public static List<String> hashList1 = new ArrayList<String>();
	public static int sum1 = 0;
	public static int hashCount1=0;
	public static boolean doDedup(String mdHash)
	{
        try {
	        if (hashList1.contains(mdHash)){  
	            System.out.println("It has existed!");
	            sum1 = sum1 +1;
	        }else {
	        	hashList1.add(mdHash);
				System.out.println("not exist!!!");
				sum1 = sum1 +1;
			}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}
	
	public static void doPrint()
	{
    	System.out.println("In the node Server1:");
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + sum1 + " all hashes!!!");
    	File file1 = new File("C:\\Users\\nwpu-nana\\Desktop\\fileDedup\\hash1.txt");
    	WriteToTxt wtt1 = new WriteToTxt();
    	hashCount1 = wtt1.Write(hashList1,file1);
    	System.out.println("The ratio is " + (1-(double)hashCount1/sum1));
	}
}
