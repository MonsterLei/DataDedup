import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Created on 2017.5.15
@author: leiyang
*/

public class Server3 {
	public static List<String> hashList3 = new ArrayList<String>();
	public static int sum3 = 0;
	public static int hashCount3=0;
	public static boolean doDedup(String mdHash)
	{
        try {
	        if (hashList3.contains(mdHash)){  
	            System.out.println("It has existed!");
	            sum3 = sum3 +1;
	        }else {
	        	hashList3.add(mdHash);
				System.out.println("not exist!!!");
				sum3 = sum3 +1;
			}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}
	
	public static void doPrint()
	{
    	System.out.println("In the node Server3:");
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + sum3 + " all hashes!!!");
    	File file3 = new File("C:\\Users\\nwpu-nana\\Desktop\\fileDedup\\hash3.txt");
    	WriteToTxt wtt3 = new WriteToTxt();
    	hashCount3 = wtt3.Write(hashList3,file3);
    	System.out.println("The ratio is " + (1-(double)hashCount3/sum3));
	}
}
