import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;

/*
Created on 2017.5.15
@author: leiyang
*/
//采用了布隆过滤器进行客户端重删
public class Client {

	public static void main(String[] args) throws Exception {
	    FileTraverse ft = new FileTraverse();
	    byte[] buffer = new byte[4000];
	    int sum = 0;
	    int existAll = 0;
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
		            System.out.println("hahah"+index+":"+mdHash+" belongs to node "+ node);
		    	    if (BloomFilter.contains(mdHash)){
		    	        System.out.println("It has existed!");
		    	        sum = sum +1;
		    	    }else {
		    	    	BloomFilter.add(mdHash);
		    			System.out.println("not exist!!!");
		    			sum = sum +1;
		    	        existAll = existAll+1;
		    	    }
		            }
		            catch (Exception e) {
		                e.printStackTrace();
		            } 
		        ff = new File(file+index);
    			ff.delete();
		        index++;
		    }
		    in.close();
		    out.close();
	    }
	    
	   	System.out.println("In the Client:");
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + sum + " all hashes!!!");
    	System.out.println("-----------**-----------");
    	System.out.println("There have existed " + existAll + " different hashes!!!");
    	System.out.println("The ratio is " + (1-(double)existAll/sum));
	    System.out.println("Done!");
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("Client程序运行时间："+(endTime-startTime)+"ms");
	}
}
