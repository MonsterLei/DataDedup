package maybeuse;
import java.io.File;


public class HashCal {

	public static void main(String[] args) {
		String filePath1 = "C:\\Users\\nwpu-nana\\Desktop\\DataDedup\\ex0209.html";
		String filePath2 = "C:\\Users\\nwpu-nana\\Desktop\\ex0209.html";
        File file1 = new File(filePath1);  
        File file2 = new File(filePath2);  
        if (file1.hashCode() == file2.hashCode()){  
            System.out.println("The same file!");   
        }else {
			System.out.println("not same!!!");
		}
	}

}
