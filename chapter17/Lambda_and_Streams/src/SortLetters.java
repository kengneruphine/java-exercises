import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortLetters {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		List<Character> list1= new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		
		for(int i=0; i< 30;i++) {
			list1.add((char)(random.nextInt(26)+ 'a'));
		}
	
		for(char letter:list1) {
			System.out.println(letter);
		}
		
		System.out.printf("letters in ascending order as: %s%n",
        		list1.stream()
        		.sorted()
        		.collect(Collectors.toList())
        		);
		
		System.out.printf("letters in ascending order and duplicate remove as: %s%n",
        		list1.stream()
        		.sorted()
        		.distinct()
        		.collect(Collectors.toList())
        		);
		
        	list2=list1.stream()
        		.sorted()
        		.collect(Collectors.toList());
        	
     Collections.sort(list2,Collections.reverseOrder());
     System.out.printf("Letters in descending order: %s%n", list2);
        		   
		
	}
}