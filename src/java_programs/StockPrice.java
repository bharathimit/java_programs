package java_programs;

import java.util.Stack;

public class StockPrice {
	public int[] getContinousLessPrice(int[] stockPrice){
		if(stockPrice == null)
			return null;
		int[] lessPriceDays = new int[stockPrice.length];
		Stack<Stock> maxPrices = new Stack<Stock>();
		for(int i=0; i<stockPrice.length; i++){
			while(!maxPrices.isEmpty()){
				if(maxPrices.peek().price > stockPrice[i]){
					lessPriceDays[i] = i-maxPrices.peek().postion;
					maxPrices.push(new Stock(i, stockPrice[i]));
					break;
				}else{
					maxPrices.pop();
				}
				
			}
			if(maxPrices.isEmpty()){
				lessPriceDays[i] = i+1;
				maxPrices.push(new Stock(i, stockPrice[i]));
			}
		}
		
		return lessPriceDays;
	}
	
	public static void main(String[] args){
		int[] priceArray = {5, 10, 6, 7, 8, 15};
		StockPrice stockPrice = new StockPrice();
		int[] result = stockPrice.getContinousLessPrice(priceArray);
		MyUtils.printArray(result);
	}
}

class Stock{
	int postion;
	int price;
	public Stock(int postion, int price){
		this.postion = postion;
		this.price = price;
	}
}
