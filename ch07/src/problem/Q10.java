package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q10<K, V1, V2> {
//	class MyData<K, V1, V2>{
//		
//	}
	
	Set<K> keys = new HashSet<K>();
	HashMap<K, V1> values1 = new HashMap<K, V1>();
	HashMap<K, V2> values2 = new HashMap<K, V2>();
	
	public void put(K key, V1 value1, V2 value2) {
		keys.add(key);
		values1.put(key, value1);
		values2.put(key, value2);
	}
	
	public V1 getPhoneNumber(K key) {
		return values1.get(key);
	}
	
	public V2 getCompany(K key) {
		return values2.get(key);
	}
	
	public Set<K> getKeys(){
		return keys;
	}
	
	public static void main(String[] args) {
//		MyData<String, String, String> data = new MyData();
		Q10<String, String, String> p = new Q10();
		p.put("김미현", "010-1234-1234", "KT");
	}
}
