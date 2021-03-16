package net.gf.bjss.good;

public enum Item {
	SOUP("Soup", 0.65f),
	BREAD("Bread", 0.8f),
	MILK("Milk", 1.3f),
	APPLES("Apples", 1.00f);
	
	private final String itemName;
	private final float price;
	
	private Item(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public float getPrice(){
		return price;
	}
}
