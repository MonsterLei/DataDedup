import java.util.BitSet;
/*
Created on 2017.5.15
@author: leiyang
*/
public class BloomFilter {  
  
    private static final int DEFAULT_SIZE = 1000000000;//��¡�������ı��س���  
    private static final int[] seeds = {3,5,7, 11, 13, 31, 37, 61};//����Ҫѡȡ�������ܺܺõĽ��ʹ�����  
    private static BitSet bits = new BitSet(DEFAULT_SIZE);  
    private static SimpleHash[] func = new SimpleHash[seeds.length];  
  
    public static void addValue(String value)  
    {  
        for(SimpleHash f : func)//���ַ���value��ϣΪ8������������Ȼ������Щ������bit�ϱ�Ϊ1  
            bits.set(f.hash(value),true);  
    }  
     
    static {
    	for (int i = 0; i < seeds.length; i++){
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }
    public static void add(String avalue)  
    {
        if(avalue != null) addValue(avalue);  
    }  
      
    public static boolean contains(String value)  
    { 
        if(value == null) return false;  
        boolean ret = true;  
    	for (int i = 0; i < seeds.length; i++){
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
        for(SimpleHash f : func)//������ʵû��Ҫȫ�����ֻ꣬Ҫһ��ret==false��ô�Ͳ���������ַ���  
            ret = ret&&bits.get(f.hash(value));  
        return ret;  
    }  
}

class SimpleHash {
  
    public int cap;  
    private int seed;  
  
    public SimpleHash(int cap, int seed) {  
        this.cap = cap;  
        this.seed = seed;  
    }  

    public int hash(String value) {//�ַ�����ϣ��ѡȡ�õĹ�ϣ��������Ҫ  
        int result = 0;  
        int len = value.length();  
        for (int i = 0; i < len; i++) {  
            result = seed * result + value.charAt(i);  
        }  
        return (cap - 1) & result;  
    }  
}  