package bjss;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import net.gf.bjss.good.Item;
import net.gf.bjss.offrules.ApplesDiscount;
import net.gf.bjss.offrules.DiscountService;
import net.gf.bjss.offrules.BreadDiscount;
import net.gf.bjss.purchase.Basket;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseTest {
	private List<PrintStream> out;
	
	private DiscountService discountService;
	
	private Basket basket;
	
	private static int basketNumber = 0; 
	
	@Before
	public void setUp() throws Exception {
		out = new ArrayList<>();
		out.add(System.out);
		
		discountService = new DiscountService();
		discountService.addRule(new ApplesDiscount(0.1f));
		discountService.addRule(new BreadDiscount());
		
		basket = new Basket();
		
		basket.addItem(Item.BREAD);
		basket.addItem(Item.MILK);
		basket.addItem(Item.SOUP);
	}
	
	/**
	 * Test no discount.
	 */
	@Test
	public void test0() {
		
		for(PrintStream ps : out){
			ps.println();
			ps.println("Basket Number: " + basketNumber++);
		}
		
		float ret = basket.calculateTotalPrice(discountService, out);
		
		assertEquals(2.75, ret, 0.0001f);
	}
	
	/**
	 * Test apples discount. 
	 */
	@Test
	public void test1() {
		basket.addItem(Item.APPLES);
				
		for(PrintStream ps : out){
			ps.println();
			ps.println("Basket Number: " + basketNumber++);
		}
		
		float ret = basket.calculateTotalPrice(discountService, out);
		
		assertEquals(3.65, ret, 0.0001f);
	}

	/**
	 * Test bread discount
	 */
	@Test
	public void test2(){
		basket.addItem(Item.SOUP);
		
		for(PrintStream ps : out) {
			ps.println();
			ps.println("Basket Number: " + basketNumber++);
		}
		
		float ret = basket.calculateTotalPrice(discountService, out);
		
		assertEquals(3.0, ret, 0.0001f);
	}
	
	/**
	 * Test 4 tins of soup, 2 bread discount.
	 */
	@Test
	public void test3(){
		basket.addItem(Item.SOUP);
		basket.addItem(Item.APPLES);
		basket.addItem(Item.SOUP);
		basket.addItem(Item.BREAD);
		basket.addItem(Item.SOUP);
		
		for(PrintStream ps : out) {
			ps.println();
			ps.println("Basket Number: " + basketNumber++);
		}
		
		float ret = basket.calculateTotalPrice(discountService, out);
		
		assertEquals(5.6, ret, 0.0001f);
	}

}
