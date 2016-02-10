package java_programs;

public class MyUtils {
	public static void printArray(int[] array){
		if(array == null)
			System.out.println("null");
		else
		{
			for(int i=0; i<array.length; i++)
				System.out.print(array[i]+", ");
			System.out.println("");
		}
	}
}
