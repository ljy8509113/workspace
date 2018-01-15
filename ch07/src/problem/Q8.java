package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Q8 {
	
	public static void main(String[] args) {
	
		String [] arrayStr = {"java", "c", "java", "cpp", "cpp", "cobol", "java"};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int index = 0;
		
		while(true) {
			int count = 0;
			String iStr = arrayStr[index];
			Set<String> keys = map.keySet();
			Iterator<String> iterator = keys.iterator();
			boolean isOverlap = false;
			
			while(iterator.hasNext()) {
				if(iStr.equals(iterator.next())) {
					isOverlap = true;
					break;
				}
			}
			
			if(!isOverlap)
			{
				for(int i=0; i<arrayStr.length; i++) {
					if(i != index && arrayStr[i].equals(iStr))
						count += 1;
				}
				map.put(iStr, count);
			}
			
			index++;
			if(index == arrayStr.length)
				break;
			
		}
		
		for(int i=0; i<arrayStr.length; i++) {
			if(i==0)
			{
				System.out.print("["+arrayStr[i]+", ");
			}else if(i==arrayStr.length-1) {
				System.out.print(arrayStr[i] + "]");
			}else {
				System.out.print(arrayStr[i]+", ");
			}
			
		}
		
		System.out.printf("\n%d distinct words detected\n{", map.keySet().size());
		Iterator<String> iterator = map.keySet().iterator();
		
		int count = 0;
		while(iterator.hasNext()) {
			System.out.printf("%s=%d%s", iterator.next(), map.get(iterator.next()), count == map.size()-1 ? "":", ");
		}
		System.out.print("}");
		
	}
}
