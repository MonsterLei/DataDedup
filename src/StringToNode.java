import java.math.BigInteger;

/*
Created on 2017.5.15
@author: leiyang
*/

public class StringToNode {

	public static final int NODESNUM = 3;
	public static int getStringToNode(String hash)
	{
		BigInteger hashValue = BigInteger.valueOf(0);
		BigInteger factor = BigInteger.valueOf(16);
		char[] stringArr = hash.toCharArray();
        for (int i=0; i < stringArr.length; i++) {
        	char aa = stringArr[i];
        	int num = 0;
        	if(aa<'0'||aa>'9')
        	{
        		num = aa-'a'+10;
        	}
        	else
        	{
        		num = aa-'0';
        	}
        	BigInteger bigNum = BigInteger.valueOf(num);
        	//System.out.println(aa);
        	hashValue = hashValue.multiply(factor);
        	hashValue = hashValue.add(bigNum);
            //System.out.println(hashValue);
        }
		int node = hashValue.mod(BigInteger.valueOf(NODESNUM)).intValue();
		return node;		
	}
}
