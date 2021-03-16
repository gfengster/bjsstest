package net.gf.bjss.offrules;

import java.io.PrintStream;
import java.util.List;

import net.gf.bjss.good.Item;

public class ApplesDiscount extends AbstractOffRule {
	
	private final float discoutPercent;
	
	public ApplesDiscount(float discoutPercent){
		super("Apples 10% off:");
		this.discoutPercent = discoutPercent;
	}
	
	@Override
	public float calculateOff(List<Item> purchases, List<PrintStream> out) {
		int count = 0;
		
		for(Item item : purchases) {
			if (item == Item.APPLES){
				count++;
			}
		}
		
		final float ret = count * Item.APPLES.getPrice() * discoutPercent;
		
		printDiscount(ret, out);
		
		return ret;
	}
}
