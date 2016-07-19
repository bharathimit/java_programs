package java_programs;

public class ReverseIntegerAlone {
	public String reverseIntegers(String input){
		if(input == null)
			return null;
		StringBuilder sb = new StringBuilder(input);
		int firstPointer = -1;
		int lastPointer = sb.length();
		char firstChar = Character.MIN_VALUE, lastChar = Character.MIN_VALUE;
		
		while(firstPointer <= lastPointer){
			if(!(firstChar - '0' >= 0 && firstChar - '0' <= 9)){
				firstChar = sb.charAt(++firstPointer);
			}else if(!(lastChar - '0' >= 0 && lastChar - '0' <= 9)){
				lastChar = sb.charAt(--lastPointer);
			}else{
				sb.setCharAt(firstPointer, lastChar);
				sb.setCharAt(lastPointer, firstChar);
				firstChar = sb.charAt(++firstPointer);
				lastChar = sb.charAt(--lastPointer);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String input = "12asdf4af5d67a";
		ReverseIntegerAlone reverse =  new ReverseIntegerAlone();
		System.out.println(reverse.reverseIntegers(input));
	}
}
