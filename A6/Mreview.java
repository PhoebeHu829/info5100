import java.util.*;

// https://condor.depaul.edu/ntomuro/courses/301/assign/hw1files/Mreview.html#compareTo(Mreview)
public class Mreview implements Comparable<Mreview>{
	private String title;
	private ArrayList<Integer> ratings;
	
	public Mreview() {
		this.title = "";
		this.ratings = new ArrayList<Integer>();
	}
	
	public Mreview(String title) {
		this();
		this.title = title;
	}
	
	public Mreview(String title, int firstRating) {
		this(title);
		this.ratings.add(firstRating);
	}
	
	public void addrating(int r) {
		this.ratings.add(r);
	}
	
	public double aveRating() {
		if( this.numRatings() == 0) {
			return 0;
		}
		double total = 0.0;
		for(int r : this.ratings) {
			total += r;
		}
		return (double) total / this.numRatings();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int numRatings() {
		return this.ratings.size();
	}
	
	@Override
	public int compareTo(Mreview obj) {
		return this.title.compareTo(obj.title);
	}
	
	@Override
	public boolean equals(java.lang.Object obj) {
		return this.title.equals( ((Mreview) obj).getTitle() );
	}
	
	@Override 
	public String toString() {
		return this.getTitle() + ", average " + this.aveRating() + " out of " + 
				this.numRatings() + " ratings.";
	}

	public static void main(String[] args) {
		Mreview test1 = new Mreview();
		System.out.println(test1.getTitle() + " " + test1.numRatings());
		
		Mreview killBill = new Mreview("killBill");
		System.out.println(killBill.getTitle() + " " + killBill.numRatings() + " " + killBill.aveRating());
		
		Mreview bill2 = new Mreview("bill2", 4);
		System.out.println(bill2.getTitle() + " " + bill2.numRatings() + " " + bill2.aveRating());
		
		System.out.println();
		int[] moview_reivew = new int[] {1, 2, 5, 7, 5};
		for( int i : moview_reivew) {
			bill2.addrating(i);
			System.out.println(bill2.toString());
		}
		
		Mreview killBill2 = new Mreview("killBill", 3);
		System.out.println(killBill.equals(bill2) + " " + killBill.equals(killBill2));
		
		System.out.println(killBill.compareTo(bill2) + " " + bill2.compareTo(killBill) + " " 
							+ killBill.compareTo(killBill2));
	}
}
