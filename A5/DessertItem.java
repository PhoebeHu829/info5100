package Assignment5;

public abstract class DessertItem {
	protected String name;
	
	public DessertItem() {}
	
	public DessertItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract int getCost();
	
//	public static void main(String[] args) {
//		Candy c = new Candy("Peanut Butter Fudge", 2.25, 399);
//		//System.out.print(c.getName());
//		//System.out.println("\n" + c.getCost());
//		System.out.print(c);
//		
//		Cookie  cookie = new Cookie("Oatmeal Raisin Cookies", 4, 399);
//		System.out.print(cookie);
//		
//		Sundae s = new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50);
//		//System.out.println(s.getName());
//		System.out.print(s);
//		
//		IceCream ice = new IceCream("Vanilla Ice Cream", 105);
//		//System.out.println(ice.getName());
//		System.out.print(ice);
//		
//	}
}

class Candy extends DessertItem{
	private double weight;
	private int price_per_lb;
	
	public Candy(){
		super();
	};
	
	public Candy(String name, double weight, int price_per_lb) {
		super(name);
		this.weight = weight;
		this.price_per_lb = price_per_lb;
	}
	
	@Override
	public int getCost() {
		return (int) Math.round(this.weight * this.price_per_lb);
	}
	
	@Override
	public String toString() {
		String ans = this.weight + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(this.price_per_lb) + " /lb.";
		return ans + "\n" + this.getName() + " " + DessertShoppe.cents2dollarsAndCents(this.getCost()) +  "\n";
	}

}

class Cookie extends DessertItem {
	private int num;
	private int price_per_dozen;
	static int DOZEN = 12;
	
	public Cookie() {
		super();
	};
	
	public Cookie(String name, int num, int price_per_dozen) {
		super(name);
		this.num = num;
		this.price_per_dozen = price_per_dozen;
	}
	
	@Override
	public int getCost() {
		return (int) Math.round(((double) this.num / DOZEN ) * this.price_per_dozen);
	}
	
	@Override
	public String toString() {
		String ans = this.num + " @ " + DessertShoppe.cents2dollarsAndCents(this.price_per_dozen) + " /dz.";
		return ans + "\n" + this.getName() + " " + DessertShoppe.cents2dollarsAndCents(this.getCost()) + "\n";
	}
}


class IceCream extends DessertItem {
	private int cost;
	
	public IceCream() {
		super();
	}
	public IceCream(String name, int cost) {
		super(name);
		this.cost = cost;
	}
	
	@Override
	public int getCost() {
		return this.cost;
	}
	
	@Override
	public String toString() {
		return this.getName() + " " + DessertShoppe.cents2dollarsAndCents(this.getCost()) + "\n";
	}
}

class Sundae extends IceCream {
	private String topping;
	private int topping_cost;
	
	public Sundae() {
		super();
	}
	
	public Sundae (String name, int cost, String topping, int topping_cost) {
		super(name, cost);
		this.topping = topping;
		this.topping_cost = topping_cost;
		
	}

	@Override
	public int getCost() {
		return super.getCost() + this.topping_cost;
	}
	
	@Override
	public String toString() {
		return  this.topping + " Sundae with \n" + this.getName() + " " + 
				DessertShoppe.cents2dollarsAndCents(this.getCost()) + "\n";
	}
}




