import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.PrintStream;

/*
Created on 2017.5.15
@author: leiyang
*/
public class ChunkThird {

	public static void main(String[] args) throws Exception {
	    FileTraverse ft = new FileTraverse();

	    byte[] buffer = new byte[4000];
	    int[] sum = new int[31];
	    int all =0;
	    long startTime = System.currentTimeMillis();//获取当前时间
	    for(String file: FileTraverse.filelist)
	    {
		    FileInputStream in = new FileInputStream(file);
		    FileOutputStream out = null;        
		    int len = 0;
		    int index = 0;	 
		    File ff;

		    while( (len = in.read(buffer)) != -1){
		        out = new FileOutputStream(file + index);
		        out.write(buffer, 0, len);
		        out.close();
		        try {
		        	String mdHash = MD5.getMD5Checksum(file+index);
		        	int node = StringToNode.getStringToNode(mdHash)+1;
		            System.out.println(index+":"+mdHash+" belongs to node "+ node);
		            switch (node){
	            		case 1:
	            			Server1.doDedup(mdHash);
	            			ff = new File(file+index);
	            			ff.delete();
	            			break;
	            		case 2:
	            			Server2.doDedup(mdHash);
	            			ff = new File(file+index);
	            			ff.delete();
	            			break;
	            		case 3:
	            			Server3.doDedup(mdHash);
	            			ff = new File(file+index);
	            			ff.delete();
	            			break;
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }	        
		        index++;
		    }
		    in.close();
		    out.close();
	    }
//	    for(int element:sum){
//	    	System.out.print(element+" ");
//	    }
	    all = Server1.sum1+Server2.sum2+Server3.sum3;
	    Server1.doPrint();
	    Server2.doPrint();
	    Server3.doPrint();
	   	System.out.println("In all the Servers:");
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + all + " all hashes!!!");
    	try {
    		FileOutputStream fos = new FileOutputStream("C:\\Users\\nwpu-nana\\Desktop\\System_out.txt"); 
    	    PrintStream ps = new PrintStream(fos); 
    	    System.setOut(ps); 
    	    }
    	catch (FileNotFoundException e) { 
    	    e.printStackTrace(); 
    	    } 
    	
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + all + " all hashes!!!");
    	long endTime = System.currentTimeMillis();
	    System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	    System.out.println("Done!");
	}
}
