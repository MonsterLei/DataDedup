import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


/*
Created on 2017.5.15
@author: leiyang
*/
//采用普通列表索引的方式进行集中式的客户端节点重删
public class ClientCentralized {
    public static int hashCount = 0;

	public static void main(String[] args) throws Exception {
	    new FileTraverse();//初始化遍历的文件夹，存入列表
	    
	    List<String> hashList = new ArrayList<String>();
	    byte[] buffer = new byte[40000];
	    int sum = 0;
	    
    	List<String> chunkList = new ArrayList<String>();
	    
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
		            System.out.println(index+":"+mdHash);
			        if (hashList.contains(mdHash)){  
			            System.out.println("It has existed!");
			            sum = sum +1;
			            ff = new File(file+index);
			            ff.delete();
			        }else {
			        	hashList.add(mdHash);
			        	
			        	chunkList.add(mdHash);
						System.out.println("not exist!!!");
						sum = sum +1;
			            ff = new File(file+index);
			            ff.delete();
					}
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		        index++;
		    }
		    
		    if(!chunkList.isEmpty())
		    	System.out.println(FeatureChoose.obtainFeature(chunkList));
		    	chunkList.clear();
		    in.close();
		    out.close();
	    }
	    
//	    for(String hash:hashList)
//	    {
//	    	System.out.println(hash);
//	    }
	    
    	System.out.println("-----------**-----------");
    	System.out.println("There are " + sum + " all hashes!!!");
    	System.out.println("-----------**-----------");
    	File file1 = new File("C:\\Users\\nwpu-nana\\Desktop\\fileDedup\\hash.txt");
    	WriteToTxt wttClient = new WriteToTxt();
    	hashCount = wttClient.Write(hashList,file1);
	    System.out.println("The ratio is " + (1-(double)hashCount/sum));
	   
	    System.out.println("Done!");
	    long endTime = System.currentTimeMillis();
	    System.out.println("ClientCentralized程序运行时间："+(endTime-startTime)+"ms");
	}
	
	
}
