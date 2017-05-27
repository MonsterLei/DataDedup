import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Created on 2017.5.15
@author: leiyang
*/
public class FeatureChoose {

	public static String obtainFeature(List<String> alist){
		List<String> sortList = alist;
		System.out.println("max: " + Collections.max(sortList));
		System.out.println("min: " + Collections.min(sortList));
		return Collections.min(sortList);

	}
}
