package java_programs;

public class OddOccurrence {

	public OddOccurrence(){
	}

	/*
	 * Returns the number which occurs odd number of times in the array.
	 * Returns null if there is no such number.
	 */
	public Integer singleNumber(int[] array){

		/*
		 * if the length of the array is even, there is no odd occurrence.
		 */
		if(array == null || array.length%2 == 0){
			return null;
		}

		int result = 0;

		for(int i=0; i<array.length; i++){
			result ^= array[i];
		}

		return result;
	}
	
	/*
	 * Returns those two numbers that occur odd number of times
	 * in an array. Else returns null
	 */
	public int[] twoNumbers(int[] array){
		
		/*
		 * If the array length is odd, it doesn't have two numbers that
		 * occurs odd number of times.
		 */
		if(array == null || array.length%2 == 1){
			return null;
		}
		
		int flag = 0;
		
		for(int i=0; i<array.length; i++){
			flag ^= array[i];
		}
		
		/*
		 * All entries occur even number of times if flag is 0 
		 */
		if(flag == 0){
			return null;
		}
		
		// The least significant 1 in the binary flag.
		int lsb = flag&(~(flag-1));
		int[] result = {0, 0};
		
		for(int i=0; i<array.length; i++){
			if((array[i]&lsb) == 0 ){
				result[0] ^= array[i];
			}else{
				result[1] ^= array[i];
			}
		}
		
		return result;
	}
	
	

	public static void main(String[] args){
		OddOccurrence oddOcc = new OddOccurrence();

		int[] array1 = {1, 1, 2, 2, 3, 3, 4};
		int[] array2 = null;
		int[] array3 = {1, 1, 2, 2, 3, 3, 4, 4};

		System.out.println(oddOcc.singleNumber(array1));
		System.out.println(oddOcc.singleNumber(array2));
		System.out.println(oddOcc.singleNumber(array3));
		System.out.println("");
		
		int[] array4 = {1, 1, 2, 2, 3, 3, 4, 5};
		int[] array5 = null;
		int[] array6 = {1, 1, 2, 2, 3, 3, 4, 4, 5};
		
		MyUtils.printArray(oddOcc.twoNumbers(array3));
		MyUtils.printArray(oddOcc.twoNumbers(array4));
		MyUtils.printArray(oddOcc.twoNumbers(array5));
		MyUtils.printArray(oddOcc.twoNumbers(array6));
	}

}
