import java.io.File;
import java.util.ArrayList;


/*
Created on 2017.5.15
@author: leiyang
*/

public class FileTraverse{
	public static ArrayList<String> filelist = new ArrayList<String>();
	public FileTraverse(){    
    String filePath = "D:\\TTT";
    getFiles(filePath);
	for(String filee: filelist)
	{
		System.out.println(filee);
	}
    } 
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