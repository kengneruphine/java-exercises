import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DuplicateWordRemoval {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a sentence");
        String sentence = input.nextLine();
        
        String [] tokens = sentence.split("\\s");
        System.out.printf("non duplicate words are: %s%n",
        		Arrays.stream(tokens)
        		.sorted(String.CASE_INSENSITIVE_ORDER)
        		.distinct()
        		.collect(Collectors.toList())
        		);
         		
	}

}
