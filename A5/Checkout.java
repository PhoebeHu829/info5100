package Assignment5;
import java.util.ArrayList;

public class Checkout {
	private ArrayList<DessertItem> shopping_list;
	
	public Checkout() {
		this.shopping_list = new ArrayList<DessertItem>();
	}
	
	public int numberOfItems() {
		return this.shopping_list.size();
	}
	
	public void enterItem(DessertItem item) {
		this.shopping_list.add(item);
	}
	
	public void clear() {
		this.shopping_list.clear();
	}
	
	public int totalCost() {
		int cnt = 0;
		for (DessertItem d : this.shopping_list) {
			cnt += d.getCost();
		}
		return cnt;
	}
	
	public int totalTax() {
		return (int) Math.round(this.totalCost() * DessertShoppe.TAX_RATE);
	}
	
	public String toString() {
		String ans = DessertShoppe.SHOP_NAME + "\n";
		for (int i = 0; i < DessertShoppe.SHOP_NAME.length(); i++) {
			ans += "-";
		}
		ans += "\n\n";
		for (DessertItem item: this.shopping_list) {
			 ans += item.toString();
		}
		ans += "Tax " + DessertShoppe.cents2dollarsAndCents(this.totalTax()) + "\n";
		ans += "Totol Cost " + DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax()) + "\n";
		return ans;
	}
}

class DessertShoppe {
	static final String SHOP_NAME = "M & M Dessert Shoppe";
	static final double TAX_RATE = 0.065;
    static final int WIDTH = 1;
    static final int MAX_SIZE = 1;
        
	public static String cents2dollarsAndCents(int cents) {
		String ans = Integer.toString(cents);
		ans = (ans.length() == 1) ? "0" + ans : ans;
		String intPart = (ans.length() > 2) ? ans.substring(0, ans.length() - 2) : "";
		return  intPart + "." + ans.substring(ans.length() - 2);
	}
}

