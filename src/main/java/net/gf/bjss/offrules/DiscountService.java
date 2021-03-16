package net.gf.bjss.offrules;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.gf.bjss.good.Item;
import net.gf.bjss.purchase.Basket;

public class DiscountService {
	private final Set<OffRule> offRules;
	
	public DiscountService(){
		offRules = new HashSet<OffRule>();
	}
	
	
	public void addRule(OffRule rule) {
		offRules.add(rule);
	}
	
	public void removeRules(OffRule rule) {
		offRules.remove(rule);
	}
	
	public float calculateDiscount(Basket basket, List<PrintStream> out) {
		List<Item> items = basket.getPurchaseItems();
		
		float discount = 0;
		
		for(OffRule rule : offRules) {
			discount += rule.calculateOff(items, out);
		}
		
		return discount;
	}
}
