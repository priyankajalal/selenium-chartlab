package myhelp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "8000 B";
		
		System.out.println(s1.replace( " B",""));
		
		
		String s2 = s1.substring(0, s1.length()-2);
		System.out.println(s2);
		Float.parseFloat(s2);
		
		
      String s = "123";
      Integer a = Integer.parseInt(s);
      System.out.println(a);
      ListTest();
      
      
      
      
	}
	
	static  void ListTest()
	{
		List<Integer> l1 = new ArrayList<>();
	      l1.add(191);
	      l1.add(12);
	      l1.add(34);
	      Collections.sort(l1);
	      System.out.println(l1.get(l1.size()-1));
	      
	      double d1 = 123.0*(1-0.50);
	}

}
