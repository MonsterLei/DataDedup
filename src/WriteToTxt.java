import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

/*
Created on 2017.5.15
@author: leiyang
*/

public class WriteToTxt {
	public int Write(List<String> list,File afile)
	{
		int hashCount = 0;
		File file = afile;
		FileWriter fw = null;
        BufferedWriter bw = null;
        Iterator<String> iter = list.iterator();
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            while(iter.hasNext()) {
                bw.write(iter.next());
                bw.newLine();
                hashCount = hashCount +1;
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	System.out.println("-----------**-----------");
            	System.out.println("There are " + hashCount + " different hashes!!!");
            	System.out.println("-----------**-----------");
                bw.close();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashCount;
		
	}

}