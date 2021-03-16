package net.gf.bjss.offrules;

import java.io.PrintStream;
import java.util.List;

import net.gf.bjss.good.Item;

public class BreadDiscount extends AbstractOffRule {
	
	public BreadDiscount(){
		super("Buy 2 Soup tins, bread half price:");
	}
	
	@Override
	public float calculateOff(List<Item> purchases, List<PrintStream> out) {
		int cSoup = 0;
		int cBread = 0;
		
		for(Item item : purchases) {
			if(item == Item.SOUP) {
				cSoup++;
			} else if (item == Item.BREAD){
				cBread++;
			}
		}
		
		int halfCSoup = (int)Math.floor(cSoup/2);
		
		float ret = 0;
		if (cBread <= halfCSoup)
			ret = cBread*Item.BREAD.getPrice()*0.5f;
		else if (halfCSoup < cBread)
			ret = halfCSoup*Item.BREAD.getPrice()*0.5f;

		printDiscount(ret, out);
		
		return ret;
	}
}
