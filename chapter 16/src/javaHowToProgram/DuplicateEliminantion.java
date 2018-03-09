package javaHowToProgram;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.LinkedList;


public class DuplicateEliminantion {

	public static void main(String[] args)
	{
		String[] names = {"kengne","nkep","verdia","angeh","sandra","grace","nkep",
				"verdia","sandra"};
		//convert the array into list
      List<String> list1 = Arrays.asList(names);
      System.out.println("printing list with duplicates");
      
      for(String s:list1) {
    	  System.out.printf("%s%n",s);
      }
      
      // using a hashset to remove duplicate
      Set<String> set = new HashSet<>(list1);
      System.out.println("%n Without duplicates");
      
      for(String s:set) {
    	 System.out.printf("%s%n",s);
      }
      //create a list and sort it to perform a search action
     List<String> list2=new LinkedList<>(set);
     Collections.sort(list2);
     
     //search for a name
    printSearchName(list2,"grace");
	}
     
    private static void printSearchName(List<String>list1, String key) {
     
    	 int result=0;
    	 System.out.printf("%nSearching for:%s%n",key);
    	 result=Collections.binarySearch(list1,key);
    	 
    	 if (result>=0)
    		 System.out.printf("Found index at %d%n",result);
    	 else
    		 System.out.printf("Not found (%d)%n",result);
     }
     
	

}


