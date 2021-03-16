package net.gf.bjss.utils;

public class PriceHelper {
	public static String getPrintFormat(float price) {
		if (price < 1.0f){
			return price*100 + "p";
		} else {
			return "£" + price;
		}
	}
	
	public static float roundToDecimalPlaces(float value, int decimalPlaces) {
	      double shift = Math.pow(10,decimalPlaces);
	      return (float) ((float)Math.round(value*shift)/shift);
	}
}
