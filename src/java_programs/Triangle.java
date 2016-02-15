package java_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Question: https://leetcode.com/problems/triangle/
 */
public class Triangle {
	
	
	public int minimumTotal(List<List<Integer>> triangle){
		if(triangle == null || triangle.size() == 0){
			return -1;
		}
		ArrayList<Integer> minPath = null;
		
		//In the last level, the distance will be same as the elements
		minPath = (ArrayList<Integer>) triangle.get(triangle.size()-1);
		
		//Start from last but one row and bubble up
		for(int i=triangle.size()-2; i >=0; i--){
			List<Integer> currentLevel = triangle.get(i);
			for(int j=0; j<currentLevel.size(); j++){
				int value = currentLevel.get(j)+getMinChild(minPath, j);
				minPath.remove(j);
				minPath.add(j, value);
			}
		}
		return minPath.get(0);
	}
	
	private Integer getMinChild(List<Integer> list, int location){
		if(list.get(location).compareTo(list.get(location+1)) == 1){
			return list.get(location+1);
		}else{
			return list.get(location);
		}
	}
	
	
	public static void main(String[] args){
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		Integer[] raw1Data = {new Integer(2)};
		Integer[] raw2Data = {new Integer(3), new Integer(4)};
		Integer[] raw3Data = {new Integer(6), new Integer(5), new Integer(7)};
		Integer[] raw4Data = {new Integer(4), new Integer(1), new Integer(8), new Integer(3)};
		data.add(new ArrayList<Integer>(Arrays.asList(raw1Data)));
		data.add(new ArrayList<Integer>(Arrays.asList(raw2Data)));
		data.add(new ArrayList<Integer>(Arrays.asList(raw3Data)));
		data.add(new ArrayList<Integer>(Arrays.asList(raw4Data)));
		
		Triangle triangle = new Triangle();
		System.out.println(triangle.minimumTotal(null));
		System.out.println(triangle.minimumTotal(data));
	}
}
