package javaHowToProgram;
import java.util.Set;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Arrays;
import java.util.Scanner;


public class SortingWithTreeSet {
	public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Enter a string");
	  String input= scanner.nextLine();
	  
	  String[] tokens = input.split(" ");
	  
	  SortedSet<String> tree = new TreeSet<>(Arrays.asList(tokens));
	  
	  // printing the tree
	  System.out.println("%n Printing elements of the tree:");
	     for(String value:tree) {
	         System.out.printf("%n%s",value);
	  }
	  }
		
	}


