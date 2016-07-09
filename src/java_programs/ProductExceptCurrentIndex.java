package java_programs;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
 */

/*
 * Will have two place holders that will have the products of numbers
 * on left and right side of the location. 
 * 
 * These place holders from right and left are multiplied together
 * to get the result.
 * 
 * To make this happen in single pass and without
 * extra space, we need to have two pointers.
 */
public class ProductExceptCurrentIndex {
	public int[] getSumArray(int[] array){
		if(array == null)
			return null;
		int result[] = new int[array.length];
		for(int i=0; i<result.length; i++){
			result[i] = 1;
		}
		int leftProduct = 1;
		int rightProduct = 1;
		for(int i=0, j=array.length-1; i < array.length-1; i++, j--){
			leftProduct *= array[i];
			rightProduct *= array[j];
			result[i+1] *= leftProduct;
			result[j-1] *= rightProduct;
		}
		return result;
	}
	
	public static void main(String[] args){
		int array[] = {1,2,3,4,5,6};
		ProductExceptCurrentIndex currentIndex = new ProductExceptCurrentIndex();
		array = currentIndex.getSumArray(array);
		MyUtils.printArray(array);
	}
}
