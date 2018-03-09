package javaHowToProgram;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class CountingLetters {
   public static void main(String[] args) {
	   //create HashMap to store string keys and integer values
	   Map<Character,Integer> myMap=new HashMap<>();
	   
	   createMap(myMap); // create map based on user input
	   displayMap(myMap); //display map
   }
private static void createMap (Map<Character,Integer> map) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter a string:");
	String input=scanner.nextLine();
	
	//split the string into characters
	char[] tokens= input.toCharArray();
	
	for(char token:tokens) {
		if(map.containsKey(token)) {
			int count=map.get(token); // get current character
			map.put(token,count +1); // increment count
		}
		else
			map.put(token,1) ;// add new character with count of 1 to map
	}
	}
//display the map content
private static void displayMap(Map<Character,Integer> map) {
	 Set<Character> keys=map.keySet();
     
	 TreeSet<Character> sortedKeys= new TreeSet<>(keys);
	 System.out.printf("%n Map contains:%nkey\t\tvalue%n");
	 
	  for(Character key:sortedKeys)
		  System.out.printf("%-10s%10s%n",key,map.get(key)); 
}

}
