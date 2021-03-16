package net.gf.bjss.purchase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import net.gf.bjss.good.Item;
import net.gf.bjss.offrules.DiscountService;
import net.gf.bjss.utils.PriceHelper;

public class Basket {
	private final List<Item> purchasedItems;
	
	public Basket(){
		this.purchasedItems = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.purchasedItems.add(item);
	}
	
	public void removeItem(int index) {
		if (index < purchasedItems.size() -1)
			purchasedItems.remove(index);
	}
	
	public List<Item> getPurchaseItems() {
		return this.purchasedItems;
	}
	
	private float getSubtotal(List<PrintStream> out){
		float sum = 0;
		for (Item item : purchasedItems){
			sum += item.getPrice();
			
			if(out != null)
				for(PrintStream ps : out)
					ps.println(item.getItemName() + ":\t\t" + PriceHelper.getPrintFormat(item.getPrice()));
		}
		
		sum = PriceHelper.roundToDecimalPlaces(sum, 2);
		
		if(out != null)
			for(PrintStream ps : out)
				ps.println("Subtotal:\t" + PriceHelper.getPrintFormat(sum));
			
		return sum;
	}
	
	public float calculateTotalPrice(DiscountService discountService, List<PrintStream> out){
		final float subTotal = getSubtotal(out);
		
		final float discount = discountService.calculateDiscount(this, out);
		
		if(discount == 0.0)
			for(PrintStream ps : out)
				ps.println("(No offers available)");
		
		float ret = subTotal - discount;
		
		ret = PriceHelper.roundToDecimalPlaces(ret, 2);
		
		for(PrintStream ps : out)
			ps.println("Total price:\t" + PriceHelper.getPrintFormat(ret));
			
		return ret;
	}
}
