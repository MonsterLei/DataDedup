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
  * ͨ���ݹ�õ�ĳһ·�������е�Ŀ¼�����ļ�
  */
	public static void getFiles(String filePath){
		File root = new File(filePath);
		File[] files = root.listFiles();
		for(File file:files)
		{     
			if(file.isDirectory())
			{
				getFiles(file.getAbsolutePath());
				//System.out.println("Ŀ¼"+filePath+"�µ���Ŀ¼���ļ���"+file.getAbsolutePath());
			}
			else
			{
				filelist.add(file.getAbsolutePath());
				//System.out.println("��ʾ"+filePath+"�µ���Ŀ¼���ļ���"+file.getAbsolutePath());
			}     
		}
		
	}

}