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
				bre = new BufferedReader(new FileReader(filee));//��ʱ��ȡ����bre���������ļ��Ļ�����
				while ((str = bre.readLine())!= null) // �ж����һ�в����ڣ�Ϊ�ս���ѭ��
				{
					count = count + 1;
					System.out.println(str);//ԭ���������������
				}
			}catch(Exception e){
				System.out.println(e);}
			bre.close();
		}
		System.out.println(count);
	}
	
	
	public static ArrayList<String> filelist = new ArrayList<String>();  

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
