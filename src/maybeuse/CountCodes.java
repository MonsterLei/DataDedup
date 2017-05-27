package maybeuse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CountCodes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    String filePath = "D:\\TT\\extra";
	    getFiles(filePath);
	    String str = new String();
	    int count = 0;
		for(String filee: filelist)
		{
			BufferedReader bre = null;
			try 
			{
				System.out.println(filee);
				bre = new BufferedReader(new FileReader(filee));//此时获取到的bre就是整个文件的缓存流
				while ((str = bre.readLine())!= null) // 判断最后一行不存在，为空结束循环
				{
					count = count + 1;
					System.out.println(str);//原样输出读到的内容
				}
			}catch(Exception e){
				System.out.println(e);}
			bre.close();
		}
		System.out.println(count);
	}
	
	
	public static ArrayList<String> filelist = new ArrayList<String>();  

 /*
  * 通过递归得到某一路径下所有的目录及其文件
  */
	public static void getFiles(String filePath){
		File root = new File(filePath);
		File[] files = root.listFiles();
		for(File file:files)
		{     
			if(file.isDirectory())
			{
				getFiles(file.getAbsolutePath());
				//System.out.println("目录"+filePath+"下的子目录或文件有"+file.getAbsolutePath());
			}
			else
			{
				filelist.add(file.getAbsolutePath());
				//System.out.println("显示"+filePath+"下的子目录或文件有"+file.getAbsolutePath());
			}     
		}
	}
}
