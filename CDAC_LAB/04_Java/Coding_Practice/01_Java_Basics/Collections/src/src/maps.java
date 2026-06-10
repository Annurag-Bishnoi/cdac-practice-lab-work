package src;
import java.util.*;
import java.util.Map.Entry;
public class maps {

	public static void main(String[] args) {
//		******************************* Map *********************************
//		Map <Integer,String> map=new HashMap<>();
//		
//		map.put(1, "anura");
//		map.put(2, "anurag");
//		map.put(4, "anura");
//		map.put(3, "bishnoi");
//		map.get(1);
//		map.put(7, "jai");
//		map.put(null, "ram");
//		map.put(5, null);
//		map.put(6, null);
//		System.out.println(map.get(2));
//		for(Entry<Integer,String> entry:map.entrySet()) {
//			System.out.println(entry.getValue()+"=> "+entry.getKey());
//		}
		
//		********************************* HashMap *******************************************
//HashMap <Integer,String> map=new HashMap<>();
//		
//		map.put(17, "anura");
//		map.put(18, "anurag");
//		map.put(4, "anura");
//		map.put(13, "bishnoi");
//		map.get(19);
//		map.put(17, "jai");
//		map.put(null, "ram");
//		map.put(15, null);
//		map.put(20, null);
//		System.out.println(map.get(2));
//		for(Entry<Integer,String> entry:map.entrySet()) {
//			System.out.println(entry.getValue()+"=> "+entry.getKey());
//		}
	
		
//		********************************* Linked HashMap *******************************************
//LinkedHashMap <Integer,String> map=new LinkedHashMap<>();
//		
//		map.put(17, "anura");
//		map.put(18, "anurag");
//		map.put(4, "anura");
//		map.put(13, "bishnoi");
//		
//		map.put(17, "jai");
//		map.put(null, "ram");
//		map.put(15, null);
//		map.put(20, null);
//		System.out.println(map.get(4));
//		for(Entry<Integer,String> entry:map.entrySet()) {
//			System.out.println(entry.getValue()+"=> "+entry.getKey());
//		}
		
		
		
//		********************************* TreeMap *******************************************
//		TreeMap <Integer,String> map=new TreeMap<>();
//		
//		map.put(17, "anura");
//		map.put(18, "anurag");
//		map.put(4, "anura");
//		map.put(13, "bishnoi");
//		
//		map.put(17, "jai");
//		map.put(null, "ram");
//		map.put(15, null);
//		map.put(20, null);
//		System.out.println(map.get(4));
//		for(Entry<Integer,String> entry:map.entrySet()) {
//			System.out.println(entry.getValue()+"=> "+entry.getKey());
//		}

//		********************************* HashTable *******************************************
		Hashtable <Integer,String> map=new Hashtable<>();
		
		map.put(17, "anura");
		map.put(18, "anurag");
		map.put(4, "anura");
		map.put(13, "bishnoi");
		
		map.put(17, "jai");
//		map.put(null, "ram");
//		map.put(15, null);
//		map.put(20, null);
		System.out.println(map.get(4));
		for(Entry<Integer,String> entry:map.entrySet()) {
			System.out.println(entry.getValue()+"=> "+entry.getKey());
		}
		
		System.out.println("_______________________");
		for(Map.Entry<Integer,String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"=> "+entry.getValue());
		}
		
	}
}
