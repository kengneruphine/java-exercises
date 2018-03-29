import java.util.Arrays;
import java.util.stream.IntStream;

public class MappingThenReducing {
	public static void main(String[] args)
	{
	int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
	// display original values
	System.out.print("Original values: ");
	IntStream.of(values)
	.forEach(value -> System.out.printf("%d ", value));
	System.out.println();
	
	// count, min, max, sum and average of the values
	System.out.printf("%nCount: %d%n", IntStream.of(values).count() );
	System.out.printf("Min: %d%n",
	IntStream.of(values).min().getAsInt() );
	
	System.out.printf("Max: %d%n",
	IntStream.of(values).max().getAsInt() );
	
	System.out.printf("Sum: %d%n", IntStream.of(values).sum() );
	System.out.printf("Average: %.2f%n",
	IntStream.of(values).average().getAsDouble() );
	// sum of values with reduce method
	System.out.printf("%nSum via reduce method: %d%n",
	IntStream.of(values)
	.reduce(0, (x, y) -> x + y) );
	// sum of squares of values with reduce method
	System.out.printf("Sum of squares via mapping and reducing: %d%n",
	IntStream.of(values)
	.map(value -> value * value ) // mapping and reducing an IntStream for parallelization
	.reduce(0,(x,y)-> x + y));
	
	}
}
