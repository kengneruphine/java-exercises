package javaHowToProgram;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

public class CopyingLinkedList {
     public static void main(String[] args) {
    	 String[] character = {"s","p","f","z","o","c","j","i","e","n"};
    	 
    	 List<String> list1= new LinkedList<>(Arrays.asList(character));
    	 
    	 Collections.reverse(list1); 
    	 //create the other array and specify the number of elements
    	 String[] character2 = new String[10];
    	 
    	 List<String> list2 = new LinkedList<>(Arrays.asList(character2));
    	 Collections.copy(list2, list1);
    	 
    	 for(String c:list2) {
    		 System.out.printf("%s%n",c);
    	 }
     }
}
